package br.ufrpe_SistemaAcademia.negocio;

import br.ufrpe_SistemaAcademia.exception.ElementoJaExisteException;
import br.ufrpe_SistemaAcademia.exception.ElementoNaoExisteException;
import br.ufrpe_SistemaAcademia.exception.ProfessorNaoContemAluno;
import br.ufrpe_SistemaAcademia.negocio.bean.Aluno;
import br.ufrpe_SistemaAcademia.negocio.bean.Exercicio;
import br.ufrpe_SistemaAcademia.negocio.bean.PlanoTreinoSemanal;
import br.ufrpe_SistemaAcademia.negocio.bean.Professor;
import br.ufrpe_SistemaAcademia.negocio.bean.Treino;
import java.time.LocalDate;
import java.util.List;

public class ControladorTreino {
    
    private static ControladorTreino instance;

    private ControladorTreino() {
    }
    
     //padrao Singleton
    public static ControladorTreino getInstance(){
        if (instance == null) {
            instance = new ControladorTreino();
        }
        return instance;
    }
     
    public void cadastrarPlanoTreino(Professor p, Aluno a, List<Treino> treinos, 
            LocalDate dataInicio)throws ProfessorNaoContemAluno, ElementoJaExisteException{
                                  
        if(a.getProfessor().equals(p)){
            
            if(a.getPlanoTreino() == null){
                
                a.setPlanoTreino(new PlanoTreinoSemanal(dataInicio));
                a.getPlanoTreino().getTreinos().addAll(treinos);

            }else{
                throw new ElementoJaExisteException(a.getPlanoTreino());
            }
            
        }else{
            throw new ProfessorNaoContemAluno(a.getProfessor());
        }
    }
    
    public void alterarPlanoTreino(Professor p, Aluno a, List<Treino> treinos, 
        LocalDate dataInicio)throws ProfessorNaoContemAluno, ElementoNaoExisteException{
        
        if(a.getProfessor().equals(p)){
            
            if(a.getPlanoTreino() != null){

                a.getPlanoTreino().setDataInicio(dataInicio);
                a.getPlanoTreino().getTreinos().clear();
                a.getPlanoTreino().getTreinos().addAll(treinos);

            }else{
                throw new ElementoNaoExisteException(a.getPlanoTreino());
            }
           
        }else{
            throw new ProfessorNaoContemAluno(a.getProfessor());
        }
    }
    
    public PlanoTreinoSemanal consultarPlanoTreino(Professor p, Aluno a)
        throws ProfessorNaoContemAluno, ElementoNaoExisteException{
        
        if(a.getProfessor().equals(p)){
            
            if(a.getPlanoTreino() != null){
                
                return a.getPlanoTreino();
                
            }else{
                throw new ElementoNaoExisteException(a.getPlanoTreino());        
            }
            
        }else{
            throw new ProfessorNaoContemAluno(a.getProfessor());
        }        
        
    }
    
    public void alterarTreino(Professor p, Aluno a, List<Exercicio> exercicios, 
            Treino treino)throws ProfessorNaoContemAluno, ElementoNaoExisteException{
        
        if(a.getProfessor().equals(p) ){
            
            if(a.getPlanoTreino() != null && 
                    a.getPlanoTreino().getTreinos().contains(treino)){
                
                Treino t = new Treino();
                t.setExercicios(exercicios);

                a.getPlanoTreino().getTreinos().remove(treino);
                a.getPlanoTreino().getTreinos().add(t);
            }else{
                throw new ElementoNaoExisteException(a.getPlanoTreino());
            }           
            
        }else{
            throw new ProfessorNaoContemAluno(a.getProfessor());
        }
    }
    
    public Treino consultarTreino(Professor p, Aluno a, Treino treino)
                    throws ProfessorNaoContemAluno, ElementoNaoExisteException{
        
        if(a.getProfessor().equals(p)){
            
            if(a.getPlanoTreino() != null && 
                    a.getPlanoTreino().getTreinos().contains(treino)){
                
                int x = a.getPlanoTreino().getTreinos().indexOf(treino);
                
                return a.getPlanoTreino().getTreinos().get(x);
            }else{
                throw new ElementoNaoExisteException(a.getPlanoTreino());
            }
                      
        }else{
            throw new ProfessorNaoContemAluno(a.getProfessor());
        }
    }   

}
