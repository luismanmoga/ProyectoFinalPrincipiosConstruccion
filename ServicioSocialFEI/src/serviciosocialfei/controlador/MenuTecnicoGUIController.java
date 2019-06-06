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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author luis_
 */
public class MenuTecnicoGUIController implements Initializable {
    
    Stage ventana;
    Parent root;
    FXMLLoader loader;
    
    @FXML private Button btnExpediente;
    @FXML public void btnExpedienteAction(ActionEvent e){
        ventana = new Stage();
        loader = new FXMLLoader(getClass().getResource("/serviciosocialfei/gui/ListaAlumnosGUI.fxml"));
        try{
            root = loader.load();
            ListaAlumnos ctrlListaAlumnos = loader.getController();
            Scene escena = new Scene(root);
            ventana.setScene(escena);
            ventana.setTitle("Lista Alumnos");
            ventana.show();
        }catch(IOException ex){
            System.out.println("Error");
        }
        
    }
    
    @FXML private Button btnContacto;
    @FXML private Button btnOrganizaciones;
    /*@FXML private void btnOrganizacionesAction(ActionEvent e){
        ventana = new Stage();
        loader = new FXMLLoader(getClass().getResource("/serviciosocialfei/gui/.fxml"));
        try{
            root = loader.load();
            ListaAlumnos ctrlListaAlumnos = loader.getController();
            Scene escena = new Scene(root);
            ventana.setScene(escena);
            ventana.setTitle("Expediente");
            ventana.show();
        }catch(IOException ex){
            System.out.println("Error");
        }
    }*/
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
