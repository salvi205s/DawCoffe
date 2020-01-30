/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dawcoffe;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Salva
 */
public class MenuInterfaz {

    //necesitaremos el objeto Scanner, asi que lo importamos
    private Scanner entrada = new Scanner(System.in);

    //creamos el objeto cafetera, ya que lo recibira el menu, como parametro
    private Cafetera cafetera;

    //necesitaremos estas variables en varios metodos, asi que las creamos en la clase, fuera de los metodos
    private int cantidadAzucar = 0;
    private int edulcorante = 0;
    private boolean errorMonedas;
    private boolean errorNumeros;

    //constructor que recibe una cafetera
    public MenuInterfaz(Cafetera cafetera) {
        this.cafetera = cafetera;
    }

//metodo que pide mas monedas si no llega a la cantidad del articulo elegido
    private void pedirMasDinero(double saldoCliente) {

        //si no ha introducido el precio minimo para el articulo, avisara del saldo insuficiente
        //lo pedira hasta que comprobar precio sea true(hasta que el dinero introducido sea mayor o igual, que el precio del articulo)
        do {
            //Controlamos que si el usuario se equivoca, introduciendo los datos, el programa no se corte
            try {
                while (!cafetera.comprobarPrecio()) {
                    System.out.println("Saldo insuficiente " + cafetera.getSaldoCliente());
                    //introduce el dinero
                    System.out.println("Introduzca mas monedas");

                    System.out.println("Su saldo es: " + cafetera.getSaldoCliente());
                    saldoCliente += entrada.nextDouble();
                    cafetera.setSaldoCliente(saldoCliente);

                    System.out.println("Su saldo es: " + cafetera.getSaldoCliente());
                    errorMonedas = false;
                }

            } catch (InputMismatchException ime) {
                System.out.println("Introduzca numeros, y separe los decimales con una coma, por favor");
                entrada.nextLine();
                errorMonedas = true;
            }
        } while (errorMonedas);

    }

    //metodo para elegir el edulcorante
    private void elegirEdulcorante() {

//      pregunta que edulcorante quiere
        do {
            //Controlamos que si el usuario se equivoca, introduciendo los datos, el programa no se corte
            try {

                do {
                    System.out.println("Que edulcorante quiere \n1. azucar \n2. sacarina");
                    edulcorante = entrada.nextInt();
                } while (edulcorante < 1 || edulcorante > 2);

                errorNumeros = false;

            } catch (InputMismatchException ime) {
                System.out.println("Introduzca numeros, por favor");
                System.out.println("");
                entrada.nextLine();
                errorNumeros = true;

            }
        } while (errorNumeros);

        do {
            try {

                switch (edulcorante) {
                    case 1:

                        do {
                            //pregunta la cantidad de azucar y la resta del contenido
                            System.out.println("Cuanta azucar quiere");
                            System.out.println("1. ninguna");
                            System.out.println("2. poca");
                            System.out.println("3. mucha");
                            cantidadAzucar = entrada.nextInt();
                        } while (cantidadAzucar < 1 || cantidadAzucar > 3);

                        //la resta del deposito
                        cafetera.restarAzucar(cantidadAzucar);

//              pone la eleccion a 1 que es azucar
                        edulcorante = 1;
                        break;
                    case 2:
                        //si elige sacarina, la resta, y pone la eleccion a 2
                        cafetera.restarSacarina();
                        edulcorante = 2;
                        break;
                    default:
                        System.out.println("Esa opcion no se contempla");
                }
                errorNumeros = false;
            } catch (InputMismatchException ime) {
                System.out.println("Introduzca numeros, por favor");
                errorNumeros = true;
                entrada.nextLine();

            }
        } while (errorNumeros);

    }

    //metodo para mostrar la informacion final, que recibe como parametro la eleccion del usuario, ya que la informacion mostrada dependera de la eleccion
    private void mostrarInformacion(String menu) {
        //iniciamos la variable azucar a null
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

        //muestra el menu, y el edulcorante elegido
        System.out.println("Ha elegido " + menu);
        if (edulcorante == 1) {
            System.out.println("Con " + Azucar + " azucar");

        } else if (edulcorante == 2) {
            System.out.println("Con sacarina ");

        }

    }

    //metodo que llama a los metodos necesarios para servir un cafe
    private void servirCafe(double precio, double saldoCliente, int codigo, String tipoCafe) {
        //establecemos el precio del articulo que lo recibe por parametro
        cafetera.setPrecio(precio);

        //metodo para comprobar que el dinero introducido sea suficiente
        pedirMasDinero(saldoCliente);

        //restamos los ingredientes del cafe
        cafetera.restarCafe(codigo);

        //mostramos la informacion
        mostrarInformacion(tipoCafe);

    }

