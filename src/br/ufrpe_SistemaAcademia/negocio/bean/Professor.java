package br.ufrpe_SistemaAcademia.negocio.bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Professor extends Pessoa{
    
    private String id_Professor;
    private String senha;
    private Double salario;
    
    private List<Aluno> alunos;

    public Professor(String id_Professor, String senha, Double salario, 
            String nome, String cpf, LocalDate dt_Nasc, String email) {
        
        super(nome, cpf, dt_Nasc, email);
        this.id_Professor = id_Professor;
        this.senha = senha;
        this.salario = salario;
        
        this.alunos = new ArrayList<>();
    }
    
    public Professor() {
    }

    public String getId_Professor() {
        return id_Professor;
    }

    public void setId_Professor(String id_Professor) {
        this.id_Professor = id_Professor;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id_Professor);
        hash = 41 * hash + Objects.hashCode(this.senha);
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
        final Professor other = (Professor) obj;
        if (!Objects.equals(this.id_Professor, other.id_Professor)) {
            return false;
        }
        return Objects.equals(this.senha, other.senha);
    }

    @Override
    public String toString() {
        return super.toString() + "\nProfessor{" + "id_Professor=" + id_Professor + ", senha=" + senha + ", salario=" + salario + '}';
    }
    
}
