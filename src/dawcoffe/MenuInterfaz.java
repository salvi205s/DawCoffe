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
        double saldoCliente=0;
        double cambio = 0;

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
                    //El set no esta guardando el dinero
                    System.out.println("Introduzca el dinero (separe los decimales con una coma, por favor)");
                    saldoCliente = entrada.nextDouble();
                    monedas.setSaldoCliente(saldoCliente);

                    System.out.println("Saldo: " + saldoCliente);

                    //decide si descafeinado o no
                    if (codigo > 100 && codigo <= 104) {
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
                    if (saldoCliente >= 0.50) {
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

                    //Muestra el pedido del cliente....
                    //problema con el saldo insuficiente
                    switch (codigo) {
                        case 101:
                            //si ha introducido el precio minimo para el articulo
                            while (saldoCliente <= 0.80) {
                                System.out.println("Saldo insuficiente " + saldoCliente);
                                //introduce el dinero
                                System.out.println("Introduzca mas monedas");
                                saldoCliente+=entrada.nextDouble();
                            }

                            if (saldoCliente >= 0.80) {
                                System.out.println("Ha elegido " + cafe1);
                                System.out.println("Descafeinado: " + descafeinado);
                                System.out.println("Con " + Azucar + " azucar");
                                cambio=saldoCliente- 0.80;
                                System.out.printf("Su cambio es: %.2f %n",cambio);
                            }

                            //resta la cantidad de cafe, agua y azucar al deposito
                            //suma el saldo al saldoAcumulado
                            break;
                        case 102:
                            while (saldoCliente <= 0.90) {
                                System.out.println("Saldo insuficiente " + saldoCliente);
                                //introduce el dinero
                                System.out.println("Introduzca mas monedas");
                                saldoCliente+=entrada.nextDouble();
                            }

                            if (saldoCliente >= 0.90) {
                                System.out.println("Ha elegido " + cafe2);
                                System.out.println("Descafeinado: " + descafeinado);
                                System.out.println("Con " + Azucar + " azucar");
                                
                            }
                            //resta la cantidad de cafe, agua y azucar al deposito

                            break;
                        case 103:
                            while (saldoCliente <= 1.10) {
                                System.out.println("Saldo insuficiente " + saldoCliente);
                                //introduce el dinero
                                System.out.println("Introduzca mas monedas");
                                saldoCliente+=entrada.nextDouble();
                            }

                            if (saldoCliente >= 1.10) {
                                System.out.println("Ha elegido " + cafe3);
                                System.out.println("Descafeinado: " + descafeinado);
                                System.out.println("Con " + Azucar + " azucar");
                            }

                            //resta la cantidad de cafe, agua, leche y azucar al deposito
                            break;
                        case 104:
                            while (saldoCliente <= 1.0) {
                                System.out.println("Saldo insuficiente " + saldoCliente);
                                //introduce el dinero
                                System.out.println("Introduzca mas monedas");
                                saldoCliente+=entrada.nextDouble();
                            }

                            if (saldoCliente >= 1.0) {

                                System.out.println("Ha elegido " + cafe4);
                                System.out.println("Descafeinado: " + descafeinado);
                                System.out.println("Con " + Azucar + " azucar");
                            }

                            //resta la cantidad de cafe, agua, leche y azucar al deposito
                            break;
                        case 200:

                            while (saldoCliente <= 1.40) {
                                System.out.println("Saldo insuficiente " + saldoCliente);
                                //introduce el dinero
                                System.out.println("Introduzca mas monedas");
                                saldoCliente+=entrada.nextDouble();
                            }

                            if (saldoCliente >= 1.40) {

                                System.out.println("Ha elegido " + chocolate);
                                System.out.println("Con " + Azucar + " azucar");
                            }

                            //resta la cantidad de chocolate al deposito
                            break;
                        case 201:
                            System.out.println("Ha elegido " + lecheFria);
                            System.out.println("Con " + Azucar + " azucar");
                            //resta la cantidad de leche al deposito

                            break;

                        case 300:
                            System.out.println("Ha elegido " + lecheCaliente);
                            System.out.println("Con " + Azucar + " azucar");
                            //resta la cantidad de leche al deposito

                            break;

                        default:
                            System.out.println("Esa opcion no se contempla");
                            opcion = 0;
                    }
                    //Fin del case 1
                    //--------------------------------------------
                    break;
                case 2:
                    Usuario user = new Usuario();
                    String usuario;
                    int pass,
                     cont = 0;

                    do {
                        System.out.println("Introduce usuario");
                        usuario = entrada.next();
                        System.out.println("Introduce contraseña");
                        pass = entrada.nextInt();

                        cont++;

                    } while (user.identificacion(usuario, pass)
                            == false && cont < 3);
                    if (cont
                            >= 3) {
                        System.out.println("Lo sentimos, pero el login no se ha podido realizan con exito");
                    } else {
                        System.out.println("Correcto");
                    }
                    //------------------------------------------

                    break;
                default:
                    System.out.println(
                            "Esa opcion no se contempla");
            }

        } while (opcion < 1 || opcion > 2);

    }

}
