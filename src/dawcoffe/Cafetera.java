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

    private int numVentas;

//        Deposito cafe = new Deposito(1000, 250, 1000, "cafe");
//        Deposito cafeDescafeinado = new Deposito(1000, 250, 1000, "cafeDescafeinado");
//        Deposito azucar = new Deposito(1000, 250, 1000, "azucar");
//        Deposito chocolate = new Deposito(1000, 250, 1000, "chocolate");
//        Deposito agua = new Deposito(1000, 250, 1000, "agua");
//        Deposito leche = new Deposito(1000, 250, 1000, "leche");
    //metodo para comprobar el precio del articulo
    public void comprobarPrecio() {

        //si no ha introducido el precio minimo para el articulo, avisara del saldo insuficiente
        while (getSaldoCliente() <= precio) {

            System.out.println("Saldo insuficiente " + this.saldoCliente);
            //introduce el dinero
            System.out.println("Introduzca mas monedas");
            System.out.println("saldoCliente " + getSaldoCliente());

            saldoCliente += entrada.nextDouble();
            setSaldoCliente(saldoCliente);
            System.out.println("saldoCliente " + getSaldoCliente());

        };

    }

    //muestra informacion del producto elegido
    public void mostrarInformacion(String opcion, String opcionDescafeinado, String cantAzucar) {
        double cambio = 0;

        //si el precio es mayor o igual al del articulo muestra la informacion
        if (getSaldoCliente() >= getPrecio()) {
            System.out.println("Ha elegido " + opcion);
            System.out.println("Descafeinado: " + opcionDescafeinado);
            System.out.println("Con " + cantAzucar + " azucar");

            //calcula el cambio a devolver
            cambio = getSaldoCliente() - this.precio;
            System.out.printf("Su cambio es: %.2f %n", cambio);
            //suma el saldo al saldoAcumulado
            setSaldoAcumulado(this.precio);
            //incrementa en 1 el numero de ventas
            setNumVentas(+1);
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
