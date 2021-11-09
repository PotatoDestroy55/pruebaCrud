package Frames;

import Clases.Conection;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal extends javax.swing.JFrame{

        public Principal(){

                this.setLocationRelativeTo(null);

                /*limpiar();
                mostrarTabla("");

                txtID.setEnabled(false);*/

                guardarButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                });
        }



        void limpiar(){
                txtID.setText("");
                txtNombre.setText("");
                txtApellidos.setText("");
                txtDireccion.setText("");
                txtTelefono.setText("");

        }

        void mostrarTabla(String valor){
                //
                DefaultTableModel modelo = new DefaultTableModel();

                modelo.addColumn("ID");
                modelo.addColumn("NOMBRE");
                modelo.addColumn("APELLIDOS");
                modelo.addColumn("DIRECCION");
                modelo.addColumn("TELEFONO");

                tabla.setModel(modelo);

                String sql = "SELECT * FROM empleados WHERE CONCAT (nombre, '', apellidos) LIKE '%"+valor+"%'";

                String datos[] = new String[5];

                Statement st;

                try{
                      //
                      st = cn.createStatement();

                      ResultSet rs = st.executeQuery(sql);

                      while (rs.next()){
                              datos[0] =  rs.getString(1);
                              datos[1] =  rs.getString(2);
                              datos[2] =  rs.getString(3);
                              datos[3] =  rs.getString(4);
                              datos[4] =  rs.getString(5);

                              modelo.addRow(datos);


                      }

                      tabla.setModel(modelo);


                }catch (SQLException e)
                {
                        System.err.println("Error en el llamado de la tabla");
                        JOptionPane.showMessageDialog(null,"Error en el llamado de la tabla");



                }
        }

        // Inicio de las variables de la forma.
        private JTextField txtID;
        private JTextField txtNombre;
        private JTextField txtApellidos;
        private JTable tabla;
        private JTextField txtDireccion;
        private JButton guardarButton;
        private JButton actualizarButton;
        private JButton cancelarButton;
        private JButton imprimirReporteButton;
        private JPanel Jpanel;
        private JLabel LabelRegistroEmpleados;
        private JPanel PanelRegistroEmpleados;
        private JTextField txtTelefono;
        // Final de las variables

        // Importar la conexion
        Conection con = new Conection();
        Connection cn = con.conexion();


}



