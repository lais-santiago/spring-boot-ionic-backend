package com.laissantiago.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.laissantiago.cursomc.domain.enums.EstadoPagamento;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@Entity
@EqualsAndHashCode
public class PagamentoComBoleto extends Pagamento{
  private static final long serialVersionUID = -1229825084843203053L;
  
  @JsonFormat(pattern = "dd/MM/yyyy")
  private Date dataVencimento;
  
  @JsonFormat(pattern = "dd/MM/yyyy")
  private Date dataPagamento;
  
  public PagamentoComBoleto() {
  }
  
  public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
    super(id, estado, pedido);
    this.dataVencimento = dataVencimento;
    this.dataPagamento = dataPagamento;
  }
  
}
