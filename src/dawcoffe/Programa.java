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
public class Programa {

    public static void main(String[] args) {

        Deposito cafe = new Deposito(1000, 250, 3, "cafe");
        Deposito cafeDescafeinado = new Deposito(1000, 250, 1000, "cafeDescafeinado");
        Deposito azucar = new Deposito(1000, 250, 1000, "azucar");
        Deposito chocolate = new Deposito(1000, 250, 1000, "chocolate");
        Deposito agua = new Deposito(1000, 250, 1000, "agua");
        Deposito leche = new Deposito(1000, 250, 1000, "leche");
//        Se crea el objeto menu
        Cafetera cafetera = new Cafetera(cafe, cafeDescafeinado, azucar, chocolate, agua, leche);
        MenuInterfaz menu = new MenuInterfaz(cafetera);

        //y se llama
        menu.menu();

    }
}
