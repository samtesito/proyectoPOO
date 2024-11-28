/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladora;

import java.util.ArrayList;

/**
 *
 * @author samue
 */
public class ListaManagement {
    
    /// SELECCION DE PREGUNTAS
    
    public static int[] seleccionarPreguntasAleatorias(int cantidadpreguntas){
        ArrayList<Integer> preguntasselecc = new ArrayList<Integer>();
        int limitelista = modelo.globalAccess.listaDePreguntas.size();
        int nuevapregunta;
        int i = 0;
        while (i<cantidadpreguntas){
            nuevapregunta = (int)(Math.random()*limitelista);
            if (!preguntasselecc.contains(nuevapregunta)) {
                preguntasselecc.add(nuevapregunta);
                i++;
            }
        }
        int[] respuestafinal= new int[preguntasselecc.size()];
        i=0;
        for (Integer pregunta: preguntasselecc){
            respuestafinal[i]=pregunta.intValue();
            i++;
        }
        return respuestafinal;
    }
    
    public static int[] getPreguntas1jugador(){
        int[] preguntas = seleccionarPreguntasAleatorias(10);
        return preguntas;
    }
    
    public static int[] getPreguntas2jugador(){
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
    
    /// VISUALIZACION DE PREGUNTAS
    
}
