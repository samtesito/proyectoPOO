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
    private int usos;
    private int aciertos;

    public Pregunta(String enunciado, String[] opciones, int respuestacorrecta, int usos, int aciertos ) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestacorrecta = respuestacorrecta;
        this.usos = usos;
        this.aciertos = aciertos;
    }
    public Pregunta(String enunciado, String[] opciones, int respuestacorrecta) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestacorrecta = respuestacorrecta;
        this.usos = 0;
        this.aciertos = 0;
    }

    public int getUsos() {
        return usos;
    }

    public void setUsos(int usos) {
        this.usos = usos;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
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
        if (this.usos >0) {
            return aciertos/usos;
        }else{
            return 0;
        }
    }
}
