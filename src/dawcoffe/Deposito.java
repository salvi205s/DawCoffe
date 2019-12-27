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

    private double cantidadMax,
            cantidadUmbral,
            cantidadActual;
    private String contenido;
    private boolean reserva;

    public Deposito(double cantidadMax, double cantidadUmbral, double cantidadActual, String contenido) {
        this.cantidadMax = cantidadMax;
        this.cantidadUmbral = cantidadUmbral;
        this.cantidadActual = cantidadActual;
        this.contenido = contenido;
    }

    //metodos
    //----------------------------------
    //reponer el contenido
    public void llenarDeposito(double cantidad) {

        if (cantidad + cantidadActual > cantidadMax) {
            this.cantidadActual = cantidadMax;

        }

        this.cantidadActual += cantidad;
        if (cantidadActual == cantidadMax) {
            this.reserva = false;
        }
    }

    public void llenarDepositoCompleto() {
        this.cantidadActual = cantidadMax;
        if (cantidadActual == cantidadMax) {
            this.reserva = false;
        }
    }

    public void servirContenido(int cantidad) {

        this.cantidadActual -= cantidad;
    }

    public boolean isReserva() {

        if (this.cantidadActual <= this.cantidadUmbral) {
            this.reserva = true;
        }

        return this.reserva;

    }

    public void setReserva(boolean reserva) {
        this.reserva = reserva;
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

    @Override
    public String toString() {
        return "Deposito{" + "cantidadMax=" + cantidadMax + ", cantidadUmbral=" + cantidadUmbral + ", cantidadActual=" + cantidadActual + ", contenido=" + contenido + ", reserva=" + reserva + '}';
    }

}
