package com.laissantiago.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.laissantiago.cursomc.domain.enums.EstadoPagamento;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable {
  private static final long serialVersionUID = -1229825084843203053L;
  
  @Id
  private Integer id;
  private Integer estado;
  
  @JsonIgnore
  @OneToOne
  @JoinColumn(name = "pedido_id")
  @MapsId
  private Pedido pedido;
  
  protected Pagamento() {
  }
  
  protected Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
    this.id = id;
    this.estado = estado.getCod();
    this.pedido = pedido;
  }
  
}
