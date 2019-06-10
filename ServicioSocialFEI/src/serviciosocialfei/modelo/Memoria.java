/*
Progrmadador: Angel Eduardo Martinez Leo Lim
Fecha: 29/05/2019
*/
package serviciosocialfei.modelo;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;

public class Memoria {
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

    public void setEstado(String estado) {
        this.estado.set(estado);
    }
    
    public String getEstado() {
        return estado.get();
    }
    
    public void validarMemoria() {
        estado.set("Validado");
    }
    
    public void rechazarMemoria() {
        estado.set("Rechazado");
    }
    
    public Memoria() {
        estado = new SimpleStringProperty("En revisión");
        fechaCarga = new SimpleStringProperty(LocalDate.now().toString());
        nombreArchivo = new SimpleStringProperty();
        
    }
    
    public Memoria(String estado, String fechaCarga, String nombreArchivo) {
        this.estado = new SimpleStringProperty(estado);
        this.fechaCarga = new SimpleStringProperty(fechaCarga);
        this.nombreArchivo = new SimpleStringProperty(nombreArchivo);
    }
}
