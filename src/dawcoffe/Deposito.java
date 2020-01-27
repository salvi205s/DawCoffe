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

//    variables que iremos necesitando a lo largo del programa
    private double cantidadMax,
            cantidadUmbral,
            cantidadActual;
    private String contenido;
    private boolean reserva;

    //constructor parametrizado
    public Deposito(double cantidadMax, double cantidadUmbral, double cantidadActual, String contenido) {
        this.cantidadMax = cantidadMax;
        this.cantidadUmbral = cantidadUmbral;
        this.cantidadActual = cantidadActual;
        this.contenido = contenido;

        //controlamos que la cantidad actual no supere la cantidad maxima
        if (cantidadActual > cantidadMax) {
            cantidadActual = cantidadMax;
        }
    }

    //metodos
    //----------------------------------
    //reponer el contenido
    public void llenarDeposito(double cantidad) {

        //controlamos que la cantidad que le pasamos por parametro no supere, la cantidad max
        if (cantidad + cantidadActual > cantidadMax) {
            this.cantidadActual = cantidadMax;

        }

        //sino, la sumamos
        this.cantidadActual += cantidad;

        //ponemos la reserva a false, despues de llenarlo
        if (cantidadActual == cantidadMax) {
            this.reserva = false;
        }
    }

    //metodo que llena el deposito completamente
    public void llenarDepositoCompleto() {
        this.cantidadActual = cantidadMax;

        //ponemos la reserva a false, despues de llenarlo
        if (cantidadActual == cantidadMax) {
            this.reserva = false;
        }
    }

    //metodo para restar al deposito despues de servir, y que recibe la cantidad que va a servir
    public void servirContenido(int cantidad) {

        this.cantidadActual -= cantidad;
    }

    //metodo que informa si el deposito esta en reserva, o no
    public boolean isReserva() {

        //controlamos que si esta por debajo de la cantidad umbral, ponga la reserva a true
        if (this.cantidadActual <= this.cantidadUmbral) {
            this.reserva = true;
        }

        return this.reserva;

    }
    //getters, setters, y ToString
    //------------------------------------------

    public void setReserva(boolean reserva) {
        this.reserva = reserva;
    }

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

    //controlamos que la cantidad actual no supere la cantidad maxima
    public void setCantidadActual(double cantidadActual) {
        this.cantidadActual = cantidadActual;
        if (cantidadActual > cantidadMax) {
            cantidadActual = cantidadMax;
        }
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Deposito de " + contenido + "\ncantidadMax=" + cantidadMax + "\ncantidadUmbral=" + cantidadUmbral + "\ncantidadActual=" + cantidadActual + "\nreserva=" + reserva + "\n................................";
    }

}
