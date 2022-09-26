
package br.ufrpe_SistemaAcademia.negocio.bean;

public class Exercicio {
    
    private TipoTreino tipoExercicio;
    private Integer duracaoMinuto;
    private Integer serie;

    public Exercicio(TipoTreino tipoExercicio, Integer duracao, Integer serie) {
        this.tipoExercicio = tipoExercicio;
        this.duracaoMinuto = duracao;
        this.serie = serie;
    }

    public Exercicio() {
    }

    public TipoTreino getTipoExercicio() {
        return tipoExercicio;
    }

    public void setTipoExercicio(TipoTreino tipoExercicio) {
        this.tipoExercicio = tipoExercicio;
    }

    public Integer getDuracao() {
        return duracaoMinuto;
    }

    public void setDuracao(Integer duracao) {
        this.duracaoMinuto = duracao;
    }

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Exercicio other = (Exercicio) obj;
        return this.tipoExercicio == other.tipoExercicio;
    }

    
    
    @Override
    public String toString() {
        return "Exercicio{" + "tipoExercicio=" + tipoExercicio + ", duracao=" + duracaoMinuto + ", serie=" + serie + '}';
    }
    
}
