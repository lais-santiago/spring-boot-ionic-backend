package com.laissantiago.cursomc.domain;

import com.laissantiago.cursomc.domain.enums.EstadoPagamento;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class PagamentoComCartao extends Pagamento{
  private static final long serialVersionUID = -1229825084843203053L;
  
  private int numeroParcelas;
  
  public PagamentoComCartao() {
  }
  
  public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, int numeroParcelas) {
    super(id, estado, pedido);
    this.numeroParcelas = numeroParcelas;
  }
  
}
