package br.ufrpe_SistemaAcademia.exception;

public class ProfessorNaoContemAluno extends Exception{
    
    private Object elemento;

    public ProfessorNaoContemAluno(Object elemento) {
        super("Aluno nao cadastrado para este professor");
        this.elemento = elemento;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
    
}
