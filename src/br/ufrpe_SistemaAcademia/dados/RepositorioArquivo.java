package br.ufrpe_SistemaAcademia.dados;

import br.ufrpe_SistemaAcademia.negocio.bean.Pessoa;
import br.ufrpe_SistemaAcademia.negocio.bean.TreinoExecutado;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import javax.swing.JOptionPane;

public class RepositorioArquivo {
    
    public static List<Pessoa> carregarArquivoDePessoas(String filename) {
        Object instanciaLocal = null;
        
        List<Pessoa> listaPessoa = null;

        File in = new File(filename);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            
            // Se alguma exceção ocorrer, um objeto NULL será retornado
            instanciaLocal = ois.readObject();
            
            listaPessoa = (List<Pessoa>)instanciaLocal;
        } catch (Exception e) {
            
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                }
            }
        }

        return listaPessoa;
    }
    
    
    public static void salvarPessoasNoArquivo(List<Pessoa> instance, String filename) {
        if (instance == null) {
            return;
        }
        File out = new File(filename);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(out);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(instance);
          
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não salvou", "ERRO", 0);
            
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    
                }
            }
        }
    }
    
    
    public static List<TreinoExecutado> carregarArquivoDeTreinosExecutados(String filename) {
        Object instanciaLocal = null;
        
        List<TreinoExecutado> listaTreinos = null;

        File in = new File(filename);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            
            // Se alguma exceção ocorrer, um objeto NULL será retornado
            instanciaLocal = ois.readObject();
            
            listaTreinos = (List<TreinoExecutado>)instanciaLocal;
        } catch (Exception e) {
            
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                }
            }
        }

        return listaTreinos;
    }

      
    public static void salvarTreinosExecutadosNoArquivo(List<TreinoExecutado> instance, String filename) {
        if (instance == null) {
            return;
        }
        File out = new File(filename);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(out);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(instance);
          
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Não salvou", "ERRO", 0);
            
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                   
                }
            }
        }
    }
}
