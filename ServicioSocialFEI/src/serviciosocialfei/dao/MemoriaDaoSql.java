/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosocialfei.dao;

import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import serviciosocialfei.conexion.Conexion;
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
        File carpetaInscripcion = new File ("src\\documentos\\" + inscripcion.getCurso().getNrc() + "_" + inscripcion.getEstudiante().getMatricula() + "\\");
        System.out.println(carpetaInscripcion.getAbsolutePath());
        carpetaInscripcion.mkdirs();
    }

    @Override
    public void actualizarDocumento(Memoria documento, Inscripcion inscripcion) throws ExcepcionSistema {
        String consulta = "update from memoria set estado = 1, fecha = 2, nombreArchoivo where Inscripcion_nrc = \"" 
                + inscripcion.getCurso().getNrc() + "\" and Inscripcion_matricula = \"" 
                + inscripcion.getEstudiante().getMatricula() + "\"";
        try {
            conexion.iniciarConexion();
            
            conexion.terminarConexion();
        } catch (SQLException ex) {
            throw new ExcepcionSistema("Error a conectarse a base de datos", 1);
        }
    }

    @Override
    public void eliminarDocumento(Memoria documento, Inscripcion inscripcion) throws ExcepcionSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Memoria buscarDocumeto(Inscripcion inscripcion) throws ExcepcionSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<Memoria> buscarDocumetos(Inscripcion inscripcion) throws ExcepcionSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
