/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelo;

/**
 *
 * @author alber
 */
public class pais {

    private int pais_codigo;
    private String pais_descripcion;

    public int getPais_codigo() {
        return pais_codigo;
    }

    public void setPais_codigo(int pais_codigo) {
        this.pais_codigo = pais_codigo;
    }

    public String getPais_descripcion() {
        return pais_descripcion;
    }

    public void setPais_descripcion(String pais_descripcion) {
        this.pais_descripcion = pais_descripcion;
    }

    public void getPais_descripcion (String text) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
 
}
