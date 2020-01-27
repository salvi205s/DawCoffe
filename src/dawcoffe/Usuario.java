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
public class Usuario {

    //variables que guardan, el userName y el password que seran final 
    private final String USER_NAME = "salva";
    private final int PASSWORD = 1234;

    //metodo para llevar a cabo una autenticacion, que recibira un nombre de usuario y una contraseña
    public boolean identificacion(String usuario, int pass) {
        boolean login = false;

//        si el usuario y la contraseña que reciben como parametro, son iguales, a los establecidos, la autenticacion sera positiva
        if (this.USER_NAME.equals(usuario) && this.PASSWORD == pass) {
            login = true;
        }

        return login;
    }

    //getters 
    public String getUSER_NAME() {
        return USER_NAME;
    }

    public int getPASSWORD() {
        return PASSWORD;
    }
    
    
}
