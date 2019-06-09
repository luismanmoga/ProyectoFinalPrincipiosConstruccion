/*
Programador: Martinez Leo Lim Angel Eduardo
*/
package serviciosocialfei.dao;

import serviciosocialfei.modelo.Inscripcion;

import javafx.collections.ObservableList;


public interface DocumentoDAO<T> {
    public void registrarDocumento(T documento, Inscripcion inscripcion) throws ExcepcionSistema;
    public void actualizarDocumento(T documento, Inscripcion inscripcion) throws ExcepcionSistema;
    public void eliminarDocumento(T documento, Inscripcion inscripcion) throws ExcepcionSistema;
    public T buscarDocumeto(Inscripcion inscripcion)  throws ExcepcionSistema; 
    public ObservableList<T> buscarDocumetos(Inscripcion inscripcion)  throws ExcepcionSistema; 
}
