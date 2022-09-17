package br.ufrpe_SistemaAcademia.negocio;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JTable;

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
    
    public LocalDate stringParaLocalDate (String s)throws DateTimeParseException{
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(s, formatter);
        
        return data;
    }
    
    public boolean dataNaValidade(LocalDate dataLimite, LocalDate dataParaVerificar){
        
        Period periodo = Period.between(dataLimite, dataParaVerificar );
        
        return periodo.isNegative();
    }
    
    public void apagarTabela(JTable tabela, int qtdColuna){
        
        for(int i = 0; i < qtdColuna; i++ ){

            tabela.setValueAt("", i, 0);
            tabela.setValueAt("", i, 1);
            tabela.setValueAt("", i, 2);
        }
        
    }
}
