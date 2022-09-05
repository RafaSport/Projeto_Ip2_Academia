package br.ufrpe_SistemaAcademia.negocio;

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
     
    public void cadastrarPlanoTreino(Professor p, Aluno a, List<Treino> treinos, LocalDate dataInicio){
        
        if(a.getProfessor().equals(p) && a.getPlanoTreino() == null){
            
            a.setPlanoTreino(new PlanoTreinoSemanal(dataInicio));
            a.getPlanoTreino().getTreinos().addAll(treinos);
            
        }else{
            //colocar exception
        }
    }
    
    public void alterarPlanoTreino(Professor p, Aluno a, List<Treino> treinos, LocalDate dataInicio){
        
        if(a.getProfessor().equals(p) && a.getPlanoTreino() != null){
            
            a.getPlanoTreino().setDataInicio(dataInicio);
            a.getPlanoTreino().getTreinos().clear();
            a.getPlanoTreino().getTreinos().addAll(treinos);
            
        }else{
            //colocar exception
        }
    }
    
    public PlanoTreinoSemanal consultarPlanoTreino(Professor p, Aluno a){
        
        if(a.getProfessor().equals(p) && a.getPlanoTreino() != null){
            return a.getPlanoTreino();
        }else{
            //colocar exception
            return null;
        }        
        
    }
    
    public void alterarTreino(Professor p, Aluno a, List<Exercicio> exercicios, int posicao){
        
        if(a.getProfessor().equals(p) && a.getPlanoTreino() != null
            && a.getPlanoTreino().getTreinos().size()>= posicao ){
            
            a.getPlanoTreino().getTreinos().remove(posicao);
            a.getPlanoTreino().getTreinos().get(posicao).setExercicios(exercicios);
            
        }else{
            //colocar exception
        }
    }
    
    public Treino consultarTreino(Professor p, Aluno a, int posicao){
        if(a.getProfessor().equals(p) && a.getPlanoTreino() != null
                && a.getPlanoTreino().getTreinos().size()>= posicao){
            
            return a.getPlanoTreino().getTreinos().get(posicao);
            
        }else{
            //colocar exception
            return null;
        }
    }
    

    

}
