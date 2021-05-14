package com.laissantiago.cursomc.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@EqualsAndHashCode
public class Cidade implements Serializable {
  private static final long serialVersionUID = 2346755893923322916L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  
  @ManyToOne
  @JoinColumn(name = "ESTADO_ID")
  private Estado estado;
  
  public Cidade() {
  }
  
  public Cidade(Integer id, String nome, Estado estado) {
    this.id = id;
    this.nome = nome;
    this.estado = estado;
  }

}
