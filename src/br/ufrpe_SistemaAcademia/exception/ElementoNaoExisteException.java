package br.ufrpe_SistemaAcademia.exception;

public class ElementoNaoExisteException extends Exception{
    
    private Object elemento;

    public ElementoNaoExisteException(Object elemento) {
        super("Objeto nao esta cadastrado!");
        this.elemento = elemento;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
    
}
