/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controladora;

import vistas.InicioDeSesion;
import vistas.Resultado;
import vistas.Start;

/**
 *
 * @author apari
 */
public class vistaManagement{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
    
    
    
}