    //metodo que llama a los metodos necesarios para servir un productos que no son cafe
    private void servirOtros(double precio, double saldoCliente, int codigo, String producto) {
        //establecemos el precio del articulo que lo recibe por parametro
        cafetera.setPrecio(precio);

        //metodo para comprobar que el dinero introducido sea suficiente
        pedirMasDinero(saldoCliente);

        //dependiendo del codigo, servira una cosa u otra
        switch (codigo) {
            case 200:
                cafetera.servirChocolate();

                break;

            case 300:
                cafetera.servirLeche();

                break;

            case 301:
                cafetera.servirLeche();

                break;
        }

        //mostrara la informacion dependiendo del producto elegido
        mostrarInformacion(producto);
    }

    //menu de administracion, que nos da a elegir, entre varias opciones del menu de administracion
    private void menuAdmin() {
        System.out.println("................................................");

        System.out.println("1. Comprobar depósitos");
        System.out.println("2. Comprobar estado general");
        System.out.println("3. Consultar saldo de ventas realizadas.");
        System.out.println("4. Rellenar depositos");
        System.out.println("5. salir administracion ");
    }

    //metodo para elegir, que deposito queremos rellenar
    private void elegirDepositoArellenar() {
        System.out.println("1. Café");
        System.out.println("2. cafeDescafeinado");
        System.out.println("3. azucar");
        System.out.println("4. chocolate");
        System.out.println("5. agua");
        System.out.println("6. leche");
        System.out.println("7. sacarina");
        System.out.println("8. salir");
    }

    //metodo para ver el estado general de los depositos
    private void estadoGeneral() {
        System.out.println(cafetera.getCafe());
        System.out.println(cafetera.getCafeDescafeinado());
        System.out.println(cafetera.getAzucar());
        System.out.println(cafetera.getChocolate());
        System.out.println(cafetera.getAgua());
        System.out.println(cafetera.getLeche());
        System.out.println(cafetera.getSacarina());
    }

    //metodo para rellenar los depositos
    private void rellenarDepositos() {
        //guarda el deposito a rellenar
        int opcionDeposito = 0;
        //guarda la opcion de rellenar completamente o parcial
        int opcioRellenar = 0;

        System.out.println("Que deposito desea rellenar");
        do {
            //Controlamos que si el usuario se equivoca, introduciendo los datos, el programa no se corte
            try {
                do {
//controlamos que pida al admin la opcion del deposito a rellenar, hasta que meta una opcion valida
                    elegirDepositoArellenar();
                    opcionDeposito = entrada.nextInt();
                } while (opcionDeposito < 1 || opcionDeposito > 8);

                errorNumeros = false;

            } catch (InputMismatchException ime) {
                System.out.println("Introduce numeros");
                errorNumeros = true;
                entrada.nextLine();
            }
        } while (errorNumeros);
        do {
            try {
                do {
                    //si la opcion es 8, salimos del bucle
                    if (opcionDeposito == 8) {
                        break;
                    }
                    //evaluamos que pida como quiere rellenar el deposito, hasta que meta una opcion valida

                    System.out.println("¿Quiere rellenar el deposito \n1. completamente \n2. parcial");
                    opcioRellenar = entrada.nextInt();

                } while (opcioRellenar < 1 || opcioRellenar > 2);
                errorNumeros = false;

            } catch (InputMismatchException ime) {
                System.out.println("Introduce numeros");
                errorNumeros = true;
                entrada.nextLine();
            }
        } while (errorNumeros);
        //procedemos a las acciones
        switch (opcioRellenar) {
            //si es cero, es porque el admin a elegido la opcion 8(salir)
            case 0:
                System.out.println("Saliendo...");
                break;

            //si es 1, rellena el deposito completo
            case 1:
                cafetera.rellenarDepositoCompleto(opcionDeposito);
                break;

            //si es 2 pide la cantidad para rellenar
            case 2:
                do {
                    //Controlamos que si el usuario se equivoca, introduciendo los datos, el programa no se corte
                    try {
                        System.out.println("Introduzca la cantidad");
                        cafetera.rellenarDepositoParcialmente(opcionDeposito, entrada.nextDouble());
                        errorNumeros = false;

                    } catch (InputMismatchException ime) {
                        System.out.println("Introduce numeros");
                        errorNumeros = true;
                        entrada.nextLine();
                    }
                } while (errorNumeros);

                break;

            // sino informa de que esa opcion no existe
            default:
                System.out.println("Esa opcion no se contempla");

        }

    }

