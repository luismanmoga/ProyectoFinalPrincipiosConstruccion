/*
Progrmadador: Angel Eduardo Martinez Leo Lim
Fecha: 29/05/2019
*/
package serviciosocialfei.modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class ReporteMensual {
    private SimpleStringProperty estado;
    private SimpleStringProperty fechaCarga;
    private SimpleStringProperty nombreArchivo;
    private SimpleIntegerProperty horasReportadas;
    private SimpleStringProperty mesReportado;
    
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
    
    public void validarReporteMensual() {
        estado.set("Validado");
    }
    
    public void rechazarReporteMensual() {
        estado.set("Rechazado");
    }
    
    public ReporteMensual() {
        estado = new SimpleStringProperty("En revisión");
        fechaCarga = new SimpleStringProperty();
        nombreArchivo = new SimpleStringProperty();
        horasReportadas = new SimpleIntegerProperty();
        mesReportado = new SimpleStringProperty();
    }
    
    public ReporteMensual(String estado, String fechaCarga, String nombreArchivo, 
            int horasReportadas, String mesReportado) {
        this.estado = new SimpleStringProperty(estado);
        this.fechaCarga = new SimpleStringProperty(fechaCarga);
        this.nombreArchivo = new SimpleStringProperty(nombreArchivo);
        this.horasReportadas = new SimpleIntegerProperty(horasReportadas);
        this.mesReportado =  new SimpleStringProperty(mesReportado);
    }
}
