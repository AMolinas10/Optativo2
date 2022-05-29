/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sistema.db.conexion;

/**
 *
 * @author admin
 */
public class consultaDepartamento extends conexion{

    public ArrayList BuscarPais(pais tpais) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        java.sql.Connection con = getConexion();
        //com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) getConexion();
        String sql = "SELECT * FROM pais";
        ArrayList<String> pais = new ArrayList();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String lsDescripcion = rs.getString("pais_descripcion");
                pais.add(lsDescripcion);
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {

            con.close();

        }
        return pais;
    }

    
     public boolean registrar (departamento dpto){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO departamento (dpto_codigo, dpto_descripcion, pais_codigo) VALUES(default,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,dpto.getDep_codigo()); ///// ojooooooo
            ps.setString(2, dpto.getDep_descripcion());
            ps.setInt(3, dpto.getPais_codigo());
            ps.execute();
            return true;
        }catch (SQLException e){
            System.err.println(e);
            return false;
        } finally {
            try{
                con.close();
            }catch (SQLException e){
                System.err.println(e);
            }

        }
        
        
    }
    
     
     public ResultSet ObtieneIdPais(String dpto){
         PreparedStatement ps = null;
         ResultSet rs = null;
         java.sql.Connection con = getConexion();
         String sql = "select pais_codigo from pais where pais_descripcion = ?";
         try {
             ps = con.prepareCall(sql);
             rs = ps.executeQuery();
             return rs;
         } catch (SQLException e) {
             System.err.println(e);
             return rs;
         
         }
     
    }
    
    
    
    public ArrayList ListaPais() {
        ArrayList<String> lista = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        java.sql.Connection con = getConexion();

        String sql = "SELECT * FROM pais";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String paq = rs.getString("pais_descripcion");
                lista.add(paq);
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return lista;
    }


}
