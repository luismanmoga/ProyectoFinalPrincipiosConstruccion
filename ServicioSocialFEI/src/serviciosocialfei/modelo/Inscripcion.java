/*
Progrmadador: Angel Eduardo Martinez Leo Lim
Fecha: 29/05/2019
 */
package serviciosocialfei.modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inscripcion {

    private IntegerProperty calificacion;
    private StringProperty estadoAlumno;
    private StringProperty fechaEstimadaFin;
    private StringProperty fechaRealFin;
    private StringProperty fechaInscripcion;
    private StringProperty observaciones;
    private StringProperty tipo;
    private Alumno estudiante;
    private ServicioSocial curso;    
    private ObservableList<ReporteMensual> reportes;
    private CartaLiberacion cartaLiberacion;
    private Memoria memoria;
    private ObservableList<HorarioAlumno> horarios; 
    private ObservableList<RegistroPlanActividades> planActividades;
    private ObservableList<OficioAsignacion> oficioAsignacion;
    private ObservableList<CartaAceptacion> cartaAceptacion;
    private SolicitudOrganizacion asignacionServicioSocial;
    

    public int getCalificacion() {
        return calificacion.get();
    }

    public void setCalificacion(int calificacion) {
        this.calificacion.set(calificacion);
    }

    public String getEstadoAlumno() {
        return estadoAlumno.get();
    }

    public void setEstadoAlumno(String estadoAlumno) {
        this.estadoAlumno.set(estadoAlumno);
    }

    public String getFechaEstimadaFin() {
        return fechaEstimadaFin.get();
    }

    public void setFechaEstimadaFin(String fechaEstimadaFin) {
        this.fechaEstimadaFin.set(fechaEstimadaFin);
    }

    public String getFechaRealFin() {
        return fechaRealFin.get();
    }

    public void setFechaRealFin(String fechaRealFin) {
        this.fechaRealFin.set(fechaRealFin);
    }

    public String getFechaInscripcion() {
        return fechaInscripcion.get();
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion.set(fechaInscripcion);
    }

    public String getObservaciones() {
        return observaciones.get();
    }

    public void setObservaciones(String obeservaciones) {
        this.observaciones.set(obeservaciones);
    }

    public String getTipo() {
        return tipo.get();
    }

    /**
     * Asigna el tipo de inscripción
     * @param tipo Tipo de inscripción
     */
    public void setTipo(String tipo) {
        this.tipo.set(tipo);
    }

    public Alumno getEstudiante() {
        return estudiante;
    }
    
    public void setEstudiante(Alumno estudiante) {
        this.estudiante = estudiante;
    }
    
    public ServicioSocial getCurso() {
        return curso;
    }
    
    public void setCurso(ServicioSocial curso) {
        this.curso = curso;
    }
    
    public ObservableList<ReporteMensual> getReportes() {
        return reportes;
    }

    public void setReportes(ObservableList<ReporteMensual> reportes) {
        this.reportes = reportes;
    }

    public CartaLiberacion getCartaLiberacion() {
        return cartaLiberacion;
    }

    public void setCartaLiberacion(CartaLiberacion cartaLiberacion) {
        this.cartaLiberacion = cartaLiberacion;
    }

    public Memoria getMemoria() {
        return memoria;
    }

    public void setMemoria(Memoria memoria) {
        this.memoria = memoria;
    }

    public ObservableList<HorarioAlumno> getHorarios() {
        return horarios;
    }

    public void setHorarios(ObservableList<HorarioAlumno> horarios) {
        this.horarios = horarios;
    }

    public ObservableList<RegistroPlanActividades> getPlanActividades() {
        return planActividades;
    }

    public void setPlanActividades(ObservableList<RegistroPlanActividades> planActividades) {
        this.planActividades = planActividades;        
    }

    public ObservableList<OficioAsignacion> getOficioAsignacion() {
        return oficioAsignacion;
    }

    public void setOficioAsignacion(ObservableList<OficioAsignacion> oficioAsignacion) {
        this.oficioAsignacion = oficioAsignacion;
    }

    public ObservableList<CartaAceptacion> getCartaAceptacion() {
        return cartaAceptacion;
    }

    public void setCartaAceptacion(ObservableList<CartaAceptacion> cartaAceptacion) {
        this.cartaAceptacion = cartaAceptacion;
    }

    public SolicitudOrganizacion getAsignacionServicioSocial() {
        return asignacionServicioSocial;
    }

    public void setAsignacionServicioSocial(SolicitudOrganizacion asignacionServicioSocial) {
        this.asignacionServicioSocial = asignacionServicioSocial;
    }
    
    /**
     * Constructor de Inscripcion
     * @param calificacion Calificacion del alumno
     * @param estadoAlumno Estado de la inscripción del alumno
     * @param fechaEstimadaFin Fecha estimada en la que terminara el servicio del alumno
     * @param fechaRealFin Fecha oficial en la que termina el servicio social
     * @param fechaInscripcion Fecha en que se inscribe el alumno a la experiencia educativa
     * @param tipo Tipo de inscripcion
     * @param observaciones observaciones hechas por el coordinador
     */
    public Inscripcion(int calificacion, String estadoAlumno, String fechaEstimadaFin,
            String fechaRealFin, String fechaInscripcion, String tipo, 
            String observaciones, Alumno estudiante, ServicioSocial curso) {
        this.calificacion = new SimpleIntegerProperty(calificacion);
        this.estadoAlumno = new SimpleStringProperty(estadoAlumno);
        this.fechaEstimadaFin = new SimpleStringProperty(fechaEstimadaFin);
        this.fechaRealFin = new SimpleStringProperty(fechaEstimadaFin);
        this.fechaInscripcion = new SimpleStringProperty(fechaInscripcion);
        this.observaciones = new SimpleStringProperty(observaciones);
        this.tipo = new SimpleStringProperty(tipo);
        this.estudiante = estudiante;
        this.curso = curso;
    }
    
    /**
     * Constructor de Inscripción
     */
    public Inscripcion() {
        calificacion = new SimpleIntegerProperty(0);
        estadoAlumno = new SimpleStringProperty("");
        fechaEstimadaFin = new SimpleStringProperty("");
        fechaRealFin = new SimpleStringProperty("");
        fechaInscripcion = new SimpleStringProperty("");
        observaciones = new SimpleStringProperty("");
        tipo = new SimpleStringProperty("");
        estudiante = new Alumno();
        curso = new ServicioSocial();
    }
}
