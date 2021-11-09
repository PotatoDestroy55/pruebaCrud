/**
 * Autor: Castillo Nadal Kevin Martin
 * Version 08/11/2021
 */


package Clases;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Clase que describe la conexión de base de datos
 * Realizada através de Xampp y SQL con Java.
 *
 */
public class Conection
{
        Connection cn;

        /**
         *  Método que describe la conexión de la base de datos importante.
         *
         * @return cn
         * */
        public Connection conexion(){
                try
                {
                        // Tratar de conectarse
                        Class.forName("com.mysql.jdbc.Driver");

                        cn = DriverManager.getConnection("jdbc:mysql://localhost/bd","root","");
                        System.out.printf("conectado\n");
                }
                catch (Exception e)
                {
                        //Por si no se da la conexión
                        System.err.println(e.getMessage());


                }
                return cn;
        }

}
