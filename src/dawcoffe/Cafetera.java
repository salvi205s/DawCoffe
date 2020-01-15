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

    //objeto scanner para introducir texto por teclado
//    private Scanner entrada = new Scanner(System.in);
    //variables que iremos usando a lo largo del programa
    private double saldoAcumulado = 0,
            saldoCliente = 0,
            precio;

    private int numVentas = 0;

    private Deposito cafe;
    private Deposito cafeDescafeinado;
    private Deposito azucar;
    private Deposito chocolate;
    private Deposito agua;
    private Deposito leche;

    public Cafetera(Deposito cafe, Deposito cafeDescafeinado, Deposito azucar, Deposito chocolate, Deposito agua, Deposito leche) {
        this.cafe = cafe;
        this.cafeDescafeinado = cafeDescafeinado;
        this.azucar = azucar;
        this.chocolate = chocolate;
        this.agua = agua;
        this.leche = leche;
    }

    public Cafetera() {
    }

    public void servirCafe(String menu, int codigo) {

        restarCafe(codigo);

    }

    public void servirChocolate(String menu, int codigo) {

//resta la cantidad de chocolate al deposito
        restarChocolate(12);
        restarLeche(180);

    }

    public void servirLeche(String menu, int codigo) {

        restarLeche(180);
    }

    //metodo para comprobar el precio del articulo
    public boolean comprobarPrecio() {

        boolean precioCorrecto = false;

        if (getSaldoCliente() >= getPrecio()) {
            precioCorrecto = true;
        }

        return precioCorrecto;
    }

    public double devolverCambio() {
        double cambio = 0;

        //calcula el cambio a devolver
        cambio = getSaldoCliente() - this.precio;

//        //suma el saldo al saldoAcumulado
        setSaldoAcumulado(this.precio);
        //incrementa en 1 el numero de ventas
        setNumVentas(1);

        return cambio;
    }

    public boolean informarFaltaExistencias() {
        boolean faltaExistencias = false;

        if (agua.getCantidadActual() < 50 || leche.getCantidadActual() < 180 || cafe.getCantidadActual() < 8 || chocolate.getCantidadActual() < 12) {
            faltaExistencias = true;
        }
        return faltaExistencias;
    }

    //metodos para restar el contenido de los depositos
    public void restarLeche(int cantidad) {
        leche.servirContenido(cantidad);

    }

    public void restarCafeDescafeinado(int codigo) {
        String descafeinado = null;
        if (codigo == 101) {

            cafeDescafeinado.servirContenido(8);
            agua.servirContenido(50);

        } else if (codigo == 102) {
            cafeDescafeinado.servirContenido(8);

            agua.servirContenido(80);
        } else if (codigo == 103) {
            cafeDescafeinado.servirContenido(8);
            agua.servirContenido(50);
            restarLeche(30);

        } else if (codigo == 104) {
            cafeDescafeinado.servirContenido(8);

            agua.servirContenido(50);
            restarLeche(30);

        }
    }
    //metodo deposito de cafe

    public void restarCafe(int codigo) {

        if (codigo == 101) {

            cafe.servirContenido(8);

            agua.servirContenido(50);

        } else if (codigo == 102) {

            cafe.servirContenido(8);

            agua.servirContenido(80);
        } else if (codigo == 103) {

            cafe.servirContenido(8);

            agua.servirContenido(50);
            restarLeche(30);
        } else if (codigo == 104) {

            cafe.servirContenido(8);

            agua.servirContenido(50);
            restarLeche(30);

        }

    }

    public void restarChocolate(int cantidad) {
        chocolate.servirContenido(cantidad);

    }

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

    //Comprobar depósitos, que verifica cada indicador de cada depósito, informando de aquellos depósitos que deben ser rellenados.
    public void reserva() {
        if (cafe.isReserva()) {
            System.out.println(cafe);

        } else if (cafeDescafeinado.isReserva()) {
            System.out.println(cafeDescafeinado);

        } else if (azucar.isReserva()) {
            System.out.println(azucar);

        } else if (chocolate.isReserva()) {
            System.out.println(chocolate);

        } else if (agua.isReserva()) {
            System.out.println(agua);

        } else if (leche.isReserva()) {
            System.out.println(leche);
        } else {
            System.out.println("No hay depositos en reserva");
        }
    }

    public void estadoGeneral() {
        System.out.println(cafe);
        System.out.println(cafeDescafeinado);
        System.out.println(azucar);
        System.out.println(chocolate);
        System.out.println(agua);
        System.out.println(leche);
    }
//-------------------------------------------------------------------------------------------------------------------------------------

    public void rellenarDeposito(int opcionDeposito, int llenarDeposito, double cantidad) {
        if (opcionDeposito == 1 && llenarDeposito == 1) {
            cafe.llenarDepositoCompleto();
        } else if (opcionDeposito == 1 && llenarDeposito == 2) {
//            System.out.println("Introduzca la cantidad");
            cafe.llenarDeposito(cantidad);
        } //-------------------------------
        else if (opcionDeposito == 2 && llenarDeposito == 1) {
            cafeDescafeinado.llenarDepositoCompleto();
        } else if (opcionDeposito == 2 && llenarDeposito == 2) {
//            System.out.println("Introduzca la cantidad");
            cafeDescafeinado.llenarDeposito(cantidad);
        } //-------------------------------
        else if (opcionDeposito == 3 && llenarDeposito == 1) {
            azucar.llenarDepositoCompleto();
        } else if (opcionDeposito == 3 && llenarDeposito == 2) {
//            System.out.println("Introduzca la cantidad");
            azucar.llenarDeposito(cantidad);
        } //-------------------------------
        else if (opcionDeposito == 4 && llenarDeposito == 1) {
            chocolate.llenarDepositoCompleto();
        } else if (opcionDeposito == 4 && llenarDeposito == 2) {
//            System.out.println("Introduzca la cantidad");
            chocolate.llenarDeposito(cantidad);
        } //-------------------------------
        else if (opcionDeposito == 5 && llenarDeposito == 1) {
            agua.llenarDepositoCompleto();
        } else if (opcionDeposito == 5 && llenarDeposito == 2) {
//            System.out.println("Introduzca la cantidad");
            agua.llenarDeposito(cantidad);
        } //-------------------------------
        else if (opcionDeposito == 6 && llenarDeposito == 1) {
            leche.llenarDepositoCompleto();
        } else if (opcionDeposito == 6 && llenarDeposito == 2) {
//            System.out.println("Introduzca la cantidad");
            leche.llenarDeposito(cantidad);
        }
        System.out.println(cafe.getCantidadActual());
        System.out.println(cafe.getCantidadMax());

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

}
