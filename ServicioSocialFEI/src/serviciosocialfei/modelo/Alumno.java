/*
Progrmadador: Angel Eduardo Martinez Leo Lim
Fecha: 29/05/2019
Última modificación: 30/05/2019
*/
package serviciosocialfei.modelo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

public class Alumno {
    private SimpleStringProperty apellidoPaterno;
    private SimpleStringProperty apellidoMaterno;
    private SimpleStringProperty nombres;
    private SimpleStringProperty matricula;
    private SimpleStringProperty estado;
    private SimpleStringProperty programaEducativo;
    private SimpleStringProperty direccion;
    private SimpleStringProperty correo;
    private SimpleStringProperty telefono;
    private SimpleIntegerProperty promedio;
    private Contacto contactoDelAlumno;
    private ObservableList<SeleccionAlumno> selecciones;
            

    public String getApellidoPaterno() {
        return apellidoPaterno.get();
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno.set(apellidoPaterno);
    }

    public String getApellidoMaterno() {
        return apellidoMaterno.get();
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno.set(apellidoMaterno);
    }

    public String getNombres() {
        return nombres.get();
    }

    public void setNombres(String nombres) {
        this.nombres.set(nombres);
    }

    public String getMatricula() {
        return matricula.get();
    }

    public void setMatricula(String matricula) {
        this.matricula.set(matricula);
    }

    public String getDireccion() {
        return direccion.get();
    }

    public void setDireccion(String direccion) {
        this.direccion.set(direccion);
    }

    public String getCorreo() {
        return correo.get();
    }

    public void setCorreo(String correo) {
        this.correo.set(correo);
    }

    public String getTelefono() {
        return telefono.get();
    }

    public void setTelefono(String telefono) {
        this.telefono.set(telefono);
    }

    public Integer getPromedio() {
        return promedio.get();
    }

    public void setPromedio(Integer promedio) {
        this.promedio.set(promedio);
    }
    
    public String getEstado() {
        return estado.get();
    }
    
    public void setEstado(String estado) {
        this.estado.set(estado);
    }
    
    public String getProgramaEducativo() {
        return programaEducativo.get();
    }
    
    public void setProgramaEducativo(String prgramaEducativo) {
        this.programaEducativo.set(prgramaEducativo);
    }
        
    public Alumno(String apellidoPaterno, String apellidoMaterno, String nombres,
            String matricula, String estado, String programaEducativo, 
            String direccion, String correo, String telefono, int promedio) {
        this.apellidoPaterno = new SimpleStringProperty(apellidoPaterno);
        this.apellidoMaterno = new SimpleStringProperty(apellidoMaterno);
        this.nombres = new SimpleStringProperty(nombres);
        this.matricula = new SimpleStringProperty(matricula);
        this.estado = new SimpleStringProperty(estado);
        this.programaEducativo = new SimpleStringProperty(programaEducativo);
        this.direccion = new SimpleStringProperty(direccion);
        this.correo = new SimpleStringProperty(correo);
        this.telefono = new SimpleStringProperty(telefono);
        this.promedio = new SimpleIntegerProperty(promedio);
        this.contactoDelAlumno = new Contacto();
        
    }
    
     public Alumno() {
        this.apellidoPaterno = new SimpleStringProperty("");
        this.apellidoMaterno = new SimpleStringProperty("");
        this.nombres = new SimpleStringProperty("");
        this.matricula = new SimpleStringProperty("");
        this.estado = new SimpleStringProperty("");
        this.programaEducativo = new SimpleStringProperty("");
        this.direccion = new SimpleStringProperty("");
        this.correo = new SimpleStringProperty("");
        this.telefono = new SimpleStringProperty("");
        this.promedio = new SimpleIntegerProperty(0);
        this.contactoDelAlumno = new Contacto();
        
    }
}