package com.laissantiago.cursomc.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@EqualsAndHashCode
public class Categoria implements Serializable {
  
  private static final long serialVersionUID = -3510391839707867552L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  
  @ManyToMany(mappedBy = "categorias")
  private List<Produto> produtos = new ArrayList<>();
  
  public Categoria(){}
  
  public Categoria(Integer id, String nome) {
    this.id = id;
    this.nome = nome;
  }
  
}
