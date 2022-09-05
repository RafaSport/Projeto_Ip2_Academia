package br.ufrpe_SistemaAcademia.negocio;

import br.ufrpe_SistemaAcademia.dados.IRepositorioGenerico;
import br.ufrpe_SistemaAcademia.dados.RepositorioGenerico;
import br.ufrpe_SistemaAcademia.negocio.bean.Aluno;
import br.ufrpe_SistemaAcademia.negocio.bean.Pessoa;
import br.ufrpe_SistemaAcademia.negocio.bean.Professor;
import java.util.List;

public class ControladorPessoa {
    
    private IRepositorioGenerico<Pessoa> repositorioPessoa;
    private static ControladorPessoa instance;

    private ControladorPessoa() {
        this.repositorioPessoa = new RepositorioGenerico<Pessoa>();
    }
    
    //Padrão Singleton
    public static ControladorPessoa getInstance() {
        if (instance == null) {
            instance = new ControladorPessoa();
        }
        return instance;
    }
    
    public void adicionar(Pessoa usuario, Pessoa p){
       this.repositorioPessoa.adicionar(usuario, p);
    }
    
    public void remover(Pessoa usuario, Pessoa p){
      this.repositorioPessoa.remover(usuario, p);
    }
    
    public void alterar(Pessoa usuario, Pessoa pessoaAtual, Pessoa pessoaAlterado){
        this.repositorioPessoa.alterar(usuario, pessoaAtual, pessoaAlterado);
    }
    
    public Object consultar(Pessoa usuario, Pessoa p){
        return this.repositorioPessoa.consultar(usuario, p);
    }
    
    public List<Pessoa> listarProfessor(Pessoa usuario){
        return (List<Pessoa>)(Professor)this.repositorioPessoa.listarProfessor(usuario);
    }

    public List<Pessoa> listarAlunos(Pessoa usuario) {
        return (List<Pessoa>)(Aluno)this.repositorioPessoa.listarAlunos(usuario);
    }

    public List<Pessoa> listarAlunosDoProfessor(Pessoa usuario) {
        return (List<Pessoa>)(Aluno)this.repositorioPessoa.listarAlunosDoProfessor(usuario);
    }
    
    public void cadastrarAlunoParaProfessor(Aluno a, Professor p){
        if(a.getProfessor().equals(p)){
            p.getAlunos().add(a);
        }else{
            //colocar exception
        }
    }
}
