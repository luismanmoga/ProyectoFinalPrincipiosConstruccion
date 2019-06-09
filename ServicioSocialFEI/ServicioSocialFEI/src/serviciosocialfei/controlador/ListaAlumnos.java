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
public class ListaAlumnos implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private Button btnExpediente;
    @FXML private void btnExpedienteAction(ActionEvent e){
        Stage ventana = new Stage();
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/serviciosocialfei/gui/ExpedienteGUI.fxml"));
        try{
            root = loader.load();
            ExpedienteGUIController ctrlExpediente = loader.getController();
            Scene escena = new Scene(root);
            ventana.setScene(escena);
            ventana.setTitle("Expediente");
            ventana.show();
        }catch(IOException ex){
            System.out.println("Error");
        }    
    }    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
