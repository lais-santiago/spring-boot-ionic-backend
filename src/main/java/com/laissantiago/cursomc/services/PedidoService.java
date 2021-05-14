package com.laissantiago.cursomc.services;

import com.laissantiago.cursomc.domain.Pedido;
import com.laissantiago.cursomc.repositories.PedidoRepository;
import com.laissantiago.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {
  
  @Autowired
  private PedidoRepository repo;
  
  public Pedido buscar(Integer id){
    Optional<Pedido> obj = repo.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id +
        ", Tipo: " + Pedido.class.getName()));
  }
  
}
