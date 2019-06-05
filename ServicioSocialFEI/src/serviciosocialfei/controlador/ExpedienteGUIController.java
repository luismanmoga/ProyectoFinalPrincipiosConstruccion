/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosocialfei.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author luis_
 */
public class ExpedienteGUIController implements Initializable {
    
    @FXML Label tipoIns;
    @FXML Label fechaIni;
    @FXML Label contadorHoras;
    @FXML Label estadoAlumno;
    @FXML Label fechaFin;
    @FXML Label horasResta;
    
    public void mostrarProgresoAlumno(){
        
    }
    
    
    @FXML Label nombreAlumno;
    @FXML Label matriculaAlumno;
    @FXML Label correoAlumno;
    @FXML Label direccionAlumno;
    @FXML Label promedioAlumno;
    @FXML Label observacionesAlumno;
    
    @FXML Label nombreContacto;
    @FXML Label direccionContacto;
    @FXML Label telefonoContacto;
    @FXML Label correoContacto;
    
    public void mostrarInfoAlumno(){
        
    }
    
    @FXML Label nombreProyecto;
    @FXML Label nombreOrganizacion;
    @FXML Label nombreEncargadoProyecto;
    @FXML Label telEncargadoProyecto;
    @FXML Label correoEncargadoProyecto;
    
   public void mostrarInfoProyecto(){
       
   }
   
   @FXML TableView reporteMensualTabV;
   @FXML TableColumn mesTabC;
   @FXML TableColumn estadoRMTabC;
   @FXML TableColumn horasTabC;
   @FXML Button btnAgregarRM;
   @FXML Button btnConsultarRM;
   @FXML Button btnEliminarRM;
   
   /*
    Metodos de la tabla reporteMensual
   */
   
   @FXML TableView documentosAnexadosTV;
   @FXML TableColumn nombreTabC;
   @FXML TableColumn estadoDATabC;
   @FXML TableColumn fechaTabC;
   @FXML Button btnConsultarDA;
   @FXML Button btnAgregarDA;
   @FXML Button btnEliminarDA;
   
   /*
    Metodos de la tabla documentos anexados.
   */
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
