package com.laissantiago.cursomc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ItemPedidoPK implements Serializable {

  private static final long serialVersionUID = 1877405568103832451L;

  @ManyToOne
  @JoinColumn(name = "pedido_id")
  private Pedido pedido;

  @ManyToOne
  @JoinColumn(name = "produto_id")
  private Produto produto;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ItemPedidoPK that = (ItemPedidoPK) o;
    return pedido.equals(that.pedido) && produto.equals(that.produto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pedido, produto);
  }
}
