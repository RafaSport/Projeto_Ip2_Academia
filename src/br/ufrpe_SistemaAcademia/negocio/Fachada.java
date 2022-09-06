package br.ufrpe_SistemaAcademia.negocio;

import br.ufrpe_SistemaAcademia.exception.ElementoJaExisteException;
import br.ufrpe_SistemaAcademia.exception.ElementoNaoExisteException;
import br.ufrpe_SistemaAcademia.exception.LoginInvalidoException;
import br.ufrpe_SistemaAcademia.exception.ProfessorNaoContemAluno;
import br.ufrpe_SistemaAcademia.negocio.bean.Aluno;
import br.ufrpe_SistemaAcademia.negocio.bean.Exercicio;
import br.ufrpe_SistemaAcademia.negocio.bean.Pessoa;
import br.ufrpe_SistemaAcademia.negocio.bean.PlanoTreinoSemanal;
import br.ufrpe_SistemaAcademia.negocio.bean.Professor;
import br.ufrpe_SistemaAcademia.negocio.bean.Treino;
import br.ufrpe_SistemaAcademia.negocio.bean.TreinoExecutado;
import java.time.LocalDate;
import java.util.List;

public class Fachada {
    
    private static Fachada instance;
    
    private ControladorPessoa controladorPessoa;
    private ControladorTreino controladorTreino;
    private ControladorTreinoExecutado controladorTreinoExecutado;

    private Fachada() {
        this.controladorPessoa = ControladorPessoa.getInstance();
        this.controladorTreino = ControladorTreino.getInstance();
        this.controladorTreinoExecutado = ControladorTreinoExecutado.getInstance();
    }
    
    public static Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }
    
    //-----------------Metodos Delegate ControladorPessoa-----------------------
    public void adicionar(Pessoa usuario, Pessoa p)throws ElementoJaExisteException{
       this.controladorPessoa.adicionar(usuario, p);
    }
    
    public void remover(Pessoa usuario, Pessoa p)throws ElementoNaoExisteException{
      this.controladorPessoa.remover(usuario, p);
    }
    
    public void alterar(Pessoa usuario, Pessoa pessoaAtual, Pessoa pessoaAlterado)
                        throws ElementoNaoExisteException{
        
        this.controladorPessoa.alterar(usuario, pessoaAtual, pessoaAlterado);
    }
    
    public Object consultar (Pessoa usuario, Pessoa p)throws ElementoNaoExisteException{
        return this.controladorPessoa.consultar(usuario, p);
    }
    
    public void cadastrarAlunoParaProfessor(Aluno a, Professor p)throws ElementoJaExisteException{
       this.controladorPessoa.cadastrarAlunoParaProfessor(a, p);
    }

    public List<Pessoa> listarProfessor(Pessoa usuario) {
        return controladorPessoa.listarProfessor(usuario);
    }

    public List<Pessoa> listarAlunos(Pessoa usuario) {
        return controladorPessoa.listarAlunos(usuario);
    }

    public List<Pessoa> listarAlunosDoProfessor(Pessoa usuario) {
        return controladorPessoa.listarAlunosDoProfessor(usuario);
    }
    
    public List<Pessoa> listarTodos(){
        return controladorPessoa.listarTodos();
    }
    
    public Pessoa login(String email, String senha){
        return controladorPessoa.login(email, senha);
    }
    
    //--------------------Metodos Delegate ControladorTreino---------------------
    public void cadastrarPlanoTreino(Professor p, Aluno a, List<Treino> treinos, 
            LocalDate dataInicio) throws ProfessorNaoContemAluno, ElementoJaExisteException{
        
        this.controladorTreino.cadastrarPlanoTreino(p, a, treinos, dataInicio);
    }
    
    public void alterarPlanoTreino(Professor p, Aluno a, List<Treino> treinos, 
            LocalDate dataInicio) throws ProfessorNaoContemAluno, ElementoNaoExisteException{
        
       this.controladorTreino.alterarPlanoTreino(p, a, treinos, dataInicio);
    }
    
    public PlanoTreinoSemanal consultarPlanoTreino(Professor p, Aluno a) 
            throws ProfessorNaoContemAluno, ElementoNaoExisteException{
        
        return this.controladorTreino.consultarPlanoTreino(p, a);
    }
    
    public void alterarTreino(Professor p, Aluno a, List<Exercicio> exercicios, 
            Treino treino) throws ProfessorNaoContemAluno, ElementoNaoExisteException{
        

        this.controladorTreino.alterarTreino(p, a, exercicios, treino);
    }
    
    public Treino consultarTreino(Professor p, Aluno a, Treino treino) 
            throws ProfessorNaoContemAluno, ElementoNaoExisteException{
       
        return this.controladorTreino.consultarTreino(p, a, treino);
    }
    
    //---------------Metodos Delegate ControladorTreinoExecutado----------------

    public void salvarTreinoExecutado(TreinoExecutado treinoExecutado)
                                    throws ElementoJaExisteException{
        this.controladorTreinoExecutado.salvarTreinoExecutado(treinoExecutado);
    }

    public TreinoExecutado consultarTreinoExecutado(TreinoExecutado treinoExecutado) 
                                    throws ElementoNaoExisteException{
        return this.controladorTreinoExecutado.consultarTreinoExecutado(treinoExecutado);
    }
    

}
