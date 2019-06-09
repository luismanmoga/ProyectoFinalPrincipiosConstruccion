/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosocialfei.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
   
   Stage ventana = new Stage();
   Parent root;
   FXMLLoader loader;
   
   @FXML Button btnAgregarRM;
   
   @FXML private void btnAgregarRMAction(){
         loader = new FXMLLoader(getClass().getResource("/serviciosocialfei/gui/SubirReporteGUI.fxml"));
        try{
            root = loader.load();
            SubirReporte ctrlSubirReporte = loader.getController();
            Scene escena = new Scene(root);
            ventana.setScene(escena);
            ventana.setResizable(false);
            ventana.setTitle("Documentos Asignación");
            ventana.show();
        }catch(IOException ex){
            Alert dialogoAlerta = new Alert(AlertType.INFORMATION);
            dialogoAlerta.setTitle("ALERTA");
            dialogoAlerta.setHeaderText("2");
            dialogoAlerta.setContentText("3");
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            dialogoAlerta.showAndWait();
            
        }        
   }
   
   @FXML Button btnConsultarRM;
   @FXML Button btnEliminarRM;
   
   /*
    Metodos de la tabla reporteMensual
   */
   
   @FXML TableView documentosAnexadosTV;
   @FXML TableColumn nombreTabC;
   @FXML TableColumn estadoDATabC;
   @FXML TableColumn fechaTabC;
   
   /*
    Metodos de la tabla documentos anexados.
   */
   
   @FXML Button btnConsultarDA;
   @FXML Button btnAgregarDA;
   @FXML private void btnAgregarDAAction(ActionEvent e){
         loader = new FXMLLoader(getClass().getResource("/serviciosocialfei/gui/SubirDocumentosAsignacionGUI.fxml"));
        try{
            root = loader.load();
            SubirDocumentosAsignacionGUIController ctrlDocAsgn = loader.getController();
            Scene escena = new Scene(root);
            ventana.setScene(escena);
            ventana.setResizable(false);
            ventana.setTitle("Documentos Asignación");
            ventana.show();
        }catch(IOException ex){
            Alert dialogoAlerta = new Alert(AlertType.INFORMATION);
            dialogoAlerta.setTitle("ALERTA");
            dialogoAlerta.setHeaderText("2");
            dialogoAlerta.setContentText("3");
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            dialogoAlerta.showAndWait();
            
        }        
   }   
   
   @FXML Button btnEliminarDA;
   

   @FXML private Button btnAtras;
   @FXML private void btnAtrasAction(){
        Stage stage = (Stage) btnAtras.getScene().getWindow();
        stage.close(); 
   }
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
