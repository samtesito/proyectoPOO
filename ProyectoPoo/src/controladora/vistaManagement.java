/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controladora;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import vistas.InicioDeSesion;
import vistas.Resultado;
import vistas.Start;
import vistas.InterfazAdmin;
import vistas.vistaJuegoPreguntas;

/**
 *
 * @author apari
 */
public class vistaManagement{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] mantequilla = {"¿El cielo es azul?", "¿De qué color es una naranja?", "Pistacho", "Garbanzo"};
        modelo.globalAccess.listaDePreguntas = new ArrayList<modelo.Pregunta>();
        modelo.globalAccess.listaDePreguntas.add(new modelo.Pregunta("¿de qué color son las naranjas?",mantequilla,2,350.15));
        modelo.globalAccess.listaDePreguntas.add(new modelo.Pregunta("¿de qué tamanio es Berlin?",mantequilla,1,350.15));
        modelo.globalAccess.listaDePreguntas.add(new modelo.Pregunta("¿de qué especie es Nemo",mantequilla,3,350.15));
        modelo.globalAccess.listaDePreguntas.add(new modelo.Pregunta("¿Imperio mas grande de la edad media?",mantequilla,0,350.15));
        loadStart();
    }
    
    public static void loadStart(){        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Start().setVisible(true);
            }
        });
    }
    
    public static void loadResultado(){        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Resultado().setVisible(true);
            }
        });
    }
    
    public static void loadLogin(){           
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioDeSesion().setVisible(true);
            }
        });
    }
    
    public static void loadVistaJuegoPreguntas(){        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaJuegoPreguntas().setVisible(true);
            }
        });
    }
    
    /////// FUNCION PROVISIONAL
            
    public static DefaultTableModel setModeloTablaPreguntas(){
        Object[] header = new Object[]{"Nro", "Pregunta", "% de acierto"};
        DefaultTableModel model;
        model = new DefaultTableModel(header, 0){
            @Override            
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for(modelo.Pregunta pregunta : modelo.globalAccess.listaDePreguntas){
            model.addRow(new Object[]{modelo.globalAccess.listaDePreguntas.indexOf(pregunta), pregunta.getEnunciado(), pregunta.getPorcentajedeacierto()});
        }
        
        return model;
    }
    //////
    
    public static void loadInterfazAdmin(){           
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazAdmin().setVisible(true);
            }
        });
    }
    
    
    
}
