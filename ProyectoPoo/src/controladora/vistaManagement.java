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
import modelo.Usuario;
import modelo.Material;
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
        //String[] mantequilla = {"¿El cielo es azul?", "¿De qué color es una naranja?", "Pistacho", "Garbanzo"};
        modelo.globalAccess.listaDePreguntas = new ArrayList<modelo.Pregunta>();
        modelo.globalAccess.listaDeUsuarios = new ArrayList<modelo.Usuario>();
        modelo.globalAccess.listaDeMateriales = new ArrayList<modelo.Material>();
        ArrayList<Object> lTemp = new ArrayList<Object>();
        ArrayList<Object> lTempUsuario = new ArrayList<Object>();
        ArrayList<Object> lTempMaterial = new ArrayList<Object>();
        JsonConector<modelo.Pregunta> jConector = new JsonConector();
        FileConector fConector = new FileConector();
        lTemp.addAll(jConector.ReadJson(fConector.readFPregunta()));
        lTempUsuario.addAll(jConector.ReadJson(fConector.readFUsuario()));
        lTempMaterial.addAll(jConector.ReadJson(fConector.readFMaterial()));

        
        // Guardar localizacion de la imagen para agregar y editar.
        modelo.globalAccess.imagePath = new ArrayList<String>();
        modelo.globalAccess.imagePath.add("");
        
        
        for(Object pregunta : lTemp){
            JsonElement jsonElement = gson.toJsonTree(pregunta);
            modelo.globalAccess.listaDePreguntas.add(gson.fromJson(jsonElement, Pregunta.class));
        }
        for(Object Usuario : lTempUsuario){
            JsonElement jsonElement = gson.toJsonTree(Usuario);
            modelo.globalAccess.listaDeUsuarios.add(gson.fromJson(jsonElement, Usuario.class));
        }
        for(Object material : lTempUsuario){
            JsonElement jsonElement = gson.toJsonTree(material);
            modelo.globalAccess.listaDeMateriales.add(gson.fromJson(jsonElement, Material.class));
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
    
    public static void loadResultado(int pJ1,int pJ2,int modoDeJuego){        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Resultadov2(pJ1,pJ2,modoDeJuego).setVisible(true);
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
    
    
    
    public static void loadVistaJuegoPreguntas(int modoDeJuego){        
        /* Create and display the form */
        ListaManagement lManagement = new ListaManagement();
        int vM[] = lManagement.getPreguntasXjugador(modoDeJuego);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaJuegoPreguntas(modoDeJuego, vM).setVisible(true);
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
