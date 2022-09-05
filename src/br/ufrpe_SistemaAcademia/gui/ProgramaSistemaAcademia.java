
package br.ufrpe_SistemaAcademia.gui;

import br.ufrpe_SistemaAcademia.exception.ElementoJaExisteException;
import br.ufrpe_SistemaAcademia.exception.ProfessorNaoContemAluno;
import br.ufrpe_SistemaAcademia.negocio.Fachada;
import br.ufrpe_SistemaAcademia.negocio.bean.Aluno;
import br.ufrpe_SistemaAcademia.negocio.bean.Exercicio;
import br.ufrpe_SistemaAcademia.negocio.bean.Gerente;
import br.ufrpe_SistemaAcademia.negocio.bean.Pessoa;
import br.ufrpe_SistemaAcademia.negocio.bean.PlanoPagamento;
import br.ufrpe_SistemaAcademia.negocio.bean.PlanoTreinoSemanal;
import br.ufrpe_SistemaAcademia.negocio.bean.Professor;
import br.ufrpe_SistemaAcademia.negocio.bean.Treino;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgramaSistemaAcademia {
    
    public static void main(String[] args) throws ElementoJaExisteException, ProfessorNaoContemAluno {
        
        
        Pessoa gerente = new Gerente("999", "jose", "3030", 
                                  LocalDate.of(1989, 11, 17), "jose@gmail.com");
        
        
        Pessoa p1 = new Professor("111", "9090", 3000.0, "Ana", "12345", 
                                    LocalDate.of(1998, 5, 10), "ana@gmail.com");
        Pessoa p2 = new Professor("222", "8080", 3000.0, "Bob", "54321", 
                                    LocalDate.of(1996, 9, 26), "bob@gmail.com");
        
        
        Pessoa a1 = new Aluno("001", (Professor) p1, "rafa", "7070", 
                            LocalDate.of(1990, 10, 20), "rafa@gmail.com");
        Pessoa a2 = new Aluno("002", (Professor) p1, "bia", "6060", 
                            LocalDate.of(1992, 12, 30), "bia@gmail.com");
        Pessoa a3 = new Aluno("003", (Professor) p2, "joao", "5050", 
                            LocalDate.of(1995, 7, 24), "joao@gmail.com");
        Pessoa a4 = new Aluno("004", (Professor) p2, "maria", "4040", 
                            LocalDate.of(1999, 2, 21), "maria@gmail.com");
        try {
            Fachada.getInstance().adicionar(gerente, a1);
            Fachada.getInstance().adicionar(gerente, a2);
            Fachada.getInstance().adicionar(gerente, a3);
            Fachada.getInstance().adicionar(gerente, a4);
            Fachada.getInstance().adicionar(gerente, a4);//objeto igual

            Fachada.getInstance().adicionar(gerente, p1);
            Fachada.getInstance().adicionar(gerente, p2);
        } catch (ElementoJaExisteException e) {
            System.out.println("\n-------------\nErro ao cadastrar\n\n");
        }
        
        
        Exercicio e1 = new Exercicio("Musculacao", 10, 5);
        Exercicio e2 = new Exercicio("barra", 15, 3);
        Exercicio e3 = new Exercicio("corrida", 30, 1);
        Exercicio e4 = new Exercicio("aerobica", 5, 3);
        
        Treino t1 = new Treino();
        t1.addExercicios(e1);
        t1.addExercicios(e2);
        t1.addExercicios(e3);
        
        Treino t2 = new Treino();
        t2.addExercicios(e1);
        t2.addExercicios(e4);
        
        List<Treino> treinos = new ArrayList<>();
        treinos.add(t2);
        treinos.add(t1);
        
        PlanoTreinoSemanal pt1 = new PlanoTreinoSemanal(LocalDate.now());
        
        PlanoPagamento pg1 = new PlanoPagamento(70.0, 3, LocalDate.now());
        
        Fachada.getInstance().cadastrarAlunoParaProfessor((Aluno)a1, (Professor)p1);
        Fachada.getInstance().cadastrarAlunoParaProfessor((Aluno)a2, (Professor)p1);
        Fachada.getInstance().cadastrarPlanoTreino((Professor)p1, (Aluno)a1, treinos, LocalDate.now());
        
        System.out.println(((Professor)p1).getAlunos().get(0));
        System.out.println(((Professor)p1).getAlunos().get(1));
        
    } 
    
}
