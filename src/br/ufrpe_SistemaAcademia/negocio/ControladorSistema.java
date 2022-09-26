package br.ufrpe_SistemaAcademia.negocio;

import br.ufrpe_SistemaAcademia.negocio.bean.TipoTreino;
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
    
    public TipoTreino stringParaTipoTreino (String s){
        
        if(TipoTreino.AERÓBICA.toString().equals(s)){
            return TipoTreino.AERÓBICA;
            
        }else if(TipoTreino.BARRAS.toString().equals(s)){
            return TipoTreino.BARRAS;
            
        }else if(TipoTreino.BICICLETA.toString().equals(s)){
            return TipoTreino.BICICLETA;
            
        }else if(TipoTreino.ESTEIRA.toString().equals(s)){
            return TipoTreino.ESTEIRA;
            
        }else if(TipoTreino.MUSCULAÇÃO_BRAÇO.toString().equals(s)){
            return TipoTreino.MUSCULAÇÃO_BRAÇO;
            
        }else if(TipoTreino.MUSCULAÇÃO_COSTA.toString().equals(s)){
            return TipoTreino.MUSCULAÇÃO_COSTA;
            
        }else if(TipoTreino.MUSCULAÇÃO_GLUTEO.toString().equals(s)){
            return TipoTreino.MUSCULAÇÃO_GLUTEO;
            
        }else if(TipoTreino.MUSCULAÇÃO_PEITO.toString().equals(s)){
            return TipoTreino.MUSCULAÇÃO_PEITO;
            
        }else{
            return TipoTreino.MUSCULAÇÃO_PERNA;
        }
    }
    
    public String inteiroParaDiaDaSemana(int i){
        
        switch (i) {
            case 1:
                return "Segunda-Feira"; 
                
            case 2:
                return "Terça-Feira"; 
                
            case 3:
                return "Quarta-Feira"; 
            
            case 4:
                return "Quinta-Feira"; 
                
            case 5:
                return "Sexta-Feira"; 
                
            case 6:
                return "Sábado"; 
                
            default:
                return null;
        }
    }
}
