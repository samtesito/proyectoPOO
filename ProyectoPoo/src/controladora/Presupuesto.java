/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladora;

/**
 *
 * @author samue
 */
public class Presupuesto {
    /// CALCULO DE PRESUPUESTOS
    private double calcularPresupuestoParedes(double costoporvolumen) { return (9.95*costoporvolumen); }
    private double calcularPresupuestoTecho(double costoporarea) { return (13.95*costoporarea); }
    private double calcularPresupuestoPiso(double costoporarea){ return (9.42*costoporarea);}
    private double calcularPresupuestico(modelo.Material pared, modelo.Material techo, modelo.Material piso) {
        return (calcularPresupuestoParedes(pared.getCostoporvolumen())
                +calcularPresupuestoTecho(techo.getCostoporarea())
                +calcularPresupuestoPiso(piso.getCostoporarea()));
    }   
    public double calcularPresupuesto(javax.swing.JComboBox techo, javax.swing.JComboBox pared, javax.swing.JComboBox piso, javax.swing.JTextField aniadidos){
        int indicetecho = techo.getSelectedIndex();
        int indicepared = pared.getSelectedIndex();
        int indicepiso = piso.getSelectedIndex();
        double costosadicionales;
        if(indicetecho>modelo.globalAccess.listaDeMateriales.size() || indicepared>modelo.globalAccess.listaDeMateriales.size() || indicepiso>modelo.globalAccess.listaDeMateriales.size()){
            return 0;
        }
        try{
            costosadicionales = Double.parseDouble(aniadidos.getText());
        }catch(NumberFormatException e){
            costosadicionales=0;
        }catch(Exception e){
            costosadicionales=0;
        }
        
        double resultadoparcial = calcularPresupuestico(modelo.globalAccess.listaDeMateriales.get(indicepared),
                modelo.globalAccess.listaDeMateriales.get(indicetecho) , 
                modelo.globalAccess.listaDeMateriales.get(indicepiso));
        return resultadoparcial + costosadicionales;
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
