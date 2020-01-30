/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dawcoffe;

import java.awt.Menu;
import java.util.Scanner;

/**
 *
 * @author Salva
 */
public class Cafetera {

    //variables que necesitaremos a lo largo del programa
    private double saldoAcumulado = 0,
            saldoCliente = 0,
            precio;

    private int numVentas = 0;

    //creamos los depositos que le pasamos a la cafetera
    private Deposito cafe;
    private Deposito cafeDescafeinado;
    private Deposito azucar;
    private Deposito chocolate;
    private Deposito agua;
    private Deposito leche;
    private Deposito sacarina;

    //constructor parametrizado, que recibe los depositos
    public Cafetera(Deposito cafe, Deposito cafeDescafeinado, Deposito azucar, Deposito chocolate, Deposito agua, Deposito leche, Deposito sacarina) {
        this.cafe = cafe;
        this.cafeDescafeinado = cafeDescafeinado;
        this.azucar = azucar;
        this.chocolate = chocolate;
        this.agua = agua;
        this.leche = leche;
        this.sacarina = sacarina;
    }

//    constructor por defecto
    public Cafetera() {
    }

    //metodo que englova los metodos necesarios para servir un chocolate
    public void servirChocolate() {

        //resta la cantidad de chocolate, y de leche, al deposito
        restarChocolate(12);
        servirLeche();

    }
    //metodo que englova los metodos necesarios para servir un chocolate

    public void servirLeche() {

        //resta la cantidad de agua y de leche, al deposito
        restarLeche(30);
        agua.servirContenido(180);

    }

    //metodo para comprobar el precio del articulo
    public boolean comprobarPrecio() {

        //variable booleana, iniciada a false
        boolean precioCorrecto = false;

        //si el dinero ingresado por el cliente, es mayor que el precio del articulo
        //pone precio correcto a true
        if (getSaldoCliente() >= getPrecio()) {
            precioCorrecto = true;
        }

        return precioCorrecto;
    }

    //metodo para devolver el cambio
    public double devolverCambio() {

        //inicio la variable cambio a cero
        double cambio = 0;

        //calcula el cambio a devolver
        cambio = getSaldoCliente() - this.precio;

        //suma el precio al saldoAcumulado
        setSaldoAcumulado(this.precio);

        //incrementa en 1 el numero de ventas
        setNumVentas(1);

        return cambio;
    }

    //metodo para informar si hay existencias
    public boolean informarFaltaExistencias() {

        //variable booleana, iniciada a false
        boolean faltaExistencias = false;

        //si la cantidad actual de los depositos es menor que la cantidad minima a servir,
        //la variable faltaExistencias, se pone a true(Que faltan existencias)
        if (agua.getCantidadActual() < 50 || leche.getCantidadActual() < 180 || cafe.getCantidadActual() < 8 || chocolate.getCantidadActual() < 12) {
            faltaExistencias = true;
        }
        return faltaExistencias;
    }

    //metodos para restar el contenido del deposito de leche
    private void restarLeche(int cantidad) {

        //llama al metodo servirContenido, de la clase deposito
        leche.servirContenido(cantidad);

    }

    //metodo que resta el contenido del deposito de cafe
    public void restarCafe(int codigo) {

        //dependiendo del codigo(eleccion) resta la cantidad delos depositos, relacionados con cafe
        switch (codigo) {
            case 101:
                cafe.servirContenido(8);
                agua.servirContenido(50);
                break;

            case 102:
                cafe.servirContenido(8);
                agua.servirContenido(80);
                break;

            case 103:
                cafe.servirContenido(8);
                agua.servirContenido(50);
                restarLeche(30);
                break;

            case 104:
                cafe.servirContenido(8);
                agua.servirContenido(50);
                restarLeche(30);
                break;
            case 105:
                cafeDescafeinado.servirContenido(8);
                agua.servirContenido(50);
                break;

            case 106:
                cafeDescafeinado.servirContenido(8);
                agua.servirContenido(80);
                break;

            case 107:
                cafeDescafeinado.servirContenido(8);
                agua.servirContenido(50);
                restarLeche(30);
                break;

            case 108:
                cafeDescafeinado.servirContenido(8);
                agua.servirContenido(50);
                restarLeche(30);
                break;
        }

    }

    //metodo que resta chocolate, del deposito
    private void restarChocolate(int cantidad) {
        chocolate.servirContenido(cantidad);

    }

    //metodo que resta azucar del deposito, dependiendo de la cantidad que elija el usuario
    public void restarAzucar(int cantidadAzucar) {

        //resta el contenido de azucar al deposito
        switch (cantidadAzucar) {
            case 1:
                azucar.servirContenido(0);
                break;
            case 2:
                if (azucar.getCantidadActual() < 6) {
                    azucar.servirContenido(0);
                }
                azucar.servirContenido(6);
                break;
            case 3:
                if (azucar.getCantidadActual() < 12) {

                    int azucarRestante = (int) azucar.getCantidadActual();
                    azucar.servirContenido(azucarRestante);

                }
                azucar.servirContenido(12);

                break;
            default:
                System.out.println("Esa opcion no se contempla");
        }

    }

