
package br.ufrpe_SistemaAcademia.negocio.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Treino implements Serializable{
    
    private List<Exercicio> exercicios;

    public Treino() {
        
        this.exercicios = new ArrayList<>();
    }

    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<Exercicio> exercicios) {
        this.exercicios.addAll(exercicios);
    }

    public void addExercicios(Exercicio e) {
        this.exercicios.add(e);
    }

    @Override
    public String toString() {
        return "Treino{" + " exercicios = " + exercicios + '}';
    }
    
}
