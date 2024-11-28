/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package assignment04_222071008;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private TextField name;
    @FXML
    private TextField password;
    @FXML
    private TextField email;
    @FXML
    private TextField city;
    @FXML
    private DatePicker date;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;
    @FXML
    private RadioButton mirpur;
    @FXML
    private Label e_text;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        RadioButton[] r_button = {male,female,mirpur};
        boolean not_in = true;
        String gg = new String("");
        for(RadioButton r_btn:r_button){
            if(r_btn.isSelected()){
                not_in = false;
                gg=  r_btn.getText();
            }
        }
        if(name.getText().length() == 0 || password.getText().length()==0 || email.getText().length()==0 || city.getText().length() ==0 || date.getValue().toString().length()==0 || not_in){
            e_text.setText("Please fill up all the fields");
        }
        else{
          FXMLLoader loader = new FXMLLoader(getClass().getResource("show_profile.fxml"));
        Parent userView = loader.load();
        Show_profileController pf = loader.getController();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(java.time.format.FormatStyle.SHORT)
                                                       .withLocale(Locale.getDefault());
        pf.setAll(name.getText(),date.getValue().format(formatter),gg,email.getText(),city.getText());
        Scene userScene = new Scene(userView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(userScene);
        window.show();
        }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ToggleGroup ts = new ToggleGroup();
        this.male.setToggleGroup(ts);
        this.female.setToggleGroup(ts);
        this.mirpur.setToggleGroup(ts);
    }    
    
}
