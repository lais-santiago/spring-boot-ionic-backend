package com.laissantiago.cursomc.dto;

import com.laissantiago.cursomc.domain.Categoria;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CategoriaDTO implements Serializable {
  private static final long serialVersionUID = -1503124395536907848L;
  
  private Integer id;
  private String nome;
  
  public CategoriaDTO(Categoria obj){
    id = obj.getId();
    nome = obj.getNome();
  }
}