    //resta el contenido de sacarina al deposito
    public void restarSacarina() {
        sacarina.servirContenido(6);
    }

    //metodo para rellenar el deposito parcialmente, recibe una eleccion de deposito y una cantidad
    public void rellenarDepositoParcialmente(int opcionDeposito, double cantidad) {

        switch (opcionDeposito) {
            case 1:
                cafe.llenarDeposito(cantidad);
                break;

            case 2:
                cafeDescafeinado.llenarDeposito(cantidad);
                break;

            case 3:
                azucar.llenarDeposito(cantidad);
                break;

            case 4:
                chocolate.llenarDeposito(cantidad);
                break;

            case 5:
                agua.llenarDeposito(cantidad);
                break;

            case 6:
                leche.llenarDeposito(cantidad);
                break;
            case 7:
                sacarina.llenarDeposito(cantidad);
                break;
            case 8:

                break;
        }

        //se controla que la cantidad que se le pasa, no sea mayor que la capacidad maxima
        if (cantidad > cafe.getCantidadMax()) {
            cafe.setCantidadActual(cafe.getCantidadMax());
        }
        if (cantidad > cafeDescafeinado.getCantidadMax()) {
            cafeDescafeinado.setCantidadActual(cafeDescafeinado.getCantidadMax());
        }
        if (cantidad > azucar.getCantidadMax()) {
            azucar.setCantidadActual(azucar.getCantidadMax());
        }
        if (cantidad > chocolate.getCantidadMax()) {
            chocolate.setCantidadActual(chocolate.getCantidadMax());
        }
        if (cantidad > agua.getCantidadMax()) {
            agua.setCantidadActual(agua.getCantidadMax());
        }
        if (cantidad > leche.getCantidadMax()) {
            leche.setCantidadActual(leche.getCantidadMax());
        }
        if (cantidad > sacarina.getCantidadMax()) {
            sacarina.setCantidadActual(sacarina.getCantidadMax());
        }

    }

    //metodo para rellenar el deposito completo, recibe la opcion del deposito
    public void rellenarDepositoCompleto(int opcionDeposito) {
        switch (opcionDeposito) {
            case 1:
                cafe.llenarDepositoCompleto();
                break;

            case 2:
                cafeDescafeinado.llenarDepositoCompleto();
                break;

            case 3:
                azucar.llenarDepositoCompleto();
                break;

            case 4:
                chocolate.llenarDepositoCompleto();
                break;

            case 5:
                agua.llenarDepositoCompleto();
                break;

            case 6:
                leche.llenarDepositoCompleto();
                break;
            case 7:
                sacarina.llenarDepositoCompleto();
                break;
            case 8:

                break;

        }

    }
     //metodo para Comprobar depósitos, que verifica cada indicador de cada depósito, informando de aquellos depósitos que deben ser rellenados.
    public boolean reserva() {
        boolean reserva=false;
        
        if (getCafe().isReserva()) {
            System.out.println(getCafe());
            reserva=true;
        }
        if (getCafeDescafeinado().isReserva()) {
            System.out.println(getCafeDescafeinado());
            reserva=true;

        }
        if (getAzucar().isReserva()) {
            System.out.println(getAzucar());
            reserva=true;

        }
        if (getChocolate().isReserva()) {
            System.out.println(getChocolate());
            reserva=true;

        }
        if (getAgua().isReserva()) {
            System.out.println(getAgua());
            reserva=true;

        }
        if (getLeche().isReserva()) {
            System.out.println(getLeche());
            reserva=true;

        }
        if (getSacarina().isReserva()) {
            System.out.println(getSacarina());
            reserva=true;

        } 
        
        return reserva;
    }
//-------------------------------------------------------------------------------------------------------------------------------------

    //getters y setters
    public void setSaldoAcumulado(double saldoAcumulado) {
        this.saldoAcumulado += saldoAcumulado;
    }

    public void setSaldoCliente(double saldoCliente) {
        this.saldoCliente = saldoCliente;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setNumVentas(int numVentas) {
        this.numVentas += numVentas;
    }

    public double getSaldoAcumulado() {
        return saldoAcumulado;
    }

    public double getSaldoCliente() {
        return saldoCliente;
    }

    public double getPrecio() {
        return precio;
    }

    public int getNumVentas() {
        return numVentas;
    }

    public Deposito getCafe() {
        return cafe;
    }

    public Deposito getCafeDescafeinado() {
        return cafeDescafeinado;
    }

    public Deposito getAzucar() {
        return azucar;
    }

    public Deposito getChocolate() {
        return chocolate;
    }

    public Deposito getAgua() {
        return agua;
    }

    public Deposito getLeche() {
        return leche;
    }

    public Deposito getSacarina() {
        return sacarina;
    }

}
