/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author samue
 */
public class Material {
    private double costoporvolumen;
    private double costoporarea;
    private String nombre;   

    public Material(double costoporvolumen, double costoporarea, String nombre) {
        this.costoporvolumen = costoporvolumen;
        this.costoporarea = costoporarea;
        this.nombre = nombre;
    }

    public double getCostoporvolumen() {
        return costoporvolumen;
    }

    public void setCostoporvolumen(double costoporvolumen) {
        this.costoporvolumen = costoporvolumen;
    }

    public double getCostoporarea() {
        return costoporarea;
    }

    public void setCostoporarea(double costoporarea) {
        this.costoporarea = costoporarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
