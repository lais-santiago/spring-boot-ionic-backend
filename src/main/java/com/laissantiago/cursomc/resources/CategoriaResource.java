package com.laissantiago.cursomc.resources;

import com.laissantiago.cursomc.domain.Categoria;
import com.laissantiago.cursomc.dto.CategoriaDTO;
import com.laissantiago.cursomc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
  
  @Autowired
  private CategoriaService service;
  
  
  @GetMapping(value = "/{id}")
  public ResponseEntity<Categoria> find(@PathVariable Integer id){
    
    Categoria obj = service.find(id);
    return ResponseEntity.ok().body(obj);
    
  }
  
  @PostMapping
  public ResponseEntity<Void> insert(@RequestBody Categoria obj){
    obj = service.insert(obj);
    
    var uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(obj.getId()).toUri();
    
    return ResponseEntity.created(uri).build();
  }
  
  @PutMapping(value = "/{id}")
  public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id){
    obj.setId(id);
    service.update(obj);
    
    return ResponseEntity.noContent().build();
  }
  
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Integer id){
    service.delete(id);
    
    return ResponseEntity.noContent().build();
  }
  
  @GetMapping
  public ResponseEntity<List<CategoriaDTO>> findAll(){
    List<Categoria> list = service.findAll();
    List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
    
    return ResponseEntity.ok().body(listDTO);
  }
  
  @GetMapping(value = "/page")
  public ResponseEntity<Page<CategoriaDTO>> findPage(
      @RequestParam(value = "page", defaultValue = "0") Integer page,
      @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
      @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
      @RequestParam(value = "direction", defaultValue = "ASC") String direction){
    Page<Categoria> list = service.findPage(page, linesPerPage, orderBy, direction);
    Page<CategoriaDTO> listDTO = list.map(obj -> new CategoriaDTO(obj));
  
    return ResponseEntity.ok().body(listDTO);
  }
}
