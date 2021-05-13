package com.laissantiago.cursomc.resources;

import com.laissantiago.cursomc.domain.Pedido;
import com.laissantiago.cursomc.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> find(@PathVariable Integer id){

        Pedido obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);

    }
}
