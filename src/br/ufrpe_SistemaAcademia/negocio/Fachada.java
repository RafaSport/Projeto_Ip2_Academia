package br.ufrpe_SistemaAcademia.negocio;

import br.ufrpe_SistemaAcademia.dados.RepositorioArquivo;
import br.ufrpe_SistemaAcademia.exception.ElementoJaExisteException;
import br.ufrpe_SistemaAcademia.exception.ElementoNaoExisteException;
import br.ufrpe_SistemaAcademia.exception.ProfessorNaoContemAluno;
import br.ufrpe_SistemaAcademia.negocio.bean.Aluno;
import br.ufrpe_SistemaAcademia.negocio.bean.Exercicio;
import br.ufrpe_SistemaAcademia.negocio.bean.Pessoa;
import br.ufrpe_SistemaAcademia.negocio.bean.PlanoTreinoSemanal;
import br.ufrpe_SistemaAcademia.negocio.bean.Professor;
import br.ufrpe_SistemaAcademia.negocio.bean.TipoTreino;
import br.ufrpe_SistemaAcademia.negocio.bean.Treino;
import br.ufrpe_SistemaAcademia.negocio.bean.TreinoExecutado;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JTable;

public class Fachada {
    
    private static Fachada instance;
    
    private ControladorPessoa controladorPessoa;
    private ControladorTreino controladorTreino;
    private ControladorTreinoExecutado controladorTreinoExecutado;
    private ControladorSistema controladorSistema;
    
    private Pessoa usuario;
    private Pessoa pessoaManipulada;
    
    private double valorMensalidade = 70;
    private double salario = 3000;

    private Fachada() {
        this.controladorPessoa = ControladorPessoa.getInstance();
        this.controladorTreino = ControladorTreino.getInstance();
        this.controladorTreinoExecutado = ControladorTreinoExecutado.getInstance();
        this.controladorSistema = ControladorSistema.getInstance();
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
    
    public void salvarPessoasNaMemoria(List<Pessoa> lista){
        this.controladorPessoa.salvarPessoasNamemoria(lista);
    }
     
    public void salvarPessoasNoArquivo(String nomeArquivo){
        
        RepositorioArquivo.salvarPessoasNoArquivo(this.listarTodos(), nomeArquivo);
    }
    
    public Pessoa login(String email, String senha){
        return controladorPessoa.login(email, senha);
    }
    
    public boolean pagamentoEmDiaDoAluno(Aluno aluno){
        return this.controladorPessoa.pagamentoEmDiaDoAluno(aluno);
    }
    
    public Professor escolheProfessorParaAluno(Pessoa p){
        return this.controladorPessoa.escolheProfessorParaAluno(p);
    }
    
     public boolean equals(Pessoa p, Pessoa usuario){
         return this.controladorPessoa.equals(p, usuario);
     }
    
    
    //--------------------Metodos Delegate ControladorTreino--------------------
    
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
    
    public List<Exercicio> listaDeExerciciosDoDiaDaSemana(Aluno a, LocalDate dia)
            throws ArrayIndexOutOfBoundsException{
        
        return this.controladorTreino.listaDeExerciciosDoDiaDaSemana(a, dia);
    }
    
    public String treinosCadastrado(Aluno a, Professor p)
            throws ProfessorNaoContemAluno, ElementoNaoExisteException{
        
        return this.controladorTreino.treinosCadastrado(a, p);
    }
    
    public String exerciciosCadastrado(Aluno a, Professor p)
            throws ProfessorNaoContemAluno, ElementoNaoExisteException{
        
        return this.controladorTreino.exerciciosCadastrado(a, p);
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
    
   public List<TreinoExecutado> listarTodosOsTreinosExecutados(){
        return this.controladorTreinoExecutado.listarTodosOsTreinosExecutados();
    }
    
    public void salvarTreinoExecutadoNaMemoria(List<TreinoExecutado> dadosArquivo){
        this.controladorTreinoExecutado.salvarTreinoExecutadoNaMemoria(dadosArquivo);
    }
    
    public void salvarTreinosExecutadosNoArquivo(String nomeArquivo){
        
        RepositorioArquivo.salvarTreinosExecutadosNoArquivo(this.listarTodosOsTreinosExecutados(), nomeArquivo);
    }
    
    //------------------Metodos Delegate ControladorSistema---------------------
    
    public String dateParaString(LocalDate data){
        return this.controladorSistema.dataParaString(data);
    }
    
    public boolean dataNaValidade(LocalDate dataLimite, LocalDate dataParaVerificar){
        return this.controladorSistema.dataNaValidade(dataLimite, dataParaVerificar);
    }
    
    public void apagarTabela(JTable tabela, int qtdColuna){
        this.controladorSistema.apagarTabela(tabela, qtdColuna);
    }

    public LocalDate stringParaLocalDate (String s)throws DateTimeParseException{
        return this.controladorSistema.stringParaLocalDate(s);
    }
    
    public TipoTreino stringParaTipoTreino (String s){
        return this.controladorSistema.stringParaTipoTreino(s);
    }
    
    public String inteiroParaDiaDaSemana(int i){
        return this.controladorSistema.inteiroParaDiaDaSemana(i);
    }
    
    
    //---------------------Getters e Setters------------------------------------
    
    public Pessoa getUsuario() {
        return usuario;
    }

    public void setUsuario(Pessoa usuario) {
        this.usuario = usuario;
    }

    public Pessoa getPessoaManipulada() {
        return pessoaManipulada;
    }

    public void setPessoaManipulada(Pessoa pessoaManipulada) {
        this.pessoaManipulada = pessoaManipulada;
    }

    public double getValorMensalidade() {
        return valorMensalidade;
    }

    public void setValorMensalidade(double valorMensalidade) {
        this.valorMensalidade = valorMensalidade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }


}
