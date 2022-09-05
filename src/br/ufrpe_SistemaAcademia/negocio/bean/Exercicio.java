
package br.ufrpe_SistemaAcademia.negocio.bean;

public class Exercicio {
    
    private String tipoExercicio;
    private Integer duracaoMinuto;
    private Integer serie;

    public Exercicio(String tipoExercicio, Integer duracao, Integer serie) {
        this.tipoExercicio = tipoExercicio;
        this.duracaoMinuto = duracao;
        this.serie = serie;
    }

    public Exercicio() {
    }

    public String getTipoExercicio() {
        return tipoExercicio;
    }

    public void setTipoExercicio(String tipoExercicio) {
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
    public String toString() {
        return "Exercicio{" + "tipoExercicio=" + tipoExercicio + ", duracao=" + duracaoMinuto + ", serie=" + serie + '}';
    }
    
}
