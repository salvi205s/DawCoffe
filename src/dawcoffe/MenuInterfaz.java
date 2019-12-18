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

        do {
            System.out.println("1. Venta de productos");
            System.out.println("2. Administración de la cafetera");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    //muestra el menu
                    System.out.println(cafe1);
                    System.out.println(cafe2);
                    System.out.println(cafe3);
                    System.out.println(cafe4);
                    System.out.println(chocolate);
                    System.out.println(lecheFria);
                    System.out.println(lecheCaliente);
                    codigo = entrada.nextInt();

                    //introduce el dinero
                    System.out.println("Introduzca el dinero");
                    monedas.setSaldoAcumulado(entrada.nextDouble());

                    //decide si descafeinado o no
                    if (codigo > 100 && codigo <= 104 && monedas.getSaldoCliente() >= 0.80) {
                        System.out.println("Lo quiere descafeinado SI/NO");
                        descafeinado = entrada.next();
                        do {
                            if (descafeinado.equalsIgnoreCase("SI")) {
                                descafeinado = "SI";
                            } else {
                                descafeinado = "NO";
                            }
                        } while (!descafeinado.equalsIgnoreCase("SI") && !descafeinado.equalsIgnoreCase("NO"));

                    }

                    //si saldo cliente es mayor que el precio minimo, decide cantidad de azucar
                    if (monedas.getSaldoCliente() >= 0.50) {
                        System.out.println("Cuanta azucar quiere");
                        System.out.println("1. ninguna");
                        System.out.println("2. poca");
                        System.out.println("3. mucha");
                        cantidadAzucar = entrada.nextInt();

                    }
                    
                    //guarda string de cantidad de azucar, para mostrarlo luego
                    switch (cantidadAzucar) {
                        case 1:
                            Azucar = "ninguna";
                            break;
                        case 2:
                            Azucar = "poca";

                            break;
                        case 3:
                            Azucar = "mucha";

                            break;
                    }
//--------------------------------------------
            }

        } while (opcion < 1 || opcion > 2);

    }

}
