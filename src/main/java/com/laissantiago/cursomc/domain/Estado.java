package com.laissantiago.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Estado implements Serializable {
  
  private static final long serialVersionUID = 3348149032924559185L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  
  @JsonIgnore
  @OneToMany(mappedBy = "estado")
  private List<Cidade> cidades = new ArrayList<>();
  
  public Estado() {
  }
  
  public Estado(Integer id, String nome) {
    this.id = id;
    this.nome = nome;
  }
  
}
