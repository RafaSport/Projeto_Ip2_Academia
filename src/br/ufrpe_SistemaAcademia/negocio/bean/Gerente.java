package br.ufrpe_SistemaAcademia.negocio.bean;

import java.time.LocalDate;
import java.util.Objects;

public class Gerente extends Pessoa{
    
    private String senha;

    public Gerente(String senha, String nome, String cpf, LocalDate dt_Nasc, String email) {
        super(nome, cpf, dt_Nasc, email);
        this.senha = senha;
    }

    public Gerente() {
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.senha);
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
        final Gerente other = (Gerente) obj;
        return Objects.equals(this.senha, other.senha);
    }

    @Override
    public String toString() {
        return super.toString() + "\nGerente{" + "senha=" + senha + '}';
    }
    
}
