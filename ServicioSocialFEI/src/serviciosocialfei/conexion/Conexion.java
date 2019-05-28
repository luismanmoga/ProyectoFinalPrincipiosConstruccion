/**
 * Programador: Angel Eduardo Martinez Leo Lim
 * Descripción: Permite la conexion a una base de datos MySQL
 * Fecha: 16/05/2019
 * Última modificacion: 17/05/2019
 */
package serviciosocialfei.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private Connection conector;
    private String host;
    private String baseDatos;
    private String contrasena;
    private String usuario;

    
    public void iniciarConexion() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conector = DriverManager.getConnection("jdbc:mysql://" + host + "/" + baseDatos
                    + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false"
                    + "&serverTimezone=UTC", usuario, contrasena);
            System.out.println("Conexion con base de datos establecida");
        } catch (ClassNotFoundException ex) {
            System.out.println("Conector de base de datos no encontrado");
        }
    }

    public void terminarConexion() {
        try {
            this.conector.close();
            System.out.println("Conexion a BD cerrada");
        } catch (SQLException ex) {
            System.out.println("Error al desconextar de la base de datos");
        }
    }

    public Connection getConexionSQL() {
        return this.conector;
    }

    public Conexion(String host, String baseDatos, String usuario, String contrasena) {
        this.host = host;
        this.baseDatos = baseDatos;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
}
