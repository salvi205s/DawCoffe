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

    private final String USER_NAME = "salva";
    private final int PASSWORD = 1234;

    public boolean identificacion(String usuario, int pass) {
        boolean login = false;

        if (this.USER_NAME.equals(usuario) && this.PASSWORD == pass) {
            login = true;
        }

        return login;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public int getPASSWORD() {
        return PASSWORD;
    }
    
    
}
