/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelo;

/**
 *
 * @author admin
 */
public class departamento {
    private int dep_codigo; // acá se crean las variables de acuerdo a la tabla fisica de la BD, respetando tipos de datos (int, string, etc)
    private String dep_descripcion;
    private int pais_codigo;
    private String pais_descripcion;

    public String getPais_descripcion() {
        return pais_descripcion;
    }

    public void setPais_descripcion(String pais_descripcion) {
        this.pais_descripcion = pais_descripcion;
    }
    
    public int getDep_codigo() {
        return dep_codigo;
    }

    public void setDep_codigo(int dep_codigo) {
        this.dep_codigo = dep_codigo;
    }

    public String getDep_descripcion() {
        return dep_descripcion;
    }

    public void setDep_descripcion(String dep_descripcion) {
        this.dep_descripcion = dep_descripcion;
    }

    public int getPais_codigo() {
        return pais_codigo;
    }

    public void setPais_codigo(int pais_codigo) {
        this.pais_codigo = pais_codigo;
    }
    
}
