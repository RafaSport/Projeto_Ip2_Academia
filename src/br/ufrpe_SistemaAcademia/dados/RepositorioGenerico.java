
package br.ufrpe_SistemaAcademia.dados;

import br.ufrpe_SistemaAcademia.exception.ElementoJaExisteException;
import br.ufrpe_SistemaAcademia.exception.ElementoNaoExisteException;
import br.ufrpe_SistemaAcademia.negocio.bean.Aluno;
import br.ufrpe_SistemaAcademia.negocio.bean.Gerente;
import br.ufrpe_SistemaAcademia.negocio.bean.Professor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioGenerico <T> implements IRepositorioGenerico<T>{

    protected List<T> lista;

    public RepositorioGenerico() {
        this.lista = new ArrayList<>();
    }
    
    
    @Override
    public void adicionar(T usuario, T obj) throws ElementoJaExisteException{
        
        if(usuario instanceof Gerente){
            if(!this.lista.contains(obj)){
                
                this.lista.add(obj);
            }else{               
                throw new ElementoJaExisteException(obj);
            }
        }
        
    }

    @Override
    public void remover(T usuario, T obj) throws ElementoNaoExisteException{
        if(usuario instanceof Gerente){
            if(this.lista.contains(obj)){
                this.lista.remove(obj);
            }else{
                throw new ElementoNaoExisteException(obj);
            }
        }
        
    }

    @Override
    public void alterar(T usuario, T objAtual, T objAlterado)throws ElementoNaoExisteException {
        if(usuario instanceof Gerente){
            if(this.lista.contains(objAtual)){
                this.lista.remove(objAtual);
                objAtual = objAlterado;
                this.lista.add(objAtual);

            }else{
                throw new ElementoNaoExisteException(objAtual);
            }
        }
        
    }

    @Override
    public T consultar(T usuario, T obj) throws ElementoNaoExisteException{
        if(usuario instanceof Gerente){
            
            if(this.lista.contains(obj)){
                int x = this.lista.indexOf(obj);
                return this.lista.get(x);
            }else{
                throw new ElementoNaoExisteException(obj);
            }
            
        }else if(usuario instanceof Professor){
            
            if(obj instanceof Aluno && this.lista.contains(obj) ){
                int x = this.lista.indexOf(obj);
                Aluno aluno = (Aluno)this.lista.get(x);
                
                if( aluno.getProfessor().equals(usuario) ){
                    return this.lista.get(x);
                }
                
            }else{
                throw new ElementoNaoExisteException(obj);
            }
        }
        return null;
    }

    @Override
    public List<T> listarProfessor(T usuario) {
        
        List<T> listaDeProfessor = new ArrayList<>();
        
        if(usuario instanceof Gerente){
            for (T t : lista) {
                if(t instanceof Professor){
                    listaDeProfessor.add(t);
                }
            }
        }
        return Collections.unmodifiableList(listaDeProfessor);
    }

    @Override
    public List<T> listarAlunos(T usuario) {
        
        List<T> listaDeAluno = new ArrayList<>();
        
        if(usuario instanceof Gerente){
            for (T t : lista) {
                if(t instanceof Aluno){
                    listaDeAluno.add(t);
                }
            }
        }
        return Collections.unmodifiableList(listaDeAluno);
    }

    @Override
    public List<T> listarAlunosDoProfessor(T usuario) {
        
        List<T> listaDeAluno = new ArrayList<>();
        
        if(usuario instanceof Professor){
            for (T t : lista) {
                if(t instanceof Aluno && ((Aluno)t).getProfessor().equals( (Professor)usuario ) ){
                    listaDeAluno.add( t );
                } else {
                }
            }
        }
        return Collections.unmodifiableList(listaDeAluno);
    }

    @Override
    public List<T> listarTodos() {
        return Collections.unmodifiableList(this.lista);
    }
    
}
