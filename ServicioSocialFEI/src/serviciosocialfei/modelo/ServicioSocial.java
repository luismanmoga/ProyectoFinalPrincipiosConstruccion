/*
Progrmadador: Angel Eduardo Martinez Leo Lim
Fecha: 29/05/2019
 */
package serviciosocialfei.modelo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ServicioSocial {

    private SimpleIntegerProperty bloque;
    private SimpleIntegerProperty seccion;
    private SimpleStringProperty nrc;
    private SimpleStringProperty programaEducativo;

    public SimpleIntegerProperty getBloque() {
        return bloque;
    }

    public void setBloque(int bloque) {
        this.bloque.set(bloque);
    }

    public Integer getSeccion() {
        return seccion.get();
    }

    public void setSeccion(int seccion) {
        this.seccion.set(seccion);
    }

    public String getNrc() {
        return nrc.get();
    }

    public void setNrc(String nrc) {
        this.nrc.set(nrc);
    }

    public String getProgramaEducativo() {
        return programaEducativo.get();
    }

    public void setProgramaEducativo(String programaEducativo) {
        this.programaEducativo.set(programaEducativo);
    }

    public ServicioSocial(int bloque, int seccion, String nrc, String programaEducativo) {
        this.bloque = new SimpleIntegerProperty(bloque);
        this.seccion = new SimpleIntegerProperty(seccion);
        this.nrc =  new SimpleStringProperty(nrc);
        this.programaEducativo = new SimpleStringProperty(programaEducativo);
    }
    
    public ServicioSocial() {
        this.bloque = new SimpleIntegerProperty(0);
        this.seccion = new SimpleIntegerProperty(0);
        this.nrc =  new SimpleStringProperty("");
        this.programaEducativo = new SimpleStringProperty("");
    }
}
