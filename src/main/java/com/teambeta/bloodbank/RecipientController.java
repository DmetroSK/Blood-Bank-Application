package com.teambeta.bloodbank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class RecipientController implements Initializable {

    @FXML
    private AnchorPane recipientAnchor;

    public static AnchorPane static_recipientAnchor;


    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtNic;

    @FXML
    private ToggleGroup tgGender;

    @FXML
    private DatePicker dob;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtPhone;

    @FXML
    private ComboBox comboBloodGroup;


    @FXML
    public void back() throws Exception {
        Parent root =  FXMLLoader.load(getClass().getResource("dashboard-view.fxml"));
        Stage stage = (Stage) static_recipientAnchor.getScene().getWindow();
        stage.setScene(new Scene(root,530,492));
        stage.getIcons().add(new Image("https://img.icons8.com/color/48/000000/drop-of-blood.png"));
        stage.setTitle("Dashboard");
        stage.centerOnScreen();
    }

    @FXML
    public void cancel() throws Exception {
        txtFullName.clear();
        txtNic.clear();
        dob.getEditor().clear();
        txtCity.clear();
        txtPhone.clear();
        tgGender.selectToggle(null);
        comboBloodGroup.getItems().removeAll(comboBloodGroup.getItems());
    }

    @FXML
    public void save() throws Exception {

        RecipientView recipientView = new RecipientView();

        RadioButton selectedGender = (RadioButton) tgGender.getSelectedToggle();
        String tgGenderValue = selectedGender.getText();

        recipientView.setUserDetails(txtFullName.getText(), txtNic.getText(), tgGenderValue, txtPhone.getText(), dob.getValue().toString(), txtCity.getText(), comboBloodGroup.getSelectionModel().getSelectedItem().toString());
        recipientView.registerRecipient();

        cancel();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        static_recipientAnchor=recipientAnchor;

        comboBloodGroup.getItems().removeAll(comboBloodGroup.getItems());
        comboBloodGroup.getItems().addAll("A+","A-","B+","B-","O+","O-","AB+","AB-");
    }
}
