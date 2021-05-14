package com.laissantiago.cursomc.resources;

import com.laissantiago.cursomc.domain.Cliente;
import com.laissantiago.cursomc.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
  
  @Autowired
  private ClienteService service;
  
  @GetMapping(value = "/{id}")
  public ResponseEntity<Cliente> find(@PathVariable Integer id){
    
    Cliente obj = service.buscar(id);
    return ResponseEntity.ok().body(obj);
    
  }
}
