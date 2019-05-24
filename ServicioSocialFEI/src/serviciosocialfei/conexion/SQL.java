package serviciosocialfei.conexion;

import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

public class SQL {

  static Statement s;

  public static ResultSet query(String sQuery, Conexion con) throws SQLException {
    Connection conn = con.getConexionSQL();
    ResultSet rs = null;
    try {
      s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      rs = s.executeQuery(sQuery);
      System.out.println("Cosulta hecha");
      return rs;
    } catch (SQLException e) {
      System.err.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
    } 
    return null;
  }

  public static int update(String sentencia, Conexion con) throws SQLException {
    Connection conn = con.getConexionSQL();
    try {
      Statement s = conn.createStatement();
      return s.executeUpdate(sentencia);
    } catch (SQLException e) {
      System.err.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
    } finally {
      // conn.close();
    }
    return -1;  //-1 si hay error, 0 si OK
  }

  public static int lastID(String tabla, Conexion con) throws SQLException {
    Connection conn = con.getConexionSQL();
    try {
      Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet rs = s.executeQuery("SELECT LAST_INSERT_ID() FROM " + tabla);
      int valor = 0;
      if (rs != null && rs.next()) {
        valor = rs.getInt(1);
      }
      return valor;
    } catch (SQLException e) {
      System.err.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
    } finally {
      //conn.close();
    }
    return -1;  //-1 si hay error, 0 si OK

  }

  public static int maximoID(String campo, String tabla, Conexion con) throws SQLException {
    Connection conn = con.getConexionSQL();
    try {
      Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet rs = s.executeQuery("select max(" + campo + ") from " + tabla + ";");
      int valor = 0;
      if (rs != null && rs.next()) {
        valor = rs.getInt(1);
      }
      return valor;
    } catch (SQLException e) {
      System.out.println("ERROR: " + e.getMessage());
    } finally {
      //conn.close();
    }
    return -1;
  }

  public void close(Statement s) {
    try {
      s.close();
    } catch (SQLException e) {
      System.err.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
    }
  }

}
