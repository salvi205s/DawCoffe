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
        Cafetera cafetera = new Cafetera();
        int cantidadAzucar = 0;
        String Azucar = null;
        double saldoCliente = 0;
        double cambio = 0;

        double precio;
        String menu;

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
//            opcion = entrada.nextInt();
            opcion = 1;

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

//----------------------------------------------------------------------
                    //introduce el dinero
                    System.out.println("Introduzca el dinero (separe los decimales con una coma, por favor)");

                    cafetera.setSaldoCliente(2);
//----------------------------------------------------------------------
                    System.out.println("saldoCliente " + cafetera.getSaldoCliente());

                    //decide si descafeinado o no
                    if (codigo > 100 && codigo <= 104) {
                        System.out.println("Lo quiere descafeinado SI/NO");
//                        descafeinado = entrada.next();
                        descafeinado = "Si";
                        do {
                            if (descafeinado.equalsIgnoreCase("SI")) {
                                descafeinado = "SI";
                            } else {
                                descafeinado = "NO";
                            }
                        } while (!descafeinado.equalsIgnoreCase("SI") && !descafeinado.equalsIgnoreCase("NO"));

                    }

                    //si saldo cliente es mayor que el precio minimo, decide cantidad de azucar
                    if (cafetera.getSaldoCliente() >= 0.50) {
                        System.out.println("Cuanta azucar quiere");
                        System.out.println("1. ninguna");
                        System.out.println("2. poca");
                        System.out.println("3. mucha");
//                        cantidadAzucar = entrada.nextInt();
                        cantidadAzucar = 2;

                        //resta el contenido de azucar al deposito
//                        switch (cantidadAzucar) {
//                            case 1:
//                                deposito.azucar.servirContenido(0);
//                                break;
//                            case 2:
//                                deposito.azucar.servirContenido(6);
//
//                                break;
//                            case 3:
//                                deposito.azucar.servirContenido(12);
//
//                                break;
//                        }
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
                    switch (codigo) {
                        case 101:
                            cafetera.setPrecio(0.80);

                            menu = cafe1;
//----------------------------------------------------------------------
                            //si ha introducido el precio minimo para el articulo
                            cafetera.comprobarPrecio();

                            cafetera.mostrarInformacion(menu, descafeinado, Azucar);
//----------------------------------------------------------------------
                            //resta la cantidad de cafe, agua y azucar al deposito
                            break;
                        case 102:
                            cafetera.setPrecio(0.90);

                            menu = cafe2;
                            cafetera.comprobarPrecio();

                            cafetera.mostrarInformacion(menu, descafeinado, Azucar);

                            //resta la cantidad de cafe, agua y azucar al deposito
                            break;
                        case 103:
                            cafetera.setPrecio(1.10);

                            menu = cafe3;

                            cafetera.mostrarInformacion(menu, descafeinado, Azucar);

                            //resta la cantidad de cafe, agua, leche y azucar al deposito
                            break;
                        case 104:
                            cafetera.setPrecio(1.0);

                            menu = cafe4;

                            cafetera.mostrarInformacion(menu, descafeinado, Azucar);

                            //resta la cantidad de cafe, agua, leche y azucar al deposito
                            break;
                        case 200:
                            cafetera.setPrecio(1.40);

                            menu = chocolate;

                            cafetera.mostrarInformacion(menu, descafeinado, Azucar);

                            //resta la cantidad de chocolate al deposito
                            break;
                        case 201:
                            cafetera.setPrecio(0.50);

                            menu = lecheCaliente;

                            cafetera.mostrarInformacion(menu, descafeinado, Azucar);

                            //resta la cantidad de leche al deposito
                            break;

                        case 300:
                            cafetera.setPrecio(0.50);

                            menu = lecheFria;

                            cafetera.mostrarInformacion(menu, descafeinado, Azucar);

                            //resta la cantidad de leche al deposito
                            break;

                        default:
                            System.out.println("Esa opcion no se contempla");
                            opcion = 0;
                    }
                    cafetera.setSaldoCliente(0);

                    //Fin del case 1
                    //--------------------------------------------
                    break;
                case 2:
                    Usuario user = new Usuario();
                    String usuario;
                    int pass,
                     cont = 0;
                    int opcionAdmin = 0;

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
                        //
                        System.out.println("1. Ver capacidad maxima");
                        System.out.println("2. Ver capacidad Umbral");
                        System.out.println("3. Ver capacidad actual");
                        System.out.println("4. Rellenar depositos");

                        opcionAdmin = entrada.nextInt();

//                        switch (opcionAdmin) {
//                            case 1:
//                                System.out.println("Que deposito quiere consultar");
//                                break;
//                            case 2:
//                                deposito.azucar.servirContenido(6);
//
//                                break;
//                            case 3:
//                                deposito.azucar.servirContenido(12);
//
//                                break;
//                        }
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
