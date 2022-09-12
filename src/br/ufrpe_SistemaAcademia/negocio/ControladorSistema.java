package br.ufrpe_SistemaAcademia.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ControladorSistema {
    
    private static ControladorSistema instance;

    private ControladorSistema() {
    }
    
     //padrao Singleton
    public static ControladorSistema getInstance(){
        if (instance == null) {
            instance = new ControladorSistema();
        }
        return instance;
    }
    
     public String dataParaString(LocalDate d){
        LocalDate data = d;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFim = data.format(formatter);  
        
        return dataFim;
    }
    
    public LocalDate stringParaLocalDate (String s){
        return null;
    }
}
