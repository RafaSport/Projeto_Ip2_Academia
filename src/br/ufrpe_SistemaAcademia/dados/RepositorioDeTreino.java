package br.ufrpe_SistemaAcademia.dados;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeTreino <TreinoExecutado> {
    
    protected List<TreinoExecutado> lista;

    public RepositorioDeTreino() {
        this.lista = new ArrayList<>();
    }
    
    public void salvarTreinoExecutado(TreinoExecutado treinoExecutado){
        if(!this.lista.contains(treinoExecutado)){
            this.lista.add(treinoExecutado);
        }else{
            //colocar exception
            System.out.println("Treino ja esta salvo");
        }
    }
    
    public TreinoExecutado consultarTreinoExecutado(TreinoExecutado treinoExecutado){
        
        TreinoExecutado te = null;
        
        for(TreinoExecutado t: this.lista){
            if(t.equals(treinoExecutado)){
                te = t;
            }
        }
        return te;
    }
}
