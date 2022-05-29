/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.modelo;

import sistema.db.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alber
 */
public class consultaPais extends conexion {

    public boolean buscar(pais tpais) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM pais WHERE pais_descripcion = ? ";
        try {
            ps = con.prepareStatement(sql);
            //ps.setInt(0, cont.getPais_codigo());
            ps.setString(1, tpais.getPais_descripcion());
            rs = ps.executeQuery();
            if (rs.next()) {
                tpais.setPais_codigo(Integer.parseInt(rs.getString("pais_codigo")));
                tpais.setPais_descripcion(rs.getString("pais_descripcion"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean registrar(pais tpais) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO pais (pais_codigo, pais_descripcion) VALUES(?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tpais.getPais_codigo());
            ps.setString(2, tpais.getPais_descripcion());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean modificar(pais tpais, String pais_descripcion) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE pais SET pais_descripcion='"+pais_descripcion+"' where pais_codigo = '"+tpais.getPais_codigo()+"';";
        try {
            ps = con.prepareStatement(sql);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean eliminar(pais tpais) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM pais WHERE pais_codigo = ? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tpais.getPais_codigo());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
