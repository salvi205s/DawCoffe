/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dawcoffe;

import java.util.Scanner;

/**
 *
 * @author Salva
 */
public class Cafetera {

    private Scanner entrada = new Scanner(System.in);

    private double saldoAcumulado = 0,
            saldoCliente = 0,
            precio;

    private int numVentas;

        
//        Deposito cafe = new Deposito(1000, 250, 1000, "cafe");
//        Deposito cafeDescafeinado = new Deposito(1000, 250, 1000, "cafeDescafeinado");
//        Deposito azucar = new Deposito(1000, 250, 1000, "azucar");
//        Deposito chocolate = new Deposito(1000, 250, 1000, "chocolate");
//        Deposito agua = new Deposito(1000, 250, 1000, "agua");
//        Deposito leche = new Deposito(1000, 250, 1000, "leche");

  
    

    public void consultarDepositos(Deposito deposito) {

        System.out.println(deposito);
    }

    public void comprobarPrecio() {
        //si ha introducido el precio minimo para el articulo

        while (getSaldoCliente() <= precio) {
            System.out.println("Saldo insuficiente " + this.saldoCliente);
            //introduce el dinero
            System.out.println("Introduzca mas monedas");
            setSaldoCliente(entrada.nextDouble());
        };

    }

    public void mostrarInformacion(String opcion, String opcionDescafeinado, String cantAzucar) {
        double cambio = 0;

        if (getSaldoCliente() >= getPrecio()) {
            System.out.println("Ha elegido " + opcion);
            System.out.println("Descafeinado: " + opcionDescafeinado);
            System.out.println("Con " + cantAzucar + " azucar");

            cambio = getSaldoCliente() - this.precio;
            System.out.printf("Su cambio es: %.2f %n", cambio);
            //suma el saldo al saldoAcumulado
            setSaldoAcumulado(this.precio);
            //incrementa en 1 el numero de ventas
            setNumVentas(+1);
        }
    }

    public void setSaldoAcumulado(double saldoAcumulado) {
        this.saldoAcumulado += saldoAcumulado;
    }

    public void setSaldoCliente(double saldoCliente) {
        this.saldoCliente += saldoCliente;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setNumVentas(int numVentas) {
        this.numVentas = numVentas;
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
