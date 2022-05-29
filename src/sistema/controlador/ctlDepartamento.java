/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controlador;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistema.modelo.consultaDepartamento;
import sistema.modelo.departamento;
import sistema.vista.frmDepartamento;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Iterator;
import javax.swing.JOptionPane;
import sistema.modelo.pais;

/**
 *
 * @author admin
 */
public class ctlDepartamento implements ActionListener {

    private departamento dpto;
    private consultaDepartamento contD;
    private frmDepartamento frmD;

    public ctlDepartamento(departamento dpto, consultaDepartamento contD, frmDepartamento frmD) {
        this.dpto = dpto;
        this.contD = contD;
        this.frmD = frmD;

        CargarPais();

        this.frmD.btnInsertar.addActionListener(this);
        this.frmD.btnModificar.addActionListener(this);
        this.frmD.btnEliminar.addActionListener(this);
        this.frmD.btnBuscar.addActionListener(this);
    }

    public void iniciar() {
        // this.deshabilitar_botones();
        frmD.setTitle("Mantenimiento de Departamentos");
        frmD.setLocationRelativeTo(null);
//        frm.txtCodigo.setVisible(true);
//        frm.txtCodigo.setEnabled(false);
//        frm.txtDescripcion.setVisible(true);
//        frm.txtDescripcion.requestFocus();

    }

    public void CargarPais() {
        pais tpais = new pais();
        ArrayList paises = null;
        try {
            paises = contD.BuscarPais(tpais);
        } catch (SQLException ex) {
            Logger.getLogger(ctlDepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator<String> i = paises.iterator();
        while (i.hasNext()) {
            frmD.cboPais.addItem(i.next());
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmD.btnInsertar) {
            departamento dpto = new departamento();
            dpto.setPais_descripcion(frmD.cboPais.getSelectedItem().toString());
            dpto.setDep_descripcion(frmD.txtDescripcion.getText());
            ResultSet rs = contD.ObtieneIdPais(dpto);

            try {
                while (rs.next()) {
                    dpto.setPais_codigo(rs.getInt("pais_codigo"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ctlDepartamento.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (contD.registrar(dpto)) {
                JOptionPane.showMessageDialog(null, "Registrado");
                //limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                //limpiar();
            }
        }

//        if (e.getSource() == frmD.btnModificar) {
//            //cont.setdescripcion(frm.txtDescripcion.getText());
//            if (cPais.modificar(tpais, frm.txtDescripcion.getText())) {
//                JOptionPane.showMessageDialog(null, "Registro Modificado");
//                limpiar();
//            } else {
//                JOptionPane.showMessageDialog(null, "Error al Modificar");
//                limpiar();
//            }
//        }
//
//        if (e.getSource() == frmD.btnEliminar) {
//            tpais.setPais_descripcion(frm.txtDescripcion.getText());
//
//            if (cPais.eliminar(tpais)) {
//                JOptionPane.showMessageDialog(null, "Registro Eliminado");
//                limpiar();
//            } else {
//                JOptionPane.showMessageDialog(null, "Error al Eliminar");
//                limpiar();
//            }
//        }
//
//        if (e.getSource() == frmD.btnBuscar) {
//           //this.validar_campos_descripcion();
//            tpais.setPais_descripcion(frm.txtDescripcion.getText()); 
//
//            if (cPais.buscar(tpais)) {
//                this.tpais.setPais_descripcion(frm.txtDescripcion.getText());
//                //frm.txtDescripcion.setText(cont.getDescripcion());
//                JOptionPane.showMessageDialog(null, "Registro Encontrado");
//                limpiar();
//                frm.txtDescripcion.requestFocus();
//            } else {
//                JOptionPane.showMessageDialog(null, "No se encontro registro");
//                limpiar();
//            }
//        }
    }

}
