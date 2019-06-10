/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosocialfei.dao;

import javafx.collections.ObservableList;
import serviciosocialfei.modelo.Alumno;
import serviciosocialfei.modelo.Inscripcion;

/**
 *
 * @author Eduardo
 */
public interface InscripcionDAO {
    public void registrarInscripcion(Inscripcion inscripcion)  throws ExcepcionSistema;
    public void actualizarInscripcion(Inscripcion inscripcion)  throws ExcepcionSistema;
    public Inscripcion buscarInscripcion(Alumno estudiante, String periodo)  throws ExcepcionSistema;
    public ObservableList<Inscripcion> buscarInscripcionbuscarRegistrosDeInscripcion(Alumno estudiante, String periodo, String programaEducativo)  throws ExcepcionSistema;
}
