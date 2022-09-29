package br.ufrpe_SistemaAcademia.negocio;

import br.ufrpe_SistemaAcademia.dados.IRepositorioGenerico;
import br.ufrpe_SistemaAcademia.dados.RepositorioGenerico;
import br.ufrpe_SistemaAcademia.exception.ElementoJaExisteException;
import br.ufrpe_SistemaAcademia.exception.ElementoNaoExisteException;
import br.ufrpe_SistemaAcademia.negocio.bean.Aluno;
import br.ufrpe_SistemaAcademia.negocio.bean.Gerente;
import br.ufrpe_SistemaAcademia.negocio.bean.Pessoa;
import br.ufrpe_SistemaAcademia.negocio.bean.Professor;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
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
    
    public void adicionar(Pessoa usuario, Pessoa p) throws ElementoJaExisteException{
       this.repositorioPessoa.adicionar(usuario, p);
    }
    
    public void remover(Pessoa usuario, Pessoa p) throws ElementoNaoExisteException{
      this.repositorioPessoa.remover(usuario, p);
    }
    
    public void alterar(Pessoa usuario, Pessoa pessoaAtual, Pessoa pessoaAlterado) 
            throws ElementoNaoExisteException{
        
        this.repositorioPessoa.alterar(usuario, pessoaAtual, pessoaAlterado);
    }
    
    public Object consultar(Pessoa usuario, Pessoa p) throws ElementoNaoExisteException{
        return this.repositorioPessoa.consultar(usuario, p);
    }
    
    public List<Pessoa> listarProfessor(Pessoa usuario){
        return (List<Pessoa>)this.repositorioPessoa.listarProfessor(usuario);
    }

    public List<Pessoa> listarAlunos(Pessoa usuario) {
        return (List<Pessoa>)this.repositorioPessoa.listarAlunos(usuario);
    }

    public List<Pessoa> listarAlunosDoProfessor(Pessoa usuario) {
        return (List<Pessoa>)this.repositorioPessoa.listarAlunosDoProfessor(usuario);
    }
    
    public List<Pessoa> listarTodos(){
        return this.repositorioPessoa.listarTodos();
    }
    
    public void salvarPessoasNamemoria(List<Pessoa> dadosArquivo){
        this.repositorioPessoa.salvarPessoasNaMemoria(dadosArquivo);
    }
    
    public void cadastrarAlunoParaProfessor(Aluno a, Professor p){
        if(a.getProfessor().equals(p)){
            p.getAlunos().add(a);
        }else{
            //colocar exception
        }
    }
    
    public Pessoa login(String email, String senha){
        
        Pessoa usuario = null;

        for(Pessoa p: this.listarTodos()){
            
            if(p.getEmail().equals(email)){
                
                if(p instanceof Gerente && ((Gerente)p).getSenha().equals(senha) ){
                    int i = this.listarTodos().indexOf(p);
                    
                    usuario = this.listarTodos().get(i);
                    
                }else if(p instanceof Professor && ((Professor)p).getSenha().equals(senha)){
                    int i = this.listarTodos().indexOf(p);
                    
                    usuario = this.listarTodos().get(i);
                }else if(p instanceof Aluno && ((Aluno)p).getMatricula().equals(senha)){
                    int i = this.listarTodos().indexOf(p);
                    
                    usuario = this.listarTodos().get(i);
                }
            }
        }
        return usuario;
    }

    
    public boolean pagamentoEmDiaDoAluno(Aluno aluno){
        
        LocalDate dataFinalPlano = aluno.getPlanoPagamento().getDataFim();
        LocalDate hoje = LocalDate.now();
        
        Period periodo = Period.between(hoje, dataFinalPlano );
        
        return periodo.isNegative();
        
    }
    
   
    public Professor escolheProfessorParaAluno(Pessoa p){
        
        List<Pessoa> lista = new ArrayList<>();
        int qtdAlunos = Integer.MAX_VALUE;
        
        if(p instanceof Gerente){
            
            lista = Fachada.getInstance().listarProfessor(p);
        }
        
        Professor prof = (Professor)lista.get(0);
        
        for(Pessoa pessoa: lista){
            
            if( ((Professor)pessoa).getAlunos().size() <= qtdAlunos ){
                prof = (Professor)pessoa;
            }
        }
        
        return prof;
    }


    public boolean equals(Pessoa pessoa, Pessoa usuario){
        
        if( pessoa instanceof Aluno){
            
            for( Pessoa p : Fachada.getInstance().listarAlunos(usuario)){
                
                if( p.getCpf().equals(pessoa.getCpf()) || p.getEmail().equals(pessoa.getEmail())
                            || ((Aluno)p).getMatricula().equals( ((Aluno)pessoa).getMatricula() ) ){
                    
                    return true;
                }
            }
        }
        
        if( pessoa instanceof Professor){
            
            for( Pessoa p : Fachada.getInstance().listarProfessor(usuario)){
                
                if( p.getCpf().equals(pessoa.getCpf()) || p.getEmail().equals(pessoa.getEmail())
                   || ((Professor)p).getId_Professor().equals(((Professor)pessoa).getId_Professor() ) 
                   || ((Professor)p).getSenha().equals(((Professor)pessoa).getSenha() ) ){
                    
                    return true;
                }
            }
        }
        
        
        return false;
    }
    
}

    
