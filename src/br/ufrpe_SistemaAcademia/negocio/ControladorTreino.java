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
                
                if(treinos != null){
                    a.getPlanoTreino().getTreinos().addAll(treinos);
                }
                

            }else{
                throw new ElementoJaExisteException(a.getPlanoTreino());
            }
            
        }else{
            throw new ProfessorNaoContemAluno(a.getProfessor());
        }
    }
    
    
    public void inserirTreinos(Professor p, Aluno a, List<Treino> treinos)
            throws ProfessorNaoContemAluno, ElementoNaoExisteException{
        
        if(a.getProfessor().equals(p)){
            
            if(a.getPlanoTreino() != null && a.getPlanoTreino().getTreinos() == null){

                a.getPlanoTreino().getTreinos().addAll(treinos);

            }else{
                throw new ElementoNaoExisteException(a.getPlanoTreino());
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
    
    
    public List<Exercicio> listaDeExerciciosDoDiaDaSemana(Aluno a, LocalDate dia)
                    throws ArrayIndexOutOfBoundsException{
        
        String diaDaSemana = String.valueOf(dia.getDayOfWeek());
        
        switch(diaDaSemana.toLowerCase()){
            case "monday": {
                if(a.getPlanoTreino().getTreinos() != null){                   
                    return a.getPlanoTreino().getTreinos().get(0).getExercicios();
                }else{
                    throw new ArrayIndexOutOfBoundsException();
                }
            }
            case "tuesday": {
                if(a.getPlanoTreino().getTreinos().size() >= 2){
                    return a.getPlanoTreino().getTreinos().get(1).getExercicios();
                }else{
                    throw new ArrayIndexOutOfBoundsException();
                }
            }
            case "wednesday": {
                if(a.getPlanoTreino().getTreinos().size() >= 3){
                    return a.getPlanoTreino().getTreinos().get(2).getExercicios();
                }else{
                    throw new ArrayIndexOutOfBoundsException();
                }
            }
            case "thursday": {
                if(a.getPlanoTreino().getTreinos().size() >= 4){
                    return a.getPlanoTreino().getTreinos().get(3).getExercicios();
                }else{
                    throw new ArrayIndexOutOfBoundsException();
                }
            }
            case "friday": {
                if(a.getPlanoTreino().getTreinos().size() >= 5){
                    return a.getPlanoTreino().getTreinos().get(4).getExercicios();
                }else{
                    throw new ArrayIndexOutOfBoundsException();
                }
            }
            case "saturday": {
                if(a.getPlanoTreino().getTreinos().size() >= 6){
                    return a.getPlanoTreino().getTreinos().get(5).getExercicios();
                }else{
                    throw new ArrayIndexOutOfBoundsException();
                }
            }
            default: return null;
            
        }
        
    }


    public String treinosCadastrado(Aluno a, Professor p)
            throws ProfessorNaoContemAluno, ElementoNaoExisteException{
        
        String s = null;
        
        if(a.getProfessor().equals(p)){
            
            if(a.getPlanoTreino() != null){
                
                if(a.getPlanoTreino().getTreinos().size() == 6){
                    s = "Treinos cadastrados!";
                }else if(a.getPlanoTreino().getTreinos().size() > 0){
                    s = "Treinos cadastrados Parcialmente!";
                }else if(a.getPlanoTreino().getTreinos().size() == 0){
                    s =  "Treinos não cadastrados!";
                }
                
            }else{
                throw new ElementoNaoExisteException(a.getPlanoTreino());
            }
                      
        }else{
            throw new ProfessorNaoContemAluno(a.getProfessor());
        } 
        return s;
    }
    
    
    public String exerciciosCadastrado(Aluno a, Professor p)
            throws ProfessorNaoContemAluno, ElementoNaoExisteException{
        
        String s = null;
        int cont = 0;
        
        if(a.getProfessor().equals(p)){
            
            if(a.getPlanoTreino() != null){
                
                for(Treino t : a.getPlanoTreino().getTreinos()){

                    if(t.getExercicios().size() > 0){
                        cont+=1;
                    }
                }

                if(cont == 6){
                    s = "Todos exercicios cadastrado!";
                }else if(cont > 0){
                    s = "Exercicios cadastrado parcialmente!";
                }else if(cont == 0){
                    s = "Nenhum exercicio cadastrado!";
                }
                
            }else{
                throw new ElementoNaoExisteException(a.getPlanoTreino());
            }
                      
        }else{
            throw new ProfessorNaoContemAluno(a.getProfessor());
        } 
        return s;
    }

}
