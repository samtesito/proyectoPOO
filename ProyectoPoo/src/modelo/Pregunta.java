/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author samue
 */
public class Pregunta {
    
    private String enunciado;
    private String[] opciones;
    private int respuestacorrecta;
    private double porcentajedeacierto;

    public Pregunta(String enunciado, String[] opciones, int respuestacorrecta, double porcentajedeacierto) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestacorrecta = respuestacorrecta;
        this.porcentajedeacierto = porcentajedeacierto;
    }
    
    public String getEnunciado() {
        return enunciado;
    }
    
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
    }

    public int getRespuestacorrecta() {
        return respuestacorrecta;
    }

    public void setRespuestacorrecta(int respuestacorrecta) {
        this.respuestacorrecta = respuestacorrecta;
    }
    
    public double getPorcentajedeacierto(){
        return porcentajedeacierto;
    }
    
    public void setPorcentajedeacierto(double porcentajedeacierto){
        this.porcentajedeacierto = porcentajedeacierto;
    }
}
