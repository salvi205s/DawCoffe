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

    private String username = "salva";
    private int password = 1234;

    public boolean identificacion(String usuario, int pass) {
        boolean login = false;

        if (this.username.equals(usuario) && this.password == pass) {
            login = true;
        }

        return login;
    }

    public String getUsername() {
        return username;
    }

    public int getPassword() {
        return password;
    }
    
    
}
