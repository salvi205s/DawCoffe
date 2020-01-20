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
    private int edulcorante = 0;

    public MenuInterfaz(Cafetera cafetera) {
        this.cafetera = cafetera;
    }

//muestra informacion si el producto elegido no es cafe
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

    private void elegirEdulcorante() {
//pregunta la cantidad de azucar y la resta del contenido
        System.out.println("Que edulcorante quiere \n1. azucar \n2. sacarina");
        edulcorante = entrada.nextInt();

        switch (edulcorante) {
            case 1:
                System.out.println("Cuanta azucar quiere");
                System.out.println("1. ninguna");
                System.out.println("2. poca");
                System.out.println("3. mucha");
                cantidadAzucar = entrada.nextInt();

                cafetera.restarAzucar(cantidadAzucar);
                edulcorante = 1;
                break;
            case 2:
                cafetera.restarSacarina();
                edulcorante = 2;
                break;
            default:
                System.out.println("Esa opcion no se contempla");
        }

    }

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
        if (edulcorante == 1) {
            System.out.println("Con " + Azucar + " azucar");

        }
        System.out.println("Con sacarina ");

    }

    public void servirCafe(double precio, double saldoCliente, int codigo, String tipoCafe) {
        cafetera.setPrecio(precio);

        pedirMasDinero(saldoCliente);

//        cafetera.servirCafe(tipoCafe, codigo);
        cafetera.restarCafe(codigo);

        mostrarInformacion(tipoCafe);

    }

    public void servirOtros(double precio, double saldoCliente, int codigo, String producto) {
        cafetera.setPrecio(precio);

        //revisar, revisar, revisar, revisar, revisar, revisar, revisar, revisar, revisar, revisar, revisar, revisar, revisar, revisar, revisar, revisar, revisar, revisar, revisar, revisar, revisar, revisar, 
        pedirMasDinero(saldoCliente);

        switch (codigo) {
            case 200:
                cafetera.servirChocolate(producto, codigo);

                break;

            case 300:
                cafetera.restarLeche(180);
                break;

            case 301:
                cafetera.restarLeche(180);

                break;
        }

        mostrarInformacion(producto);
    }

    public void menuAdmin() {
        System.out.println("................................................");

        System.out.println("1. Comprobar depósitos");
        System.out.println("2. Comprobar estado general");
        System.out.println("3. Consultar saldo de ventas realizadas.");
        System.out.println("4. Rellenar depositos");
        System.out.println("5. salir administracion ");
    }

    public void elegirDepositoArellenar() {
        System.out.println("1. Café");
        System.out.println("2. cafeDescafeinado");
        System.out.println("3. azucar");
        System.out.println("4. chocolate");
        System.out.println("5. agua");
        System.out.println("6. leche");
        System.out.println("7. salir");
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
        String cafe5 = "Café solo descafeinado (0.80€), codigo 105";
        String cafe6 = "Café solo largo descafeinado(0.90€), codigo 106";
        String cafe7 = "Café con leche descafeinado(1.10€), codigo 107";
        String cafe8 = "Café cortado descafeinado(1.00€), codigo 108";
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
                        System.out.println(cafe5);
                        System.out.println(cafe6);
                        System.out.println(cafe7);
                        System.out.println(cafe8);
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

                        System.out.println("su saldo es " + cafetera.getSaldoCliente());

                        //pregunta la cantidad de azucar y la resta del contenido
                        elegirEdulcorante();

                        //Muestra el pedido del cliente....
                        System.out.println("................................................");
                        switch (codigo) {
                            case 101:
                                servirCafe(0.8, saldoCliente, codigo, cafe1);
                                break;

                            case 102:

                                servirCafe(0.9, saldoCliente, codigo, cafe2);
                                break;

                            case 103:
                                servirCafe(1.10, saldoCliente, codigo, cafe3);
                                break;

                            case 104:
                                servirCafe(1, saldoCliente, codigo, cafe4);
                                break;
                            case 105:
                                servirCafe(0.8, saldoCliente, codigo, cafe5);
                                break;

                            case 106:

                                servirCafe(0.9, saldoCliente, codigo, cafe6);
                                break;

                            case 107:
                                servirCafe(1.10, saldoCliente, codigo, cafe7);
                                break;

                            case 108:
                                servirCafe(1, saldoCliente, codigo, cafe8);
                                break;

                            case 200:
                                servirOtros(1.4, saldoCliente, codigo, Choco);
                                break;

                            case 300:
                                servirOtros(0.5, saldoCliente, codigo, lecheFria);
                                break;

                            case 301:
                                servirOtros(0.5, saldoCliente, codigo, lecheCaliente);
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
//                        int opcionDeposito;
//                        int opcioRellenar;

                        do {
                            System.out.println("Introduce usuario");
//                            usuario = entrada.next();
                            usuario = "salva";
                            System.out.println("Introduce contraseña en numeros");
//                            pass = entrada.nextInt();
                            pass = 1234;
                            cont++;

                        } while (user.identificacion(usuario, pass) == false && cont < 3);

                        if (cont >= 3) {
                            System.out.println("Lo sentimos, pero el login no se ha podido realizan con exito");
                        } else {
                            System.out.println("Correcto");
                            do {
                                menuAdmin();

                                opcionAdmin = entrada.nextInt();

                                switch (opcionAdmin) {
                                    //Comprobar depósitos, que verifica cada indicador de cada depósito, informando de aquellos depósitos que deben ser rellenados.

                                    case 1:
                                        reserva();
//                                   
                                        break;
                                    case 2:
                                        System.out.println("Comprobando estado general");
                                        System.out.println("");
                                        estadoGeneral();
                                        System.out.println("Usuario: " + user.getUSER_NAME());
                                        System.out.println("Contraseña: " + user.getPASSWORD());

                                        break;
                                    case 3:
                                        //Consultar saldo de ventas realizadas.
                                        System.out.println("Consultando saldo de ventas realizadas");
                                        System.out.println("El numero de ventas es: " + cafetera.getNumVentas() + "\nEl saldo acumulado es: " + cafetera.getSaldoAcumulado());

                                        break;
                                    case 4:

//Rellenar depósitos. Se pregunta el depósito a rellenar y luego se dan dos opciones: rellenar completo o indicar la cantidad de producto a reponer.
                                        rellenarDepositos();
                                        break;
                                    case 5:
                                        System.out.println("Saliendo de la administracion");

                                        break;
                                    default:
                                        System.out.println("Esa opcion no se contempla");
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

    public void estadoGeneral() {
        System.out.println(cafetera.getCafe());
        System.out.println(cafetera.getCafeDescafeinado());
        System.out.println(cafetera.getAzucar());
        System.out.println(cafetera.getChocolate());
        System.out.println(cafetera.getAgua());
        System.out.println(cafetera.getLeche());
        System.out.println(cafetera.getSacarina());
    }

    public void rellenarDepositos() {
        int opcionDeposito;
        int opcioRellenar = 0;

        System.out.println("Que deposito desea rellenar");
        do {

            elegirDepositoArellenar();
            opcionDeposito = entrada.nextInt();

        } while (opcionDeposito != 7);

        do {
            if (opcionDeposito == 7) {
                break;
            }
            System.out.println("¿Quiere rellenar el deposito \n1. completamente \n2. parcial");
            opcioRellenar = entrada.nextInt();
        } while (opcioRellenar < 1 || opcioRellenar > 2);
        //-------------------------------------------------------------------------------------------------------------------------
        switch (opcioRellenar) {
            case 0:
                System.out.println("Saliendo...");
                break;
            case 1:
                cafetera.rellenarDepositoCompleto(opcionDeposito);

                break;
            case 2:
                System.out.println("Introduzca la cantidad");
                cafetera.rellenarDepositoParcialmente(opcionDeposito, entrada.nextDouble());
                break;
            default:
                System.out.println("Esa opcion no se contempla");

        }

    }

    //Comprobar depósitos, que verifica cada indicador de cada depósito, informando de aquellos depósitos que deben ser rellenados.
    public void reserva() {
        if (cafetera.getCafe().isReserva()) {
            System.out.println(cafetera.getCafe());

        } else if (cafetera.getCafeDescafeinado().isReserva()) {
            System.out.println(cafetera.getCafeDescafeinado());

        } else if (cafetera.getAzucar().isReserva()) {
            System.out.println(cafetera.getAzucar());

        } else if (cafetera.getChocolate().isReserva()) {
            System.out.println(cafetera.getChocolate());

        } else if (cafetera.getAgua().isReserva()) {
            System.out.println(cafetera.getAgua());

        } else if (cafetera.getLeche().isReserva()) {
            System.out.println(cafetera.getLeche());

        } else if (cafetera.getSacarina().isReserva()) {
            System.out.println(cafetera.getSacarina());

        } else {
            System.out.println("No hay depositos en reserva");

        }
    }
}
