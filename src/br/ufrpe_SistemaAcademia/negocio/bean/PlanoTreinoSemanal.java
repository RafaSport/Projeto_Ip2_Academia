package br.ufrpe_SistemaAcademia.negocio.bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlanoTreinoSemanal {
    
    private List<Treino> treinos;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public PlanoTreinoSemanal(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
        
        this.treinos = new ArrayList<>();
        this.dataFim = this.dataInicio.plusDays(15);
    }

    public PlanoTreinoSemanal() {
    }  

    public List<Treino> getTreinos() {
        return treinos;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    @Override
    public String toString() {
        return "PlanoTreinoSemanal{" + "treinos=" + treinos + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + '}';
    }
    
    
}
