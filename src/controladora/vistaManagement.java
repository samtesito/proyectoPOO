/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controladora;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import vistas.*;
import modelo.JsonConector;
import modelo.FileConector;
import java.util.List;
import modelo.Pregunta;
import com.google.gson.*;
import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author apari
 */
public class vistaManagement{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Gson gson = new Gson();
        String[] mantequilla = {"¿El cielo es azul?", "¿De qué color es una naranja?", "Pistacho", "Garbanzo"};
        modelo.globalAccess.listaDePreguntas = new ArrayList<modelo.Pregunta>();
        ArrayList<Object> lTemp = new ArrayList<Object>();
        JsonConector<modelo.Pregunta> jConector = new JsonConector();
        FileConector fConector = new FileConector();
        //modelo.globalAccess.listaDePreguntas.add(new modelo.Pregunta("¿de qué color son las naranjas?",mantequilla,2));
        //modelo.globalAccess.listaDePreguntas.add(new modelo.Pregunta("¿de qué tamanio es Berlin?",mantequilla,1));
        //modelo.globalAccess.listaDePreguntas.add(new modelo.Pregunta("¿de qué especie es Nemo",mantequilla,3));
        //modelo.globalAccess.listaDePreguntas.add(new modelo.Pregunta("¿Imperio mas grande de la edad media?",mantequilla,0));
        lTemp.addAll(jConector.ReadJson(fConector.readFPregunta()));
        
        // Guardar localizacion de la imagen para agregar y editar.
        modelo.globalAccess.imagePath = new ArrayList<String>();
        modelo.globalAccess.imagePath.add("");
        
        
        for(Object pregunta : lTemp){
            JsonElement jsonElement = gson.toJsonTree(pregunta);
            modelo.globalAccess.listaDePreguntas.add(gson.fromJson(jsonElement, Pregunta.class));
        }
        
        
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
            
    public static DefaultTableModel setModeloTablaPreguntas(boolean option, String text){
        Object[] header = new Object[]{"Nro", "Pregunta", "% de acierto"};
        DefaultTableModel model;
        model = new DefaultTableModel(header, 0){
            @Override            
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        if(!option){
            for(modelo.Pregunta pregunta : modelo.globalAccess.listaDePreguntas){
                model.addRow(new Object[]{modelo.globalAccess.listaDePreguntas.indexOf(pregunta), pregunta.getEnunciado(), pregunta.getPorcentajedeacierto()});
            }
        }else   {
            for(modelo.Pregunta pregunta : modelo.globalAccess.listaDePreguntas){
                if(pregunta.getEnunciado().toLowerCase().contains(text.toLowerCase())){
                    model.addRow(new Object[]{modelo.globalAccess.listaDePreguntas.indexOf(pregunta), pregunta.getEnunciado(), pregunta.getPorcentajedeacierto()});
                }
            }
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
