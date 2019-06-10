/**
 * @author: Angel Eduardo Martínez Leo Lim
 * @date: 05/31/2019
 */
package serviciosocialfei.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import serviciosocialfei.conexion.Conexion;
import serviciosocialfei.conexion.SQL;

import serviciosocialfei.modelo.Alumno;

public class AlumnoDaoSql implements AlumnoDAO {

    Conexion conexion;
    
    public AlumnoDaoSql() {
        conexion = new Conexion("localhost", "serviciosocial", "proyectoSS", "12345");
    }

    @Override
    public void registrarAlumno(Alumno alumno) throws ExcepcionSistema {
        try {
            String consulta;
            int resultadoConsulta;
            conexion.iniciarConexion();
            consulta = "insert into alumno(matricula,apellidoPaterno,apellidoMaterno, "
                    + "nombres, direccion, correo, telefono, promedio, "
                    + "programaEducativo, estado) values(1,2,3,4,5,6,7,8,9,1)";
            consulta = consulta.replaceAll("1", "\"" + alumno.getMatricula() + "\"");
            consulta = consulta.replaceAll("2", "\"" + alumno.getApellidoPaterno() + "\"");
            consulta = consulta.replaceAll("3", "\"" + alumno.getApellidoMaterno() + "\"");
            consulta = consulta.replaceAll("4", "\"" + alumno.getNombres() + "\"");
            consulta = consulta.replaceAll("5", "\"" + alumno.getDireccion() + "\"");
            consulta = consulta.replaceAll("6", "\"" + alumno.getCorreo() + "\"");
            consulta = consulta.replaceAll("7", "\"" + alumno.getTelefono() + "\"");
            consulta = consulta.replaceAll("8", "\"" + alumno.getPromedio() + "\"");
            consulta = consulta.replaceAll("9", "\"" + alumno.getProgramaEducativo() + "\"");
            consulta = consulta.replaceAll("10", "\"" + alumno.getEstado() + "\"");

            resultadoConsulta = SQL.update(consulta, conexion);
            
            conexion.terminarConexion();
        } catch (SQLException ex) {
            throw new ExcepcionSistema("Error a conectarse a base de datos", 1);
        }
    }

    @Override
    public void eliminarAlumno(Alumno alumno) throws ExcepcionSistema {
        try {
            String consulta;
            int resultadoConsulta;
            consulta = "delete from alumno where matricula = \"" + alumno.getMatricula() + "\"";

            conexion.iniciarConexion();
            resultadoConsulta = SQL.update(consulta, conexion);
            conexion.terminarConexion();
        } catch (SQLException ex) {
            throw new ExcepcionSistema("Error a conectarse a base de datos", 1);
        }
    }

    @Override
    public void actualizarAlumno(Alumno alumno) throws ExcepcionSistema {
        try {
            String consulta;
            int resultadoConsulta;
            consulta = "update from alumno set apellidoPaterno=1, apellidoMaterno=2, "
                    + "nombres=3, estado=4, direccion=5, correo=6, telefono=7";
            consulta = consulta.replace("1", "\"" + alumno.getApellidoPaterno() + "\"");
            consulta = consulta.replace("2", "\"" + alumno.getApellidoMaterno() + "\"");
            consulta = consulta.replace("3", "\"" + alumno.getNombres() + "\"");
            consulta = consulta.replace("4", "\"" + alumno.getEstado() + "\"");
            consulta = consulta.replace("5", "\"" + alumno.getDireccion() + "\"");
            consulta = consulta.replace("6", "\"" + alumno.getCorreo() + "\"");
            consulta = consulta.replace("7", "\"" + alumno.getTelefono() + "\"");
            conexion.iniciarConexion();
            resultadoConsulta = SQL.update(consulta, conexion);
            conexion.terminarConexion();

        } catch (SQLException ex) {
            throw new ExcepcionSistema("Error a conectarse a base de datos", 1);
        }

    }

    @Override
    public Alumno buscarAlumno(String matricula) throws ExcepcionSistema {
        Alumno alumno = null;     
        try {
            String consulta = "select * from alumno where matricula=\"" + matricula + "\"";

            conexion.iniciarConexion();
            ResultSet resultado = SQL.query(consulta, conexion);
            if (resultado.next()) {
                alumno = new Alumno(resultado.getString("apellidoPaterno"),
                        resultado.getString("apellidoMaterno"), resultado.getString("nombres"),
                        resultado.getString("matricula"), resultado.getString("estado"),
                        resultado.getString("programaEducativo"), resultado.getString("direccion"),
                        resultado.getString("correo"), resultado.getString("telefono"), resultado.getInt("promedio"));
            }
            conexion.terminarConexion();
        } catch (SQLException ex) {
            throw new ExcepcionSistema("Error a conectarse a base de datos", 1);
        }
        return alumno;
    }

