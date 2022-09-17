
package br.ufrpe_SistemaAcademia.gui;

import br.ufrpe_SistemaAcademia.exception.ElementoJaExisteException;
import br.ufrpe_SistemaAcademia.exception.ProfessorNaoContemAluno;
import br.ufrpe_SistemaAcademia.negocio.Fachada;
import br.ufrpe_SistemaAcademia.negocio.bean.Aluno;
import br.ufrpe_SistemaAcademia.negocio.bean.Exercicio;
import br.ufrpe_SistemaAcademia.negocio.bean.Gerente;
import br.ufrpe_SistemaAcademia.negocio.bean.Pessoa;
import br.ufrpe_SistemaAcademia.negocio.bean.PlanoPagamento;
import br.ufrpe_SistemaAcademia.negocio.bean.Professor;
import br.ufrpe_SistemaAcademia.negocio.bean.TipoTreino;
import br.ufrpe_SistemaAcademia.negocio.bean.Treino;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgramaSistemaAcademia {
    
    public static void main(String[] args) throws ElementoJaExisteException, ProfessorNaoContemAluno {
        
        testes();
       /*
        LocalDate data = LocalDate.of(2021, 9, 12);
        LocalDate hoje = LocalDate.now();
        
        Period periodo = Period.between(data, hoje);
        
        System.out.println(periodo.isNegative());
        */
    } 
    
    public static void testes() throws ElementoJaExisteException, ProfessorNaoContemAluno{
        
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
        
            
        Fachada.getInstance().adicionar(gerente, gerente);
        Fachada.getInstance().adicionar(gerente, a1);
        Fachada.getInstance().adicionar(gerente, a2);
        Fachada.getInstance().adicionar(gerente, a3);
        Fachada.getInstance().adicionar(gerente, a4);

        Fachada.getInstance().adicionar(gerente, p1);
        Fachada.getInstance().adicionar(gerente, p2);
        
        Exercicio e1 = new Exercicio(TipoTreino.MUSCULAÇÃO_BRAÇO, 10, 5);
        Exercicio e2 = new Exercicio(TipoTreino.BICICLETA, 15, 3);
        Exercicio e3 = new Exercicio(TipoTreino.ESTEIRA, 30, 1);
        Exercicio e4 = new Exercicio(TipoTreino.AERÓBICA, 5, 3);
        Exercicio e5 = new Exercicio(TipoTreino.MUSCULAÇÃO_COSTA, 10, 3);
        Exercicio e6 = new Exercicio(TipoTreino.MUSCULAÇÃO_GLUTEO, 20, 2);
        Exercicio e7 = new Exercicio(TipoTreino.MUSCULAÇÃO_PEITO, 10, 4);
        Exercicio e8 = new Exercicio(TipoTreino.MUSCULAÇÃO_PERNA, 15, 2);
        Exercicio e9 = new Exercicio(TipoTreino.BARRAS, 5, 4);
        //segunda
        Treino t1 = new Treino();
        t1.addExercicios(e1);
        t1.addExercicios(e2);
        t1.addExercicios(e3);
        t1.addExercicios(e9);
        
        //terça
        Treino t2 = new Treino();
        t2.addExercicios(e1);
        t2.addExercicios(e4);
        t2.addExercicios(e9);
        //quarta
        Treino t3 = new Treino();
        t3.addExercicios(e5);
        t3.addExercicios(e6);
        t3.addExercicios(e7);
        //quinta
        Treino t4 = new Treino();
        t4.addExercicios(e2);
        t4.addExercicios(e4);
        t4.addExercicios(e6);
        //sexta
        Treino t5 = new Treino();
        t5.addExercicios(e1);
        t5.addExercicios(e3);
        t5.addExercicios(e5);
        //sabado
        Treino t6 = new Treino();
        t6.addExercicios(e6);
        t6.addExercicios(e7);
        t6.addExercicios(e8);
        
        if(t6.getExercicios() == null){
            System.out.println("nulo");
        }else{
            System.out.println("nao nulo");
        }
        
        List<Treino> treinos = new ArrayList<>();
        treinos.add(t1);//seguda
        treinos.add(t2);//terca
        treinos.add(t3);//quarta
        treinos.add(t4);//quinta
        treinos.add(t5);//sexta
        treinos.add(t6);//sabado
        
        Fachada.getInstance().cadastrarPlanoTreino((Professor)p1, (Aluno)a1, treinos, LocalDate.of(2022, 9, 10));
        
        PlanoPagamento pg1 = new PlanoPagamento(70.0, 3, LocalDate.of(2022, 7, 14));
        
        Fachada.getInstance().cadastrarAlunoParaProfessor((Aluno)a1, (Professor)p1);
        Fachada.getInstance().cadastrarAlunoParaProfessor((Aluno)a2, (Professor)p1);
        /*
        List<Pessoa> lista = Fachada.getInstance().listarAlunosDoProfessor((Professor)p1);
        
        for(Pessoa p : lista){
            System.out.println(p);
        }
        */
        Fachada.getInstance().setUsuario(a1);
        ((Aluno)a1).setPlanoPagamento(pg1);
      
        new TelaInicial().setVisible(true);
    }
}
