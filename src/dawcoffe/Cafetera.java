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
    private Scanner entrada = new Scanner(System.in);

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
//        String opcion;

//        setPrecio(precio);
        
//        opcion = menu;
//        comprobarPrecio();

        restarCafe(codigo);

    }

    public void servirChocolate(String menu, int codigo) {
//        String opcion;
//        setPrecio(precio);
//        opcion = menu;
//        comprobarPrecio();

//resta la cantidad de chocolate al deposito
        restarChocolate(12);
        restarLeche(180);

    }

    public void servirLeche(String menu, int codigo) {
//        String opcion;
//        setPrecio(precio);
//        opcion = menu;
//        comprobarPrecio();

        restarLeche(180);
    }

    //metodo para comprobar el precio del articulo
    public boolean comprobarPrecio() {

        boolean precioCorrecto = false;
//        System.out.println("saldoCliente " + getSaldoCliente());
//        System.out.println("getPrecio " + getPrecio());

        if (getSaldoCliente() >= getPrecio()) {
            precioCorrecto = true;
        }
//        //si no ha introducido el precio minimo para el articulo, avisara del saldo insuficiente
//        while (precioCorrecto) {
//
////            System.out.println("Saldo insuficiente " + this.saldoCliente);
////            //introduce el dinero
////            System.out.println("Introduzca mas monedas");
////            System.out.println("saldoCliente " + getSaldoCliente());
////
////            saldoCliente += entrada.nextDouble();
////            setSaldoCliente(saldoCliente);
////            System.out.println("saldoCliente " + getSaldoCliente());
//        }

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
            System.out.println("Lo sentimos pero no podemos, servirle");
            faltaExistencias = true;
        }
        return faltaExistencias;
    }

    //metodos para restar el contenido de los depositos
    public void restarLeche(int cantidad) {
        leche.servirContenido(cantidad);

    }

    //metodo deposito de cafe
    public void restarCafe(int codigo) {

        String descafeinado = null;

        //decide si descafeinado o no
        System.out.println("Lo quiere descafeinado SI/NO");
        descafeinado = entrada.next();
        do {
            if (descafeinado.equalsIgnoreCase("SI")) {
                descafeinado = "SI";
                System.out.println("Ha elegido: cafe descafeinado");
            } else {
                descafeinado = "NO";
                System.out.println("Ha elegido: cafe con cafeina");

            }
        } while (!descafeinado.equalsIgnoreCase("SI") && !descafeinado.equalsIgnoreCase("NO"));

        if (codigo == 101) {
            if (descafeinado.equalsIgnoreCase("si")) {
                cafeDescafeinado.servirContenido(8);
            } else {
                cafe.servirContenido(8);

            }
            agua.servirContenido(50);
        } else if (codigo == 102) {
            if (descafeinado.equalsIgnoreCase("si")) {
                cafeDescafeinado.servirContenido(8);
            } else {
                cafe.servirContenido(8);

            }
            agua.servirContenido(80);
        } else if (codigo == 103) {
            if (descafeinado.equalsIgnoreCase("si")) {
                cafeDescafeinado.servirContenido(8);
            } else {
                cafe.servirContenido(8);

            }
            agua.servirContenido(50);
            restarLeche(20);
//            leche.servirContenido(20);
        } else if (codigo == 104) {
            if (descafeinado.equalsIgnoreCase("si")) {
                cafeDescafeinado.servirContenido(8);
            } else {
                cafe.servirContenido(8);

            }
            agua.servirContenido(50);
            restarLeche(20);

//            leche.servirContenido(10);
        }

    }

    public void restarChocolate(int cantidad) {
        chocolate.servirContenido(cantidad);

    }

    public void restarAzucar() {
        int cantidadAzucar = 0;
        String Azucar = null;

        if (getSaldoCliente() >= 0.50) {
            System.out.println("Cuanta azucar quiere");
            System.out.println("1. ninguna");
            System.out.println("2. poca");
            System.out.println("3. mucha");
            cantidadAzucar = entrada.nextInt();

            //resta el contenido de azucar al deposito
            switch (cantidadAzucar) {
                case 1:
                    azucar.servirContenido(0);
                    break;
                case 2:
                    if (azucar.getCantidadActual() < 6) {
                        System.out.println("Lo sentimos pero no, queda azucar");
                        azucar.servirContenido(0);
                    }
                    azucar.servirContenido(6);
                    break;
                case 3:
                    if (azucar.getCantidadActual() < 12) {
                        System.out.println("Lo sentimos pero solo queda: " + azucar.getCantidadActual());

                        int azucarRestante = (int) azucar.getCantidadActual();
                        azucar.servirContenido(azucarRestante);

                    }
                    azucar.servirContenido(12);

                    break;
            }

        }
        //guarda string de cantidad de azucar, para mostrarlo luego
        switch (cantidadAzucar) {
            case 1:
                Azucar = "ninguna";
                System.out.println("Ha elegido: sin azucar");
                break;
            case 2:
                Azucar = "poca";
                System.out.println("Ha elegido: poca azucar");

                break;
            case 3:
                Azucar = "mucha";
                System.out.println("Ha elegido: mucha azucar");

                break;
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
        System.out.println("Comprobando estado general");
        System.out.println(cafe);
        System.out.println(cafeDescafeinado);
        System.out.println(azucar);
        System.out.println(chocolate);
        System.out.println(agua);
        System.out.println(leche);
    }

    public void rellenarDeposito(int opcionDeposito, int llenarDeposito) {
        if (opcionDeposito == 1 && llenarDeposito == 1) {
            cafe.llenarDepositoCompleto();
        } else if (opcionDeposito == 1 && llenarDeposito == 2) {
            System.out.println("Introduzca la cantidad");
            cafe.llenarDeposito(entrada.nextDouble());
        } //-------------------------------
        else if (opcionDeposito == 2 && llenarDeposito == 1) {
            cafeDescafeinado.llenarDepositoCompleto();
        } else if (opcionDeposito == 2 && llenarDeposito == 2) {
            System.out.println("Introduzca la cantidad");
            cafeDescafeinado.llenarDeposito(entrada.nextDouble());
        } //-------------------------------
        else if (opcionDeposito == 3 && llenarDeposito == 1) {
            azucar.llenarDepositoCompleto();
        } else if (opcionDeposito == 3 && llenarDeposito == 2) {
            System.out.println("Introduzca la cantidad");
            azucar.llenarDeposito(entrada.nextDouble());
        } //-------------------------------
        else if (opcionDeposito == 4 && llenarDeposito == 1) {
            chocolate.llenarDepositoCompleto();
        } else if (opcionDeposito == 4 && llenarDeposito == 2) {
            System.out.println("Introduzca la cantidad");
            chocolate.llenarDeposito(entrada.nextDouble());
        } //-------------------------------
        else if (opcionDeposito == 5 && llenarDeposito == 1) {
            agua.llenarDepositoCompleto();
        } else if (opcionDeposito == 5 && llenarDeposito == 2) {
            System.out.println("Introduzca la cantidad");
            agua.llenarDeposito(entrada.nextDouble());
        } //-------------------------------
        else if (opcionDeposito == 6 && llenarDeposito == 1) {
            leche.llenarDepositoCompleto();
        } else if (opcionDeposito == 6 && llenarDeposito == 2) {
            System.out.println("Introduzca la cantidad");
            leche.llenarDeposito(entrada.nextDouble());
        }
    }

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
