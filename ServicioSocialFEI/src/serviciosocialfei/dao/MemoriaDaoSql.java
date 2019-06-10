/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosocialfei.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import serviciosocialfei.conexion.Conexion;
import serviciosocialfei.conexion.SQL;
import serviciosocialfei.modelo.Inscripcion;
import serviciosocialfei.modelo.Memoria;

/**
 *
 * @author Eduardo
 */
public class MemoriaDaoSql implements DocumentoDAO<Memoria> {

    Conexion conexion;

    public MemoriaDaoSql() {
        conexion = new Conexion("localhost", "serviciosocial", "proyectoSS", "12345");
    }

    @Override
    public void registrarDocumento(Memoria documento, Inscripcion inscripcion) throws ExcepcionSistema {
        try {
            Integer resultadoConsulta = 0;
            conexion.iniciarConexion();
            String consultaComprobacion = "select * from memoria where Inscripcion_matricula = \"" + inscripcion.getEstudiante().getMatricula() + "\" and Inscripcion_nrc = \"" + inscripcion.getCurso().getNrc() + "\"";
            ResultSet resultadoComprobacion = SQL.query(consultaComprobacion, conexion);
            
            if(!resultadoComprobacion.next()) {
                String consulta = "insert into memoria (estado,fecha,nombreArchivo,Inscripcion_nrc,Inscripcion_matricula) values (1,2,3,4,5)";
                consulta = consulta.replace("1,", "\"" + documento.getEstado() + "\",");
                consulta = consulta.replace("2,", "\"" + documento.getFechaDeCarga() + "\",");
                consulta = consulta.replace("3,", "\"Memoria.pdf\",");
                consulta = consulta.replace("4,", "\"" + inscripcion.getCurso().getNrc() + "\",");
                consulta = consulta.replace("5)", "\"" + inscripcion.getEstudiante().getMatricula() + "\")");
                resultadoConsulta = SQL.update(consulta, conexion);
            }
            
            conexion.terminarConexion();
            if (resultadoConsulta == 1) {
                String carpeta = System.getProperty("user.dir") + "\\documentos\\" + inscripcion.getCurso().getNrc() + "_" + inscripcion.getEstudiante().getMatricula() + "\\";
                String rutaDestino = carpeta + "Memoria.pdf";
                String rutaOrigen = documento.getNombreArchivo();
                File carpetaInscripcion = new File(carpeta);
                carpetaInscripcion.mkdirs();
                Path origenPath = Paths.get(rutaOrigen);
                Path destinoPath = Paths.get(rutaDestino);
                System.out.println(Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING));
            }
        } catch (IOException ex) {
            throw new ExcepcionSistema("Error a conectarse a base de datos", 1);
        } catch (SQLException ex) {
            throw new ExcepcionSistema("Error a conectarse a base de datos", 1);
        }
    }

    @Override
    public void actualizarDocumento(Memoria documento, Inscripcion inscripcion) throws ExcepcionSistema {
        String consulta = "update from memoria set estado = \"" + documento.getEstado()+ "\", fecha = \"" 
                + documento.getFechaDeCarga() + "\", nombreArchoivo = \"" + documento.getNombreArchivo() 
                + "\" where Inscripcion_nrc = \"" + inscripcion.getCurso().getNrc() 
                + "\" and Inscripcion_matricula = \"" + inscripcion.getEstudiante().getMatricula() + "\"";
        try {
            conexion.iniciarConexion();
            SQL.update(consulta, conexion);
            conexion.terminarConexion();
        } catch (SQLException ex) {
            throw new ExcepcionSistema("Error a conectarse a base de datos", 1);
        }
    }

    @Override
    public void eliminarDocumento(Memoria documento, Inscripcion inscripcion) throws ExcepcionSistema {
        String rutaArchivo = System.getProperty("user.dir") + "\\documentos\\" + inscripcion.getCurso().getNrc() + "_" + inscripcion.getEstudiante().getMatricula() + "\\" + documento.getNombreArchivo();
        String consulta = "delete from memoria where "
                + "Inscripcion_matricula = \"" + inscripcion.getEstudiante().getMatricula() + "\" and "
                + "Inscripcion_nrc = \"" + inscripcion.getCurso().getNrc() + "\"";
        try {
            conexion.iniciarConexion();
            int resultadoConsulta = SQL.update(consulta, conexion);
            if(resultadoConsulta == 1) {
                File archivo = new File(rutaArchivo);
                archivo.delete();
            }
            conexion.terminarConexion();
        } catch (SQLException ex) {
            throw new ExcepcionSistema("Error a conectarse a base de datos", 1);
        }
        
    }

    @Override
    public Memoria buscarDocumeto(Inscripcion inscripcion) throws ExcepcionSistema {
        Memoria memoria = null;
        String consulta = "select * from memoria where Inscripcion_matricula = \"" + inscripcion.getEstudiante().getMatricula() + "\"";
        System.out.println(consulta);
        try {
            conexion.iniciarConexion();
            ResultSet resultadoConsulta = SQL.query(consulta, conexion);
            if(resultadoConsulta.next()) {
                memoria = new Memoria(resultadoConsulta.getString("estado"), 
                        resultadoConsulta.getString("fecha"), 
                        resultadoConsulta.getString("nombreArchivo"));
            }      
            conexion.terminarConexion();
            return memoria;
        } catch (SQLException ex) {
            throw new ExcepcionSistema("Error a conectarse a base de datos", 1);
        }
    }

    @Override
    public ObservableList<Memoria> buscarDocumetos(Inscripcion inscripcion) throws ExcepcionSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