    @Override
    public ObservableList<Alumno> buscarRegistroDeAlumnos() throws ExcepcionSistema {
        ObservableList<Alumno> registroAlumnos = FXCollections.observableArrayList();
        try {
            conexion.iniciarConexion();
            ResultSet resultado = SQL.query("select * from alumno", conexion);
            while (resultado.next()) {
                Alumno alumno = new Alumno(resultado.getString("apellidoPaterno"),
                        resultado.getString("apellidoMaterno"), resultado.getString("nombres"),
                        resultado.getString("matricula"), resultado.getString("estado"),
                        resultado.getString("programaEducativo"), resultado.getString("direccion"),
                        resultado.getString("correo"), resultado.getString("telefono"), resultado.getInt("promedio"));
                registroAlumnos.add(alumno);
            }
            conexion.terminarConexion();
        } catch (SQLException ex) {
            throw new ExcepcionSistema("Error a conectarse a base de datos", 1);
        }

        return registroAlumnos;
    }

    @Override
    public ObservableList<Alumno> buscarRegistroDeAlumnos(String programaEducativo) throws ExcepcionSistema {
        ObservableList<Alumno> registroAlumnos = FXCollections.observableArrayList();
        try {
            String consulta = "select * from alumno where programaEducativo = \"" + programaEducativo + "\""; 
            conexion.iniciarConexion();
            ResultSet resultado = SQL.query(consulta, conexion);
            while (resultado.next()) {
                Alumno alumno = new Alumno(resultado.getString("apellidoPaterno"),
                        resultado.getString("apellidoMaterno"), resultado.getString("nombres"),
                        resultado.getString("matricula"), resultado.getString("estado"),
                        resultado.getString("programaEducativo"), resultado.getString("direccion"),
                        resultado.getString("correo"), resultado.getString("telefono"), resultado.getInt("promedio"));
                registroAlumnos.add(alumno);
            }
            conexion.terminarConexion();
        } catch (SQLException ex) {
            throw new ExcepcionSistema("Error a conectarse a base de datos", 1);
        }

        return registroAlumnos;
    }

    @Override
    public ObservableList<Alumno> buscarRegistroDeAlumnos(String periodo, String programaEducativo) throws ExcepcionSistema {
        ObservableList<Alumno> registroAlumnos = FXCollections.observableArrayList();
        try {
            String consulta = "select a.* from alumno as a, "
                    + "serviciosocial as b where a.programaEducativo = b.programaEducativoa "
                    + "and a.programaEducativo = \"" + programaEducativo + "\" and b.periodo = \"" + periodo + "\""; 
            conexion.iniciarConexion();
            ResultSet resultado = SQL.query(consulta, conexion);
            while (resultado.next()) {
                Alumno alumno = new Alumno(resultado.getString("apellidoPaterno"),
                        resultado.getString("apellidoMaterno"), resultado.getString("nombres"),
                        resultado.getString("matricula"), resultado.getString("estado"),
                        resultado.getString("programaEducativo"), resultado.getString("direccion"),
                        resultado.getString("correo"), resultado.getString("telefono"), resultado.getInt("promedio"));
                registroAlumnos.add(alumno);
            }
            conexion.terminarConexion();
        } catch (SQLException ex) {
            throw new ExcepcionSistema("Error a conectarse a base de datos", 1);
        }

        return registroAlumnos;
    }
    
    /**
     *
     * @param periodo
     * @param programaEducativo
     * @param matricula
     * @return
     * @throws ExcepcionSistema
     */
    @Override
    public ObservableList<Alumno> buscarRegistroDeAlumnos(String periodo, String programaEducativo, String matricula) throws ExcepcionSistema {
        ObservableList<Alumno> registroAlumnos = FXCollections.observableArrayList();
        try {
            String consulta = "select a.* from alumno as a, serviciosocial as b "
                    + "where a.programaEducativo = b.programaEducativo and "
                    + "a.programaEducativo = \"" + programaEducativo + "\" and "
                    + "b.periodo = \"" + periodo+ "\" and a.matricula = \"" + matricula + "\""; 
            conexion.iniciarConexion();
            ResultSet resultado = SQL.query(consulta, conexion);
            while (resultado.next()) {
                Alumno alumno = new Alumno(resultado.getString("apellidoPaterno"),
                        resultado.getString("apellidoMaterno"), resultado.getString("nombres"),
                        resultado.getString("matricula"), resultado.getString("estado"),
                        resultado.getString("programaEducativo"), resultado.getString("direccion"),
                        resultado.getString("correo"), resultado.getString("telefono"), resultado.getInt("promedio"));
                registroAlumnos.add(alumno);
            }
            conexion.terminarConexion();
        } catch (SQLException ex) {
            throw new ExcepcionSistema("Error a conectarse a base de datos", 1);
        }

        return registroAlumnos;
    }
}
