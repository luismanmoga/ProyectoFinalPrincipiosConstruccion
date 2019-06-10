/*
Programador: Martinez Leo Lim Angel Eduardo
*/
package serviciosocialfei.dao;

import java.sql.SQLException;
import javafx.collections.ObservableList;
import serviciosocialfei.modelo.Alumno;

public interface AlumnoDAO {
    void registrarAlumno(Alumno alumno) throws ExcepcionSistema;
    void eliminarAlumno(Alumno alumno) throws ExcepcionSistema;
    void actualizarAlumno(Alumno alumno) throws ExcepcionSistema;
    Alumno buscarAlumno(String matricula) throws ExcepcionSistema;
    ObservableList<Alumno> buscarRegistroDeAlumnos() throws ExcepcionSistema;
    ObservableList<Alumno> buscarRegistroDeAlumnos(String programaEducativo) throws ExcepcionSistema;
    ObservableList<Alumno> buscarRegistroDeAlumnos(String periodo, String programaEducativo) throws ExcepcionSistema;
    ObservableList<Alumno> buscarRegistroDeAlumnos(String periodo, String programaEducativo, String matricula) throws ExcepcionSistema;
}
