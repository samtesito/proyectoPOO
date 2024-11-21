package controladora;
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
        String[] mantequilla = {"sexo", "coito", "penetracion", "singaera"};
        recursos.globalAccess.listaDePreguntas = new ArrayList<controladora.Pregunta>();
        recursos.globalAccess.listaDePreguntas.add(new controladora.Pregunta("Sexoooo",mantequilla,2,350.15));
        recursos.globalAccess.listaDePreguntas.add(new controladora.Pregunta("Gaitas",mantequilla,1,350.15));
        recursos.globalAccess.listaDePreguntas.add(new controladora.Pregunta("Periqueo",mantequilla,3,350.15));
        recursos.globalAccess.listaDePreguntas.add(new controladora.Pregunta("Gorras",mantequilla,0,350.15));
        vistas.interfazAdmin NuevaVentana = new vistas.interfazAdmin();
        NuevaVentana.setVisible(true);
    }
    
}
