package com.laissantiago.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.laissantiago.cursomc.domain.enums.TipoCliente;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Getter
@Setter
@Entity
@EqualsAndHashCode
public class Cliente implements Serializable {
  
  private static final long serialVersionUID = -978284132517589594L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private String email;
  private String cpfOuCnpj;
  private Integer tipo;
  
  @OneToMany(mappedBy = "cliente")
  private List<Endereco> enderecos = new ArrayList<>();
  
  @ElementCollection
  @CollectionTable(name = "TELEFONE")
  private Set<String> telefones = new HashSet<>();
  
  @JsonIgnore
  @OneToMany(mappedBy = "cliente")
  private List<Pedido> pedidos = new ArrayList<>();
  
  public Cliente() {
  }
  
  public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipoCliente) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.cpfOuCnpj = cpfOuCnpj;
    this.tipo = tipoCliente.getCod();
  }
  
}
