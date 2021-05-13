package com.laissantiago.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.laissantiago.cursomc.domain.enums.EstadoPagamento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PagamentoComBoleto that = (PagamentoComBoleto) o;
        return dataVencimento.equals(that.dataVencimento) && dataPagamento.equals(that.dataPagamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dataVencimento, dataPagamento);
    }
}
