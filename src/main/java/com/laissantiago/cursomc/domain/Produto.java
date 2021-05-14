package com.laissantiago.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Produto implements Serializable {

  private static final long serialVersionUID = -8335883823682131930L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private Double preco;

  @JsonIgnore
  @ManyToMany
  @JoinTable(name = "PRODUTO_CATEGORIA",
      joinColumns = @JoinColumn(name = "produto_id"),
      inverseJoinColumns = @JoinColumn(name = "categoria_id")
  )
  private List<Categoria> categorias = new ArrayList<>();

  public Produto() {
  }

  public Produto(Integer id, String nome, Double preco) {
    this.id = id;
    this.nome = nome;
    this.preco = preco;
  }

  @JsonIgnore
  @OneToMany(mappedBy = "id.produto")
  private Set<ItemPedido> itens = new HashSet<>();

  @JsonIgnore
  public List<Pedido> getPedidos(){
    List<Pedido> lista = new ArrayList<>();

    for(ItemPedido x : itens){
      lista.add(x.getPedido());
    }

    return lista;
  }
  
}
