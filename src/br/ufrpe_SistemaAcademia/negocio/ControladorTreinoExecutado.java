package br.ufrpe_SistemaAcademia.negocio;

import br.ufrpe_SistemaAcademia.dados.RepositorioDeTreino;
import br.ufrpe_SistemaAcademia.exception.ElementoJaExisteException;
import br.ufrpe_SistemaAcademia.exception.ElementoNaoExisteException;
import br.ufrpe_SistemaAcademia.negocio.bean.TreinoExecutado;
import java.util.List;

public class ControladorTreinoExecutado {
    
    private static ControladorTreinoExecutado instance;
    private RepositorioDeTreino<TreinoExecutado> repositorioDeTreinos;

    private ControladorTreinoExecutado() {
        this.repositorioDeTreinos = new RepositorioDeTreino<>();
    }
    
    public static ControladorTreinoExecutado getInstance(){
        if (instance == null) {
            instance = new ControladorTreinoExecutado();
        }
        return instance;
    }

    public void salvarTreinoExecutado(TreinoExecutado treinoExecutado) 
            throws ElementoJaExisteException {
        
        this.repositorioDeTreinos.salvarTreinoExecutado(treinoExecutado);
    }

    public TreinoExecutado consultarTreinoExecutado(TreinoExecutado treinoExecutado) 
            throws ElementoNaoExisteException {
        
        return this.repositorioDeTreinos.consultarTreinoExecutado(treinoExecutado);
    }
    
    public List<TreinoExecutado> listarTodosOsTreinosExecutados(){
        return this.repositorioDeTreinos.listarTodosOsTreinosExecutados();
    }
    
    public void salvarTreinoExecutadoNaMemoria(List<TreinoExecutado> dadosArquivo){
        this.repositorioDeTreinos.salvarTreinoExecutadoNaMemoria(dadosArquivo);
    }
}
