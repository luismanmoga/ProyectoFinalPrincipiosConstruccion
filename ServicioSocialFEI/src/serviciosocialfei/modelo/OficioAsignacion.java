/*
Progrmadador: Angel Eduardo Martinez Leo Lim
Fecha: 29/05/2019
*/
package serviciosocialfei.modelo;

import javafx.beans.property.SimpleStringProperty;

public class OficioAsignacion {
    private SimpleStringProperty estado;
    private SimpleStringProperty fechaCarga;
    private SimpleStringProperty nombreArchivo;
    
    public void setFechaDeCarga(String fechaDeCarga) {
        this.fechaCarga.set(fechaDeCarga);
    }
    
    public String getFechaDeCarga() {
        return fechaCarga.get();
    }
    
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo.set(nombreArchivo);
    }
    
    public String getNombreArchivo() {
        return nombreArchivo.get();
    }    
    
    public void validarOficioAsignacion() {
        estado.set("Validado");
    }
    
    public void rechazarOficioAsignacion() {
        estado.set("Rechazado");
    }
    
    public OficioAsignacion() {
        estado = new SimpleStringProperty("En revisión");
        fechaCarga = new SimpleStringProperty();
        nombreArchivo = new SimpleStringProperty();
        
    }
    
    public OficioAsignacion(String estado, String fechaCarga, String nombreArchivo) {
        this.estado = new SimpleStringProperty(estado);
        this.fechaCarga = new SimpleStringProperty(fechaCarga);
        this.nombreArchivo = new SimpleStringProperty(nombreArchivo);
    }
}
