package Model;

import java.util.Date;

public class Pagamentos extends Plano {

    private Date dataPagamento;
    private Date dataVencimento;
    private Enum formaPagamento;

    //Métodos acessores
    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Enum getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(Enum formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

}
