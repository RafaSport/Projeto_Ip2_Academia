package br.ufrpe_SistemaAcademia.negocio;

import br.ufrpe_SistemaAcademia.dados.RepositorioDeTreino;
import br.ufrpe_SistemaAcademia.negocio.bean.TreinoExecutado;

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

    public void salvarTreinoExecutado(TreinoExecutado treinoExecutado) {
        this.repositorioDeTreinos.salvarTreinoExecutado(treinoExecutado);
    }

    public TreinoExecutado consultarTreinoExecutado(TreinoExecutado treinoExecutado) {
        return this.repositorioDeTreinos.consultarTreinoExecutado(treinoExecutado);
    }
    
    
}
