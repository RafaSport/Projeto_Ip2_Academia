package br.ufrpe_SistemaAcademia.negocio.bean;

import java.time.LocalDate;
import java.util.Objects;

public class TreinoExecutado {
    
    private Aluno aluno;
    private Treino treino;
    private LocalDate diaDoTreinoRealizado;

    public TreinoExecutado(Aluno aluno, Treino treino, LocalDate diaDoTreinoRealizado) {
        this.aluno = aluno;
        this.treino = treino;
        this.diaDoTreinoRealizado = diaDoTreinoRealizado;
    }

    public TreinoExecutado(Aluno aluno, LocalDate diaDoTreinoRealizado) {
        this.aluno = aluno;
        this.diaDoTreinoRealizado = diaDoTreinoRealizado;
    }

    public TreinoExecutado() {
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Treino getTreino() {
        return treino;
    }

    public LocalDate getDiaDoTreinoRealizado() {
        return diaDoTreinoRealizado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.aluno);
        hash = 13 * hash + Objects.hashCode(this.diaDoTreinoRealizado);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TreinoExecutado other = (TreinoExecutado) obj;
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        return Objects.equals(this.diaDoTreinoRealizado, other.diaDoTreinoRealizado);
    }
    
}
