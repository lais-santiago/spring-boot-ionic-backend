package com.laissantiago.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Getter
@Setter
@Entity
@EqualsAndHashCode
public class ItemPedido implements Serializable {
  private static final long serialVersionUID = 8906305748891014517L;

  @JsonIgnore
  @EmbeddedId
  private ItemPedidoPK id = new ItemPedidoPK();

  private Double desconto;
  private Integer quantidade;
  private Double preco;

  public ItemPedido() {
  }

  public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
    id.setPedido(pedido);
    id.setProduto(produto);
    this.desconto = desconto;
    this.quantidade = quantidade;
    this.preco = preco;
  }

  @JsonIgnore
  public Pedido getPedido(){
    return id.getPedido();
  }
  
}
