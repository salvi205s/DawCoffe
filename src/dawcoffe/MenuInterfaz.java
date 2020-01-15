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

    private Scanner entrada = new Scanner(System.in);

    private Cafetera cafetera;
    private int cantidadAzucar = 0;

    public MenuInterfaz(Cafetera cafetera) {
        this.cafetera = cafetera;
    }

    //muestra informacion si el producto elegido es cafe
    public void mostrarInformacion(String menu, int descafeinadoSiNo) {
        String Azucar = null;
        String descafeinado;

        if (descafeinadoSiNo == 1) {
            descafeinado = "Si";
        } else {
            descafeinado = "No";

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

        System.out.println("...................................");
        System.out.println("Ha elegido " + menu);
        System.out.println("Descafeinado: " + descafeinado);
        System.out.println("Con " + Azucar + " azucar");

    }
//muestra informacion si el producto elegido no es cafe

    public void mostrarInformacion(String menu) {
        String Azucar = null;

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

        System.out.println("Ha elegido " + menu);
        System.out.println("Con " + Azucar + " azucar");

    }

    public void pedirMasDinero(double saldoCliente) {
//        double saldoCliente = 0;

        //si no ha introducido el precio minimo para el articulo, avisara del saldo insuficiente
        while (!cafetera.comprobarPrecio()) {

            System.out.println("Saldo insuficiente " + cafetera.getSaldoCliente());
            //introduce el dinero
            System.out.println("Introduzca mas monedas");
            System.out.println("Su saldo es: " + cafetera.getSaldoCliente());

            saldoCliente += entrada.nextDouble();
            cafetera.setSaldoCliente(saldoCliente);
            System.out.println("Su saldo es: " + cafetera.getSaldoCliente());
        }

    }

    public void servirAzucar() {

        //si saldo cliente es mayor que el precio minimo, decide cantidad de azucar
//        if (cafetera.getSaldoCliente() >= 0.50) {
        System.out.println("Cuanta azucar quiere");
        System.out.println("1. ninguna");
        System.out.println("2. poca");
        System.out.println("3. mucha");
        cantidadAzucar = entrada.nextInt();

        cafetera.restarAzucar(cantidadAzucar);

//        }
    }

    public void menu() {
//        Scanner entrada = new Scanner(System.in);
        int codigo;
        int opcion;
        int descafeinadoSiNo = 0;

//        int cantidadAzucar = 0;
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
                            System.out.println("Lo sentimos pero no podemos, servirle");

                            break;
                        }

                        //introduce el dinero
                        System.out.println("Introduzca el dinero (separe los decimales con una coma, por favor)");
                        saldoCliente += entrada.nextDouble();
                        cafetera.setSaldoCliente(saldoCliente);

                        System.out.println("saldoCliente " + cafetera.getSaldoCliente());

                        //decide si descafeinado o no
                        if (codigo >= 101 && codigo <= 104) {
                            do {
                                System.out.println("Lo quiere descafeinado \n1. SI\n2. NO");
                                descafeinadoSiNo = entrada.nextInt();
                            } while (descafeinadoSiNo < 1 || descafeinadoSiNo > 2);
                        }

                        //pregunta la cantidad de azucar y la resta del contenido
                        servirAzucar();

                        //Muestra el pedido del cliente....
                        System.out.println("................................................");
                        switch (codigo) {
                            case 101:
                                cafetera.setPrecio(0.8);

                                pedirMasDinero(saldoCliente);

                                if (descafeinadoSiNo == 1) {
                                    cafetera.restarCafeDescafeinado(codigo);
                                }
                                cafetera.servirCafe(cafe1, codigo);

                                mostrarInformacion(cafe1, descafeinadoSiNo);

                                break;
                            case 102:
                                cafetera.setPrecio(0.9);

                                pedirMasDinero(saldoCliente);
                                if (descafeinadoSiNo == 1) {
                                    cafetera.restarCafeDescafeinado(codigo);
                                }
                                cafetera.servirCafe(cafe2, codigo);
                                mostrarInformacion(cafe2, descafeinadoSiNo);

                                break;
                            case 103:
                                cafetera.setPrecio(1.10);

                                pedirMasDinero(saldoCliente);
                                if (descafeinadoSiNo == 1) {
                                    cafetera.restarCafeDescafeinado(codigo);
                                }
                                cafetera.servirCafe(cafe3, codigo);
                                mostrarInformacion(cafe3, descafeinadoSiNo);

                                break;
                            case 104:

                                cafetera.setPrecio(1);

                                pedirMasDinero(saldoCliente);
                                if (descafeinadoSiNo == 1) {
                                    cafetera.restarCafeDescafeinado(codigo);
                                }
                                cafetera.servirCafe(cafe4, codigo);
                                mostrarInformacion(cafe4, descafeinadoSiNo);

                                break;
                            case 200:
                                cafetera.setPrecio(1.4);

                                pedirMasDinero(saldoCliente);
                                cafetera.servirChocolate(Choco, codigo);
                                mostrarInformacion(Choco);

                                break;

                            case 300:
                                cafetera.setPrecio(0.5);

                                pedirMasDinero(saldoCliente);
                                cafetera.servirLeche(lecheFria, codigo);
                                mostrarInformacion(lecheFria);

                                break;
                            case 301:
                                cafetera.setPrecio(0.5);

                                pedirMasDinero(saldoCliente);
                                cafetera.servirLeche(lecheCaliente, codigo);
                                mostrarInformacion(lecheCaliente);
                                break;
                            default:
                                System.out.println("Esa opcion no se contempla");
                                opcion = 0;
                        }
                        System.out.printf("Su cambio es: %.2f %n", cafetera.devolverCambio());

                        cafetera.setSaldoCliente(0);
                        saldoCliente = 0;
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
//                                   
                                        break;
                                    case 2:
                                        System.out.println("Comprobando estado general");
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
                                        System.out.println("Introduzca la cantidad");
                                        cafetera.rellenarDeposito(opcionDeposito, llenarDeposito, entrada.nextDouble());

//-------------------------------------------------------------------------------------------------------------------------
                                        break;
                                    case 5:
                                        System.out.println("Saliendo de la administracion");

                                        break;
                                    default:
                                        System.out.println(
                                                "Esa opcion no se contempla");
                                }
                            } while (opcionAdmin != 5);
                        } //Fin del case 2
                        //--------------------------------------------

                        break;

                    default:
                        System.out.println("Esa opcion no se contempla");
                }
                System.out.println("................................................");

            } while (opcion < 1 || opcion > 2);

        } while (!salir.equalsIgnoreCase("Si"));
    }

}
