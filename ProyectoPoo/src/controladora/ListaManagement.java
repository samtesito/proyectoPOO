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
    
    /// CALCULO DE PRESUPUESTOS
    private double calcularPresupuestoParedes(double costoporvolumen) { return (9.95*costoporvolumen); }
    private double calcularPresupuestoTecho(double costoporarea) { return (13.95*costoporarea); }
    private double calcularPresupuestoPiso(double costoporarea){ return (9.42*costoporarea);}
    public double calcularPresupuesto(modelo.Material pared, modelo.Material techo, modelo.Material piso) {
        return (calcularPresupuestoParedes(pared.getCostoporvolumen())
                +calcularPresupuestoTecho(techo.getCostoporarea())
                +calcularPresupuestoPiso(piso.getCostoporarea()));
    }   
    
    /////// FORMULAS DE CALCULO PARA LAS PROPORCIONES DE LA CONSTRUCCION
    
    /// PAREDES:
    ///Para las paredes, asumiendo que es una pared elíptica de 2 metros 
    ///de radio mayor y 1.5 metros de radio inferior, con una altura de 3 metros 
    ///y un grosor de 0.30 metros, calculamos primero el perímetro de la elipse:
    ///  P = PI * (3(a+b)-SQRT((3a+b)(a+3b)))
    ///  P = PI * (3(2+1.5)-SQRT((3*2+1.5)(2+3*1.5)))
    ///  P = 11.05 m
    ///Ahora multiplicamos el perimetro por la altura y el grosor:
    ///  V = P * h * L = 11.05 m * 3 m * 0.30 m = 9.95 m3
    ///  RESPUESTA : 9.95 m3
    
    /// TECHO:
    ///Para el techo, se asumirá que tiene forma de medio elipsoide, atravesado 
    ///horizontalmente por un plano a lo largo de sus dos ejes más amplios. 
    ///La fórmula para calcular el área superficial de un elipsoide con 
    ///semi-ejes a, b y c es:
    ///  A = 4*(PI)*[(((a^p)*(b^p)+(a^p)*(c^p)+(b^p)*(c^p))/3)^(1/p)]
    ///Donde p es un valor que se toma como 1.6075 para obtener buenas aprox.
    ///  A = 4 * (PI) * [(((2^1.6075)*(1.5^1.6075)+(2^1.6075)*(1^1.6075)+(1.5^1.6075)*(1^1.6075))/3)^(1/1.6075)]    ///  A = 27.90 m2
    ///Ahora, dividimos la superficie obtenida entre dos:
    /// A med = 13.95 m2
    
    /// PISO:
    /// Para el piso de la cabina se asume una superficie de área elíptica 
    ///correspondiente a la elipse planteada para las paredes:
    /// A = PI * a * b = PI * 2 m * 1.5 m = 9.42 m2
    /// RESPUESTA: A = 9.42 M2
}
