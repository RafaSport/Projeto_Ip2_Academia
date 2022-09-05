package br.ufrpe_SistemaAcademia.negocio.bean;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Pessoa {
    
    private String nome;
    private String cpf;
    private LocalDate dt_Nasc;
    private String email;

    public Pessoa(String nome, String cpf, LocalDate dt_Nasc, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.dt_Nasc = dt_Nasc;
        this.email = email;
    }
    
    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDt_Nasc() {
        return dt_Nasc;
    }

    public void setDt_Nasc(LocalDate dt_Nasc) {
        this.dt_Nasc = dt_Nasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.cpf);
        hash = 83 * hash + Objects.hashCode(this.email);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return Objects.equals(this.email, other.email);
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", cpf=" + cpf + ", dt_Nasc=" + dt_Nasc + ", email=" + email + '}';
    }
    
}
