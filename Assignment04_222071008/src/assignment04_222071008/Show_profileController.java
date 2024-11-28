/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package assignment04_222071008;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Show_profileController implements Initializable {

    @FXML
    private Label name;
    @FXML
    private Label date;
    @FXML
    private Label gender;
    @FXML
    private Label email;
    @FXML
    private Label city;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setAll(String n, String d, String g, String e, String c){
        this.name.setText(n);
        this.date.setText(d);
        this.gender.setText(g);
        this.email.setText(e);
        this.city.setText(c);
    }

    @FXML
    private void handleEdit(ActionEvent event) throws IOException {
                  FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent userView = loader.load();
        FXMLDocumentController pf = loader.getController();
        Scene userScene = new Scene(userView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(userScene);
        window.show();
    }
}