    //metodo menu
    public void menu() {
        //variable que guarda el articulo elegido por el usuario
        int codigo = 0;
        //variable que guarda la elecion del menu principal, (comprar o administar)
        int opcion = 0;

        //variable que guarda, si descafeinado o no
        int descafeinadoSiNo = 0;

        //guardamos las monedas que introduce el cliente
        double saldoCliente = 0;
//        double cambio = 0;

        //guarda el precio del articulo
        double precio;
        //guarda el String menu
        String menu;
        //guarda la condicion para salir del programa(Que es nunca, ya que no queremos que termine)
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
                //pedimos al usuario que elija que quiere hacer
                do {
                    //Controlamos que si el usuario se equivoca, introduciendo los datos, el programa no se corte
                    try {
                        System.out.println("1. Venta de productos");
                        System.out.println("2. Administración de la cafetera");
                        opcion = entrada.nextInt();

                        errorNumeros = false;
                    } catch (InputMismatchException ime) {
                        System.out.println("Introduzca numeros, por favor");
                        errorNumeros = true;
                        entrada.nextLine();

                    }
                } while (errorNumeros);

                //si quiere comprar un producto.....
                switch (opcion) {
                    case 1:
                        //muestra el menu
                        do {
                            //Controlamos que si el usuario se equivoca, introduciendo los datos, el programa no se corte
                            try {
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

                                errorNumeros = false;
                            } catch (InputMismatchException ime) {
                                System.out.println("Introduzca numeros, por favor");
                                System.out.println("");
                                entrada.nextLine();
                                errorNumeros = true;

                            }

                            if ((codigo < 101 || codigo > 301)) {
                                errorNumeros = true;
                                System.out.println("Por favor, introduzca un codigo valido\n");
                            }

                        } while (errorNumeros);

                        //si hay falta de existencias, informamos al usuario, y le decimos que deposito es
                        if (cafetera.informarFaltaExistencias()) {
                            System.out.println("Lo sentimos pero no podemos, servirle");
                            cafetera.reserva();
                            break;
                        }

                        //pedimos al usuario que introduzca las monedas, las sumamoms en la variable saldoCliente, y se las pasamos al setSaldoCliente
                        do {
                            //Controlamos que si el usuario se equivoca, introduciendo los datos, el programa no se corte
                            try {
                                System.out.println("Introduzca el dinero (separe los decimales con una coma, por favor)");
                                saldoCliente += entrada.nextDouble();
                                cafetera.setSaldoCliente(saldoCliente);

                                //informamos de la cantidad introducida
                                System.out.println("su saldo es " + cafetera.getSaldoCliente());
                                errorMonedas = false;
                            } catch (InputMismatchException ime) {
                                System.out.println("Introduzca numero, y separe los decimales con una coma, por favor");
                                entrada.nextLine();
                                errorMonedas = true;

                            }

                        } while (errorMonedas);

//                        System.out.println("Introduzca el dinero (separe los decimales con una coma, por favor)");
//                        saldoCliente += entrada.nextDouble();
//                        cafetera.setSaldoCliente(saldoCliente);
//
//                        //informamos de la cantidad introducida
//                        System.out.println("su saldo es " + cafetera.getSaldoCliente());
                        //llama al metodo elegirEdulcorante
                        elegirEdulcorante();

                        //servimos lo que haya pedido el cliente
                        System.out.println("................................................");
                        switch (codigo) {
                            case 101:
                                //llamamos al metodo servirCafe, que recibe los parametros necesarios para ello
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
                                //a partir de aqui ya no sirve cafe, por lo que llamamos al metodo servirOtros, que hace casi lo mismo
                                servirOtros(1.4, saldoCliente, codigo, Choco);
                                break;

                            case 300:
                                servirOtros(0.5, saldoCliente, codigo, lecheFria);
                                break;

                            case 301:
                                servirOtros(0.5, saldoCliente, codigo, lecheCaliente);
                                break;

                            default:
                                //si el codigo no es ninguno de los anteriores informamos que esa opcion no existe
                                System.out.println("Esa opcion no se contempla");
                                //y ponemos la opcion del menu principal a cero, para volver a el(comprar o administar)
                                opcion = 0;
                        }
//                        informamos del cambio a devolver
                        System.out.printf("Su cambio es: %.2f %n", cafetera.devolverCambio());

                        //ponemos las monedas introducidas por el usuario a cero
                        cafetera.setSaldoCliente(0);
                        saldoCliente = 0;
                        //y nos despedimos
                        System.out.println("Vuelva pronto. \nQue tenga un buen dia");

                        //Fin del case 1
//-------------------------------------------------------------------------------------------------------------------------------
                        break;
                    //si quiere administrar la cafetera.....
                    case 2:
                        //creamos el objeto Usuario, para autenticarnos
                        Usuario user = new Usuario();
                        //guarda el usuario introducido
                        String usuario;
                        //guarda la contraseña introducida
                        int pass = 0,
                        //guarda los intentos, de autenticacion     
                         cont = 0;
                        //guarda la opcion del administrador, sobre lo que quire hacer, en el menu de administracion
                        int opcionAdmin = 0;

                        do {

                            //pedimos el usuario y la contraseña
                            System.out.println("Introduce usuario");
//                            usuario = entrada.next();
                            usuario = "salva";

                            do {
                                //Controlamos que si el usuario se equivoca, introduciendo los datos, el programa no se corte
                                try {
                                    System.out.println("Introduce contraseña en numeros");
//                                    pass = entrada.nextInt();
                                    pass = 1234;

                                    errorNumeros = false;
                                } catch (InputMismatchException ime) {
                                    errorNumeros = true;
                                    entrada.nextLine();
                                }
                            } while (errorNumeros);

                            //y sumamos un intento
                            cont++;

                            //se pedira usuario y contraseña hasta que la autenticacion sea positiva o los intentos sean mayor de 3
                        } while (user.identificacion(usuario, pass) == false && cont < 3);

                        //si los intentos son mas de 3, informamos de que la autenticacion no ha sido posible
                        if (cont >= 3) {
                            System.out.println("Lo sentimos, pero el login no se ha podido realizan con exito");
                        } else {
                            //si los intentos son menor o igual de 3, informamos de que ha sido correcto
                            System.out.println("Correcto");
                            do {
                                //mostramos el menu de administracion y guardamos la opcion
                                do {
                                    //Controlamos que si el usuario se equivoca, introduciendo los datos, el programa no se corte
                                    try {
                                        menuAdmin();
                                        opcionAdmin = entrada.nextInt();

                                        errorNumeros = false;
                                    } catch (InputMismatchException ime) {
                                        System.out.println("Introduce un numero valido");

                                        errorNumeros = true;
                                        entrada.nextLine();
                                    }
                                } while (errorNumeros);

                                //dependiendo de la opcion del admin, llevamos a cabo la opcion
                                switch (opcionAdmin) {
                                    //Comprobar depósitos, que verifica cada indicador de cada depósito, informando de aquellos depósitos que deben ser rellenados.
                                    case 1:
                                        if (!cafetera.reserva()) {
                                            System.out.println("No hay depositos en reserva");

                                        }

                                        break;
                                    //comprobar el estado general de los depositos, que informa del estado de los depositos asi como del usuario y contraseña
                                    case 2:
                                        System.out.println("Comprobando estado general");
                                        System.out.println("");
                                        estadoGeneral();
                                        System.out.println("Usuario: " + user.getUSER_NAME());
                                        System.out.println("Contraseña: " + user.getPASSWORD());
                                        break;

                                    //Consultar saldo de ventas realizadas.
                                    case 3:
                                        System.out.println("Consultando saldo de ventas realizadas");
                                        System.out.println("El numero de ventas es: " + cafetera.getNumVentas() + "\nEl saldo acumulado es: " + cafetera.getSaldoAcumulado());
                                        break;

//Rellenar depósitos. Se pregunta el depósito a rellenar y luego se dan dos opciones: rellenar completo o indicar la cantidad de producto a reponer.
                                    case 4:
                                        rellenarDepositos();
                                        break;

                                    //informamos de que estamos saliendo de el menu de administracion
                                    case 5:
                                        System.out.println("Saliendo de la administracion");
                                        break;

                                    //informamos de que la opcion elegida por el admin, no existe
                                    default:
                                        System.out.println("Esa opcion no se contempla");
                                }

                                //todo esto se repetira, mientras la opcion elegida, no sea 5(salir)
                            } while (opcionAdmin != 5);
                        } //Fin del case 2
                        //--------------------------------------------

                        break;

                    //si la opcion del usuario, en el menu principal(comprar o administrar) no es 1 o 2, informamos de que esa opcion no existe
                    default:
                        System.out.println("Esa opcion no se contempla");
                }
                System.out.println("................................................");

                //y mostrara el menu principal mientras la opcion elegida, no sea 1 o 2
            } while (opcion < 1 || opcion > 2);

            //como el programa tiene que estar siempre funcionando, ponemos una condicion que no se va a actualizar nunca
        } while (!salir.equalsIgnoreCase("Si"));
    }

}
