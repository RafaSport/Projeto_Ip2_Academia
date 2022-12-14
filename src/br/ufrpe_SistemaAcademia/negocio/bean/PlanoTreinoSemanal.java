package br.ufrpe_SistemaAcademia.negocio.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlanoTreinoSemanal implements Serializable{
    
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
        this.dataFim = this.dataInicio.plusDays(15);
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setTreinos(List<Treino> treinos) {
        this.treinos = treinos;
    }
    
    @Override
    public String toString() {
        return "PlanoTreinoSemanal{" + "treinos=" + treinos + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + '}';
    }
    
    
}
