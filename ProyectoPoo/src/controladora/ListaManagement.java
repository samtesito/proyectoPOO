/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladora;

import java.util.ArrayList;
import modelo.FileConector;
import modelo.JsonConector;
import modelo.Pregunta;
import modelo.Material;
/**
 *
 * @author samue
 */
public class ListaManagement {
    
    /// SELECCION DE PREGUNTAS
    
    private int[] seleccionarPreguntasAleatorias(int cantidadpreguntas){
        ArrayList<Integer> preguntasselecc = new ArrayList<Integer>();
        int limitelista = modelo.globalAccess.listaDePreguntas.size();
        int nuevapregunta;
        int i = 0;
        while (i<cantidadpreguntas){
            nuevapregunta = (int)(Math.random()*limitelista);
            //if (!preguntasselecc.contains(nuevapregunta)) {
                preguntasselecc.add(nuevapregunta);
                i++;
            //}
        }
        int[] respuestafinal= new int[preguntasselecc.size()];
        i=0;
        for (Integer pregunta: preguntasselecc){
            respuestafinal[i]=pregunta.intValue();
            i++;
        }
        return respuestafinal;
    }
    
    public int[] getPreguntas1jugador(){
        int[] preguntas = seleccionarPreguntasAleatorias(10);
        return preguntas;
    }
    
    public int[] getPreguntas2jugador(){
        int cont=0;
        int[] preguntasdeambos = new int[20];
        int[] preguntas = seleccionarPreguntasAleatorias(10);
        for (int i: preguntas) {
            preguntasdeambos[cont]=i;
            cont++;
        }
        preguntas =  seleccionarPreguntasAleatorias(10);
        for (int i: preguntas) {
            preguntasdeambos[cont]=i;
            cont++;
        }
        return preguntasdeambos;
    }
    
    
    public int[] getPreguntasXjugador(int vCantJugadores){
        if(vCantJugadores==1){
            return getPreguntas1jugador();
        }else{
            return getPreguntas2jugador();
        }
    }
    
    public Pregunta getPregunta(int index){
        return modelo.globalAccess.listaDePreguntas.get(index);
    }
    
    public void guardarPregunta(){  
        JsonConector<modelo.Pregunta> jConector = new JsonConector();
        FileConector fConector = new FileConector();    
        fConector.writeFPregunta(jConector.WriteJson(modelo.globalAccess.listaDePreguntas));
    }
    public void AddPregunta(modelo.Pregunta vPregunta){
        modelo.globalAccess.listaDePreguntas.add(vPregunta);
    }
    
    
    
    /// VISUALIZACION DE PREGUNTAS
    
    
    /// MANEJO DE MATERIALES
    
    public void guardarMaterial(String nombre, double costoporarea, double costoporvolumen){  
        JsonConector<modelo.Material> jConector = new JsonConector();
        FileConector fConector = new FileConector();      
        Material material = new Material(costoporarea,costoporvolumen,nombre);
        modelo.globalAccess.listaDeMateriales.add(material);
        fConector.writeFMaterial(jConector.WriteJson(modelo.globalAccess.listaDeMateriales));
    }
    
}
