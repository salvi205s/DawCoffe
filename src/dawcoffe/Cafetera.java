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
            precios;

    private int numVentas;

    Deposito cafe = new Deposito(1000, 250, 1000, "cafe");
    Deposito cafeDescafeinado = new Deposito(1000, 250, 1000, "cafeDescafeinado");
    Deposito azucar = new Deposito(1000, 250, 1000, "azucar");
    Deposito chocolate = new Deposito(1000, 250, 1000, "chocolate");
    Deposito agua = new Deposito(1000, 250, 1000, "agua");
    Deposito leche = new Deposito(1000, 250, 1000, "leche");

    public void introducirMonedas() {

        System.out.println("Introduzca el dinero (separe los decimales con una coma, por favor)");
        setSaldoCliente(entrada.nextDouble());

        System.out.println("Saldo: " + getSaldoCliente());

    }

    public void setSaldoAcumulado(double saldoAcumulado) {
        this.saldoAcumulado += saldoAcumulado;
    }

    public void setSaldoCliente(double saldoCliente) {
        this.saldoCliente += saldoCliente;
    }

    public void setPrecios(double precios) {
        this.precios = precios;
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

    public double getPrecios() {
        return precios;
    }

    public int getNumVentas() {
        return numVentas;
    }

}
