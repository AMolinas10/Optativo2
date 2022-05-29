/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import sistema.modelo.consultaPais;
import sistema.modelo.pais;
import sistema.vista.frmPais;

/**
 *
 * @author alber
 */
public class ctlPais implements ActionListener {

    private pais tpais;
    private consultaPais cPais;
    private frmPais frm;

    public ctlPais(pais tpais, consultaPais cPais, frmPais frm) {
        this.tpais = tpais;
        this.cPais = cPais;
        this.frm = frm;
        this.frm.btnInsertar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
    }

    public void deshabilitar_botones() {
        frm.btnBuscar.setEnabled(false);
    }

    public void validar_campos_codigo() {
        if ("".equals(frm.txtCodigo.getText())) {

            JOptionPane.showMessageDialog(null, "El campo no puede estar vacio");
            frm.txtCodigo.requestFocus();
        } else {
            frm.txtDescripcion.requestFocus();
        }
    }
    
     public void validar_campos_descripcion() {
        if ("".equals(frm.txtDescripcion.getText())) {

            JOptionPane.showMessageDialog(null, "El campo no puede estar vacio");
            frm.txtDescripcion.requestFocus();
        } else {
            frm.btnInsertar.requestFocus();
        }
    }

    public void iniciar() {
        // this.deshabilitar_botones();
        frm.setTitle("Alta de Pais");
        frm.setLocationRelativeTo(null);
        frm.txtCodigo.setVisible(true);
        frm.txtCodigo.setEnabled(false);
        frm.txtDescripcion.setVisible(true);
        frm.txtDescripcion.requestFocus();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnInsertar) {
            tpais.setPais_descripcion(frm.txtDescripcion.getText());

            if (cPais.registrar(tpais)) {
                JOptionPane.showMessageDialog(null, "Registrado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }

        if (e.getSource() == frm.btnModificar) {
            //cont.setdescripcion(frm.txtDescripcion.getText());
            if (cPais.modificar(tpais, frm.txtDescripcion.getText())) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }

        if (e.getSource() == frm.btnEliminar) {
            tpais.setPais_descripcion(frm.txtDescripcion.getText());

            if (cPais.eliminar(tpais)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }

        if (e.getSource() == frm.btnBuscar) {
           //this.validar_campos_descripcion();
            tpais.setPais_descripcion(frm.txtDescripcion.getText()); 

            if (cPais.buscar(tpais)) {
                this.tpais.setPais_descripcion(frm.txtDescripcion.getText());
                //frm.txtDescripcion.setText(cont.getDescripcion());
                JOptionPane.showMessageDialog(null, "Registro Encontrado");
                limpiar();
                frm.txtDescripcion.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
        }
    }

    public void limpiar() {
        frm.txtDescripcion.setText(null);
    }

}
