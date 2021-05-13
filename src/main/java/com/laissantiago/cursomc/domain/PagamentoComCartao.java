package com.laissantiago.cursomc.domain;

import com.laissantiago.cursomc.domain.Enums.EstadoPagamento;

import javax.persistence.Entity;

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

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }
}
