
package br.ufrpe_SistemaAcademia.negocio.bean;

import java.time.LocalDate;

public class PlanoPagamento {
    
    private Double valorMensal;
    private Integer qtdMesPago;
    private LocalDate dataInicio;

    public PlanoPagamento(Double valorMensal, Integer qtdMesPago, LocalDate dataInicio) {
        this.valorMensal = valorMensal;
        this.qtdMesPago = qtdMesPago;
        this.dataInicio = dataInicio;
    }

    public PlanoPagamento() {
    }

    public Double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(Double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public Integer getQtdMesPago() {
        return qtdMesPago;
    }

    public void setQtdMesPago(Integer qtdMesPago) {
        this.qtdMesPago = qtdMesPago;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Override
    public String toString() {
        return "PlanoPagamento{" + "valorMensal=" + valorMensal + ", qtdMesPago=" + qtdMesPago + ", dataInicio=" + dataInicio + '}';
    } 
   
}
