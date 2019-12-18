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
public class MenuInterfaz {

    public static void menu() {
        Scanner entrada = new Scanner(System.in);
        int codigo;
        int opcion;
        String descafeinado = null;
        Cafetera monedas = new Cafetera();
        int cantidadAzucar = 0;
        String Azucar = null;

        String cafe1 = "Café solo (0.80€), codigo 101";
        String cafe2 = "Café solo largo (0.90€), codigo 102";
        String cafe3 = "Café con leche (1.10€), codigo 103";
        String cafe4 = "Café cortado (1.00€), codigo 104";
        String chocolate = "Chocolate (1.40€), codigo 200";
        String lecheFria = "Leche fría (0.50€) codigo 300";
        String lecheCaliente = "Leche caliente (0.50€), codigo 301";
    }

}
