
package br.ufrpe_SistemaAcademia.dados;

import br.ufrpe_SistemaAcademia.exception.ElementoJaExisteException;
import br.ufrpe_SistemaAcademia.exception.ElementoNaoExisteException;
import java.util.List;

public interface IRepositorioGenerico <T>{
    
    void adicionar(T usuario, T obj)throws ElementoJaExisteException;
    void remover(T usuario, T obj)throws ElementoNaoExisteException;
    void alterar(T usuario, T objAtual, T objAlterado)throws ElementoNaoExisteException;
    T consultar(T usuario, T obj)throws ElementoNaoExisteException;
    List<T> listarProfessor(T usuario);
    List<T> listarAlunos(T usuario);
    List<T> listarAlunosDoProfessor(T usuario);
    List<T> listarTodos();
    void salvarPessoasNaMemoria(List<T> lista) ;
    
}
