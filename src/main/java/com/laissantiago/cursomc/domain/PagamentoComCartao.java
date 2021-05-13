package com.laissantiago.cursomc.domain;

import com.laissantiago.cursomc.domain.enums.EstadoPagamento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PagamentoComCartao that = (PagamentoComCartao) o;
        return numeroParcelas == that.numeroParcelas;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numeroParcelas);
    }
}
