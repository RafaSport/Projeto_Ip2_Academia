package br.ufrpe_SistemaAcademia.dados;

import br.ufrpe_SistemaAcademia.exception.ElementoJaExisteException;
import br.ufrpe_SistemaAcademia.exception.ElementoNaoExisteException;
import br.ufrpe_SistemaAcademia.negocio.bean.Aluno;
import br.ufrpe_SistemaAcademia.negocio.bean.TreinoExecutado;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeTreino <TreinoExecutado> {
    
    protected List<TreinoExecutado> lista;

    public RepositorioDeTreino() {
        this.lista = new ArrayList<>();
    }
    
    public void salvarTreinoExecutado(TreinoExecutado treinoExecutado)throws ElementoJaExisteException{
        if(!this.lista.contains(treinoExecutado)){
            this.lista.add(treinoExecutado);
        }else{
            throw new ElementoJaExisteException(treinoExecutado);
        }
    }
    
    public TreinoExecutado consultarTreinoExecutado(TreinoExecutado treinoExecutado)
                            throws ElementoNaoExisteException{
        
        
        if(this.lista.contains(treinoExecutado)){
            int x = this.lista.indexOf(treinoExecutado);
            return this.lista.get(x);
            
        }else{
            throw new ElementoNaoExisteException(treinoExecutado);
        }
       
    }
}
