/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dawcoffe;

/**
 *
 * @author Salva
 */
public class Deposito {

    private double cantidadMax = 1000,
            cantidadUmbral = 250,
            cantidadActual=0;
    private String contenido;
    private boolean reserva;

    //metodos
    //----------------------------------
    
    //reponer el contenido
    public void llenarDeposito() {
        this.cantidadActual = cantidadMax;
    }

    public void servirContenido(int cantidad) {
        
        this.cantidadActual-=cantidad;
    }

    public boolean isReserva() {

        if (this.cantidadActual <= this.cantidadUmbral) {
            this.reserva = true;
        }

        return this.reserva;

    }

    //getters y setters
    //------------------------------------------
    public double getCantidadMax() {
        return cantidadMax;
    }

    public void setCantidadMax(double cantidadMax) {
        this.cantidadMax = cantidadMax;
    }

    public double getCantidadUmbral() {
        return cantidadUmbral;
    }

    public void setCantidadUmbral(double cantidadUmbral) {
        this.cantidadUmbral = cantidadUmbral;
    }

    public double getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(double cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

}
