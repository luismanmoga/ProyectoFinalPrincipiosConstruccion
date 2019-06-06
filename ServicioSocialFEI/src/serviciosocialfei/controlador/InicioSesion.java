/**
 * Programador: Martinez Leo Lim Angel Eduardo
 * Fecha: 24/05/2019
 */
package serviciosocialfei.controlador;

import java.io.IOException;
import serviciosocialfei.conexion.Conexion;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import serviciosocialfei.conexion.SQL;

public class InicioSesion implements Initializable {

    Conexion conexion;
    Stage ventana;

    @FXML
    private TextField txtMatricula;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void btnIniciarSesion(ActionEvent event) {
        if (datosValidos()) {
            try {
                conexion.iniciarConexion();
                String consulta = "select * from usuario where matricula = \""
                        + txtMatricula.getText() + "\" and password = \"" + txtPassword.getText() + "\"";
                ResultSet resultadoConsulta = SQL.query(consulta, conexion);

                if (resultadoConsulta.next()) {
                    cargarMenuPrincipal(resultadoConsulta.getString("tipoUsuario"));
                } else {
                    System.out.println("no registrado");
                }
            } catch (SQLException ex) {
                Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
            }
            conexion.terminarConexion();
            mostrarMenuPrincipal();
        } else {
            System.out.println("datos invalidaos");
        }
    }

    @FXML
    void btnRegistrarAlumno(ActionEvent event) {

    }

    boolean datosValidos() {
        return (txtMatricula.getText() != "") || (txtPassword.getText() != "");
    }

    private void cargarMenuPrincipal(String tipoDeUsuario) {
        Parent root;
        FXMLLoader loader;
        switch (tipoDeUsuario) {
            case "ALUMNO":
                ventana = new Stage();
                loader = new FXMLLoader(getClass().getResource("/serviciosocialfei/gui/MenuAlumnoGUI.fxml"));
                try {
                    root = loader.load();
                    MenuAlumno controladorMenuAlumnos = loader.getController();
                    //controlador.setAlumno(resultadoConsulta.getString("matricula"));
                    Scene escena = new Scene(root);
                    ventana.setScene(escena);

                    ventana.setTitle("Alumno");

                } catch (IOException ex) {
                    Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            case "COORDINADOR":
                ventana = new Stage();
                loader = new FXMLLoader(getClass().getResource("/serviciosocialfei/gui/MenuCoordinadorGUI.fxml"));
                try {
                    root = loader.load();
                    MenuCoordinador controladorMenuCoordinador = loader.getController();
                    //controlador.setAlumno(resultadoConsulta.getString("matricula"));
                    Scene escena = new Scene(root);
                    ventana.setScene(escena);

                    ventana.setTitle("Coordinador");

                } catch (IOException ex) {
                    Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            case "AUXILIAR":
                ventana = new Stage();
                loader = new FXMLLoader(getClass().getResource("/serviciosocialfei/gui/MenuTecnicoGUI.fxml"));
                try {
                    root = loader.load();
                    MenuTecnicoGUIController controladorMenuAuxiliarTecnico = loader.getController();
                    //controlador.setAlumno(resultadoConsulta.getString("matricula"));
                    Scene escena = new Scene(root);
                    ventana.setScene(escena);

                    ventana.setTitle("Técnico Auxiliar");

                } catch (IOException ex) {
                    Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
        }
    }
//m10583824 root

    private void mostrarMenuPrincipal() {
        if (ventana != null) {
            Stage login = (Stage) txtPassword.getScene().getWindow();
            login.hide();
            ventana.showAndWait();

            login.show();
            ventana = null;
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conexion = new Conexion("localhost", "serviciosocial", "proyectoSS", "12345");
        txtMatricula.setText("");
        txtPassword.setText("");
        ventana = null;
    }

}
