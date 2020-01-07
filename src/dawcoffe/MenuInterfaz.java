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

//    private Deposito cafe = new Deposito(1000, 250, 1000, "cafe");
//    private Deposito cafeDescafeinado = new Deposito(1000, 250, 1000, "cafeDescafeinado");
//    private Deposito azucar = new Deposito(1000, 250, 1000, "azucar");
//    private Deposito chocolate = new Deposito(1000, 250, 1000, "chocolate");
//    private Deposito agua = new Deposito(1000, 250, 1000, "agua");
//    private Deposito leche = new Deposito(1000, 250, 1000, "leche");
    public void menu() {
        Scanner entrada = new Scanner(System.in);
        int codigo;
        int opcion;
//        String descafeinado = null;
        Cafetera cafetera = new Cafetera();
//        int cantidadAzucar = 0;
//        String Azucar = null;
        double saldoCliente = 0;
        double cambio = 0;

        double precio;
        String menu;
        String salir = "no";

        String cafe1 = "Café solo (0.80€), codigo 101";
        String cafe2 = "Café solo largo (0.90€), codigo 102";
        String cafe3 = "Café con leche (1.10€), codigo 103";
        String cafe4 = "Café cortado (1.00€), codigo 104";
        String Choco = "Chocolate (1.40€), codigo 200";
        String lecheFria = "Leche fría (0.50€) codigo 300";
        String lecheCaliente = "Leche caliente (0.50€), codigo 301";
        do {
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
                        System.out.println(Choco);
                        System.out.println(lecheFria);
                        System.out.println(lecheCaliente);
                        codigo = entrada.nextInt();

                        if (cafetera.informarFaltaExistencias()) {
                            break;
                        }
//                        if (agua.getCantidadActual() < 50 || leche.getCantidadActual() < 180 || cafe.getCantidadActual() < 8 || chocolate.getCantidadActual() < 12) {
//                            System.out.println("Lo sentimos pero no podemos, servirle");
//                            break;
//
//                        }
                        //introduce el dinero
                        System.out.println("Introduzca el dinero (separe los decimales con una coma, por favor)");

                        saldoCliente += entrada.nextDouble();
                        cafetera.setSaldoCliente(saldoCliente);
                        System.out.println("saldoCliente " + cafetera.getSaldoCliente());

                        //decide si descafeinado o no
//                        if (codigo > 100 && codigo <= 104) {
//                            System.out.println("Lo quiere descafeinado SI/NO");
//                            descafeinado = entrada.next();
//                            do {
//                                if (descafeinado.equalsIgnoreCase("SI")) {
//                                    descafeinado = "SI";
//                                } else {
//                                    descafeinado = "NO";
//                                }
//                            } while (!descafeinado.equalsIgnoreCase("SI") && !descafeinado.equalsIgnoreCase("NO"));
//
//                        }
                        cafetera.restarAzucar();
                        //si saldo cliente es mayor que el precio minimo, decide cantidad de azucar
//                        if (cafetera.getSaldoCliente() >= 0.50) {
//                            System.out.println("Cuanta azucar quiere");
//                            System.out.println("1. ninguna");
//                            System.out.println("2. poca");
//                            System.out.println("3. mucha");
//                            cantidadAzucar = entrada.nextInt();
//
//                            //resta el contenido de azucar al deposito
//                            switch (cantidadAzucar) {
//                                case 1:
//                                    azucar.servirContenido(0);
//                                    break;
//                                case 2:
//                                    if (azucar.getCantidadActual() < 6) {
//                                        System.out.println("Lo sentimos pero no, queda azucar");
//                                        azucar.servirContenido(0);
//                                    }
//                                    azucar.servirContenido(6);
//                                    break;
//                                case 3:
//                                    if (azucar.getCantidadActual() < 12) {
//                                        System.out.println("Lo sentimos pero solo queda: " + azucar.getCantidadActual());
//
//                                        int azucarRestante = (int) azucar.getCantidadActual();
//                                        azucar.servirContenido(azucarRestante);
//
//                                    }
//                                    azucar.servirContenido(12);
//
//                                    break;
//                            }
//                        }
//                        //guarda string de cantidad de azucar, para mostrarlo luego
//                        switch (cantidadAzucar) {
//                            case 1:
//                                Azucar = "ninguna";
//                                break;
//                            case 2:
//                                Azucar = "poca";
//
//                                break;
//                            case 3:
//                                Azucar = "mucha";
//
//                                break;
//                        }
                        //Muestra el pedido del cliente....
                        System.out.println("................................................");
                        switch (codigo) {
                            case 101:
                                cafetera.setPrecio(0.80);

                                menu = cafe1;
                                //si ha introducido el precio minimo para el articulo
                                cafetera.comprobarPrecio();

//----------------------------------------------------------------------
                                //resta la cantidad de cafe,y agua 
                                cafetera.restarCafe(codigo);
                                cafetera.mostrarInformacion(menu);

//-------------------------------------------------------------------------------------------------------------------------------
                                break;
                            case 102:
                                cafetera.setPrecio(0.90);

                                menu = cafe2;
                                cafetera.comprobarPrecio();

                                //resta la cantidad de cafe,y agua 
                                cafetera.restarCafe(codigo);
                                cafetera.mostrarInformacion(menu);

                                break;
                            case 103:
                                cafetera.setPrecio(1.10);

                                menu = cafe3;
                                cafetera.comprobarPrecio();

                                cafetera.restarCafe(codigo);

                                cafetera.mostrarInformacion(menu);

                                break;
                            case 104:
                                cafetera.setPrecio(1.0);

                                menu = cafe4;
                                cafetera.comprobarPrecio();

                                cafetera.restarCafe(codigo);

                                cafetera.mostrarInformacion(menu);

                                break;
                            case 200:
                                cafetera.setPrecio(1.40);

                                menu = Choco;
                                cafetera.comprobarPrecio();

                                cafetera.restarChocolate();
                                cafetera.mostrarInformacion(menu);

                                //resta la cantidad de chocolate al deposito
//                                chocolate.servirContenido(12);
//                                leche.servirContenido(180);
                                break;

                            case 300:
                                cafetera.setPrecio(0.50);

                                menu = lecheFria;

                                cafetera.mostrarInformacion(menu);
                                cafetera.restarLeche(180);

                                //resta la cantidad de leche al deposito
//                                leche.servirContenido(180);
                                break;
                            case 301:
                                cafetera.setPrecio(0.50);

                                menu = lecheCaliente;

                                cafetera.mostrarInformacion(menu);

                                //resta la cantidad de leche al deposito
                                cafetera.restarLeche(180);

//                                leche.servirContenido(180);
                                break;
                            default:
                                System.out.println("Esa opcion no se contempla");
                                opcion = 0;
                        }

                        cafetera.setSaldoCliente(0);
                        saldoCliente = 0;
                        System.out.println("");
                        System.out.println("Vuelva pronto. \nQue tenga un buen dia");
//                        System.out.println("El saldo del cliente es: " + cafetera.getSaldoCliente());

                        //Fin del case 1
//-------------------------------------------------------------------------------------------------------------------------------
                        break;
                    case 2:
                        Usuario user = new Usuario();
                        String usuario;
                        int pass,
                         cont = 0;
                        int opcionAdmin = 0;
                        int opcionDeposito;
                        int llenarDeposito;

                        do {
                            System.out.println("Introduce usuario");
                            usuario = entrada.next();
//                            usuario = "salva";
                            System.out.println("Introduce contraseña en numeros");
                            pass = entrada.nextInt();
//                            pass = 1234;
                            cont++;

                        } while (user.identificacion(usuario, pass) == false && cont < 3);

                        if (cont >= 3) {
                            System.out.println("Lo sentimos, pero el login no se ha podido realizan con exito");
                        } else {
                            System.out.println("Correcto");
                            do {
                                System.out.println("................................................");

                                System.out.println("1. Comprobar depósitos");
                                System.out.println("2. Comprobar estado general");
                                System.out.println("3. Consultar saldo de ventas realizadas.");
                                System.out.println("4. Rellenar depositos");
                                System.out.println("5. salir administracion ");

                                opcionAdmin = entrada.nextInt();

                                switch (opcionAdmin) {
                                    //Comprobar depósitos, que verifica cada indicador de cada depósito, informando de aquellos depósitos que deben ser rellenados.

                                    case 1:
                                        cafetera.reserva();
//                                        if (cafe.isReserva()) {
//                                            System.out.println(cafe);
//
//                                        } else if (cafeDescafeinado.isReserva()) {
//                                            System.out.println(cafeDescafeinado);
//
//                                        } else if (azucar.isReserva()) {
//                                            System.out.println(azucar);
//
//                                        } else if (chocolate.isReserva()) {
//                                            System.out.println(chocolate);
//
//                                        } else if (agua.isReserva()) {
//                                            System.out.println(agua);
//
//                                        } else if (leche.isReserva()) {
//                                            System.out.println(leche);
//                                        } else {
//                                            System.out.println("No hay depositos en reserva");
//                                        }
                                        break;
                                    case 2:
                                        //Comprobar estado general, que muestra toda la información de todos los depósitos, así como el usuario y la contraseña del administrador.
//                                        System.out.println("Comprobando estado general");
//                                        System.out.println(cafe);
//                                        System.out.println(cafeDescafeinado);
//                                        System.out.println(azucar);
//                                        System.out.println(chocolate);
//                                        System.out.println(agua);
//                                        System.out.println(leche);
                                        cafetera.estadoGeneral();
                                        System.out.println("Usuario: " + user.getUSER_NAME());
                                        System.out.println("Contraseña: " + user.getPASSWORD());

                                        break;
                                    case 3:
                                        //Consultar saldo de ventas realizadas.
                                        System.out.println("Consultando saldo de ventas realizadas");
                                        System.out.println("El numero de ventas es: " + cafetera.getNumVentas() + "\nEl saldo acumulado es: " + cafetera.getSaldoAcumulado());

                                        break;
                                    case 4:
                                        //-------------------------------------------------------------------------------------------------------------------------

//Rellenar depósitos. Se pregunta el depósito a rellenar y luego se dan dos opciones: rellenar completo o indicar la cantidad de producto a reponer.
                                        System.out.println("Que deposito desea rellenar");
                                        do {
                                            System.out.println("1. Café");
                                            System.out.println("2. cafeDescafeinado");
                                            System.out.println("3. azucar");
                                            System.out.println("4. chocolate");
                                            System.out.println("5. agua");
                                            System.out.println("6. leche");
                                            opcionDeposito = entrada.nextInt();
                                        } while (opcionDeposito < 1 || opcionDeposito > 6);
                                        do {
                                            System.out.println("¿Quiere rellenar el deposito \n1. completamente \n2. parcial");
                                            llenarDeposito = entrada.nextInt();
                                        } while (llenarDeposito < 1 || llenarDeposito > 2);
                                        //-------------------------------------------------------------------------------------------------------------------------
                                        cafetera.rellenarDeposito(opcionDeposito, llenarDeposito);
                                        
//                                        if (opcionDeposito == 1 && llenarDeposito == 1) {
//                                            cafe.llenarDepositoCompleto();
//                                        } else if (opcionDeposito == 1 && llenarDeposito == 2) {
//                                            System.out.println("Introduzca la cantidad");
//                                            cafe.llenarDeposito(entrada.nextDouble());
//                                        } //-------------------------------
//                                        else if (opcionDeposito == 2 && llenarDeposito == 1) {
//                                            cafeDescafeinado.llenarDepositoCompleto();
//                                        } else if (opcionDeposito == 2 && llenarDeposito == 2) {
//                                            System.out.println("Introduzca la cantidad");
//                                            cafeDescafeinado.llenarDeposito(entrada.nextDouble());
//                                        } //-------------------------------
//                                        else if (opcionDeposito == 3 && llenarDeposito == 1) {
//                                            azucar.llenarDepositoCompleto();
//                                        } else if (opcionDeposito == 3 && llenarDeposito == 2) {
//                                            System.out.println("Introduzca la cantidad");
//                                            azucar.llenarDeposito(entrada.nextDouble());
//                                        } //-------------------------------
//                                        else if (opcionDeposito == 4 && llenarDeposito == 1) {
//                                            chocolate.llenarDepositoCompleto();
//                                        } else if (opcionDeposito == 4 && llenarDeposito == 2) {
//                                            System.out.println("Introduzca la cantidad");
//                                            chocolate.llenarDeposito(entrada.nextDouble());
//                                        } //-------------------------------
//                                        else if (opcionDeposito == 5 && llenarDeposito == 1) {
//                                            agua.llenarDepositoCompleto();
//                                        } else if (opcionDeposito == 5 && llenarDeposito == 2) {
//                                            System.out.println("Introduzca la cantidad");
//                                            agua.llenarDeposito(entrada.nextDouble());
//                                        } //-------------------------------
//                                        else if (opcionDeposito == 6 && llenarDeposito == 1) {
//                                            leche.llenarDepositoCompleto();
//                                        } else if (opcionDeposito == 6 && llenarDeposito == 2) {
//                                            System.out.println("Introduzca la cantidad");
//                                            leche.llenarDeposito(entrada.nextDouble());
//                                        }
//-------------------------------------------------------------------------------------------------------------------------

                                        break;
                                    case 5:
                                        System.out.println("Saliendo de la administracion");

                                        break;
                                    default:
                                        System.out.println(
                                                "Esa opcion no se contempla1");
                                }
                            } while (opcionAdmin != 5);
                        } //Fin del case 2
                        //--------------------------------------------

                        break;

                    default:
                        System.out.println(
                                "Esa opcion no se contempla2");
                }
                System.out.println("................................................");

            } while (opcion < 1 || opcion > 2);

        } while (!salir.equalsIgnoreCase("Si"));
    }

}
