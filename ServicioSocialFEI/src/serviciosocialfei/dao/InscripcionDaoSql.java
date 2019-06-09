/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosocialfei.dao;

import java.sql.ResultSet;
import serviciosocialfei.conexion.Conexion;
import serviciosocialfei.conexion.SQL;
import serviciosocialfei.modelo.Alumno;
import serviciosocialfei.modelo.Inscripcion;

import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import serviciosocialfei.modelo.ServicioSocial;

/**
 *
 * @author Eduardo
 */
public class InscripcionDaoSql implements InscripcionDAO {

    Conexion conexion;

    public InscripcionDaoSql() {
        conexion = new Conexion("localhost", "serviciosocial", "proyectoSS", "12345");
    }

    @Override
    public void registrarInscripcion(Inscripcion inscripcion) throws ExcepcionSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarInscripcion(Inscripcion inscripcion) throws ExcepcionSistema {
        String consulta = "update inscripcion set calificacion=1, estadoAlumno= ";
    }

    @Override
    public Inscripcion buscarInscripcion(Alumno estudiante, String periodo) throws ExcepcionSistema {
        Inscripcion inscripcion = null;
        try {
            conexion.iniciarConexion();

            String consultaInscripcion = "select i.* from  inscripcion i, "
                    + "serviciosocial s where s.nrc = i.nrc and s.periodo = \"" + periodo + "\" "
                    + "and i.matricula = \"" + estudiante.getMatricula() + "\"";
            ResultSet resultadoInscripcion = SQL.query(consultaInscripcion, conexion);

            String consultaServicioSocial = "select * from servicio social where nrc=\"" + resultadoInscripcion.getString("nrc") + "\"";
            ResultSet resultadoServicioSocial = SQL.query(consultaServicioSocial, conexion);

            ServicioSocial curso = new ServicioSocial(resultadoServicioSocial.getInt("bloque"),
                    resultadoServicioSocial.getInt("seccion"), resultadoServicioSocial.getString("nrc"),
                    resultadoServicioSocial.getString("programaEducativo"));

            inscripcion = new Inscripcion(resultadoInscripcion.getInt("calificacion"),
                    resultadoInscripcion.getString("estadoAlumno"), resultadoInscripcion.getString("fechaEstimadaFin"),
                    resultadoInscripcion.getString("fechaRealFin"), resultadoInscripcion.getString("fechaInscripcion"), resultadoInscripcion.getString("tipo"),
                    resultadoInscripcion.getString("observaciones"), estudiante, curso);

            conexion.terminarConexion();
        } catch (SQLException ex) {
            throw new ExcepcionSistema("Error al conectarse a la base de datos", 1);
        }
        return inscripcion;
    }

    @Override
    public ObservableList<Inscripcion> buscarInscripcionbuscarRegistrosDeInscripcion(Alumno estudiante, String periodo, String programaEducativo) throws ExcepcionSistema {
        ObservableList<Inscripcion> listaInscripciones = FXCollections.observableArrayList();
        try {
            String consulta = "select a.* from alumno as a, "
                    + "serviciosocial as b where a.programaEducativo = b.programaEducativoa "
                    + "and a.programaEducativo = \"" + programaEducativo + "\" and b.periodo = \"" + periodo + "\"";
            conexion.iniciarConexion();
            ResultSet resultadoInscripcion = SQL.query(consulta, conexion);
            while (resultadoInscripcion.next()) {
                String consultaServicioSocial = "select * from servicio social where nrc=\"" + resultadoInscripcion.getString("nrc") + "\"";
                ResultSet resultadoServicioSocial = SQL.query(consultaServicioSocial, conexion);

                ServicioSocial curso = new ServicioSocial(resultadoServicioSocial.getInt("bloque"),
                        resultadoServicioSocial.getInt("seccion"), resultadoServicioSocial.getString("nrc"),
                        resultadoServicioSocial.getString("programaEducativo"));

                Inscripcion inscripcion = new Inscripcion(resultadoInscripcion.getInt("calificacion"),
                        resultadoInscripcion.getString("estadoAlumno"), resultadoInscripcion.getString("fechaEstimadaFin"),
                        resultadoInscripcion.getString("fechaRealFin"), resultadoInscripcion.getString("fechaInscripcion"), resultadoInscripcion.getString("tipo"),
                        resultadoInscripcion.getString("observaciones"), estudiante, curso);
                
                listaInscripciones.add(inscripcion);
            }
            conexion.terminarConexion();
        } catch (SQLException ex) {
            throw new ExcepcionSistema("Error a conectarse a base de datos", 1);
        }
        return listaInscripciones;
    }

}
