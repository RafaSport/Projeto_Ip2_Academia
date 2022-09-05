package br.ufrpe_SistemaAcademia.exception;

public class ElementoJaExisteException extends Exception{
    
    private Object elemento;

    public ElementoJaExisteException(Object elemento) {
        super("Objeto ja esta cadastrado!");
        this.elemento = elemento;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
    
}
