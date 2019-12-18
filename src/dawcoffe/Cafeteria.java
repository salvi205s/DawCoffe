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
public class Cafeteria {

    private double saldoAcumulado=0,
            saldoCliente=0,
            precios;

    private int numVentas;

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
