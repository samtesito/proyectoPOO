package modelo;
import java.util.ArrayList;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author apari
 */
public class ProyectoPoo{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] mantequilla = {"Menta", "Mantequilla", "Pistacho", "Garbanzo"};
        modelo.globalAccess.listaDePreguntas = new ArrayList<modelo.Pregunta>();
        modelo.globalAccess.listaDePreguntas.add(new modelo.Pregunta("¿de qué color son las naranjas?",mantequilla,2,350.15));
        modelo.globalAccess.listaDePreguntas.add(new modelo.Pregunta("¿de qué tamanio es Berlin?",mantequilla,1,350.15));
        modelo.globalAccess.listaDePreguntas.add(new modelo.Pregunta("¿de qué especie es Nemo",mantequilla,3,350.15));
        modelo.globalAccess.listaDePreguntas.add(new modelo.Pregunta("¿Imperio mas grande de la edad media?",mantequilla,0,350.15));
        vistas.InterfazAdmin NuevaVentana = new vistas.InterfazAdmin();
        NuevaVentana.setVisible(true);
    }
    
}
