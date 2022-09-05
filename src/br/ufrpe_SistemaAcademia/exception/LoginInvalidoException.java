package br.ufrpe_SistemaAcademia.exception;

public class LoginInvalidoException extends Exception{

    public LoginInvalidoException() {
        super("Login ou senha invalidos");
    }  
    
}
