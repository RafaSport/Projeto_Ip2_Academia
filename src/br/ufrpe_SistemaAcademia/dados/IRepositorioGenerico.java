
package br.ufrpe_SistemaAcademia.dados;

import java.util.List;

public interface IRepositorioGenerico <T>{
    
    void adicionar(T usuario, T obj);
    void remover(T usuario, T obj);
    void alterar(T usuario, T objAtual, T objAlterado);
    T consultar(T usuario, T obj);
    List<T> listarProfessor(T usuario);
    List<T> listarAlunos(T usuario);
    List<T> listarAlunosDoProfessor(T usuario);
    
}
