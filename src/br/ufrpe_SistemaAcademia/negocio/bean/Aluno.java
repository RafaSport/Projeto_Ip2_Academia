package br.ufrpe_SistemaAcademia.negocio.bean;

import java.time.LocalDate;
import java.util.Objects;

public class Aluno extends Pessoa{
    
    private String matricula;
    private PlanoPagamento planoPagamento;
    private Professor professor;
    private PlanoTreinoSemanal planoTreino;

    public Aluno(String matricula, Professor professor, String nome, 
            String cpf, LocalDate dt_Nasc, String email) {
        
        super(nome, cpf, dt_Nasc, email);
        this.matricula = matricula;
        this.professor = professor;
    }

    
    public Aluno() {
    }

    public String getMatricula() {
        return matricula;
    }

    public PlanoPagamento getPlanoPagamento() {
        return planoPagamento;
    }

    public Professor getProfessor() {
        return professor;
    }

    public PlanoTreinoSemanal getPlanoTreino() {
        return planoTreino;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public void setPlanoTreino(PlanoTreinoSemanal planoTreino) {
        this.planoTreino = planoTreino;
    }
    
    public void setPlanoPagamento(PlanoPagamento planoPagamento) {
        this.planoPagamento = planoPagamento;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.matricula);
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
        final Aluno other = (Aluno) obj;
        return Objects.equals(this.matricula, other.matricula);
    }

    @Override
    public String toString() {
        return super.toString() + "\nAluno{" + "matricula=" + matricula + ", planoPagamento=" + planoPagamento 
                + ", professor=" + professor + '}';
    }
    
    
}
