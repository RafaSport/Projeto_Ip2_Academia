
package br.ufrpe_SistemaAcademia.gui;

import br.ufrpe_SistemaAcademia.dados.RepositorioArquivo;
import br.ufrpe_SistemaAcademia.exception.ElementoJaExisteException;
import br.ufrpe_SistemaAcademia.exception.ProfessorNaoContemAluno;
import br.ufrpe_SistemaAcademia.negocio.Fachada;
import br.ufrpe_SistemaAcademia.negocio.bean.Pessoa;
import br.ufrpe_SistemaAcademia.negocio.bean.TreinoExecutado;
import java.util.List;

public class ProgramaSistemaAcademia {
    
    public static void main(String[] args) throws ElementoJaExisteException, ProfessorNaoContemAluno {
        
        List<Pessoa> lista = (List<Pessoa>) RepositorioArquivo.carregarArquivoDePessoas("pessoas.dat");
        
        if(lista != null && !lista.isEmpty()){
            
            Fachada.getInstance().salvarPessoasNaMemoria(lista);
            new TelaInicial().setVisible(true);
            
        }else{
            
            new TelaDePrimeiroAcesso().setVisible(true);           
        }
               
        List<TreinoExecutado> lista1 = (List<TreinoExecutado>) 
                RepositorioArquivo.carregarArquivoDeTreinosExecutados("treinosExecutados.dat");
        
        if(lista1 != null && !lista1.isEmpty()){
            
            Fachada.getInstance().salvarTreinoExecutadoNaMemoria(lista1);
        }
        
    }    
        
}
