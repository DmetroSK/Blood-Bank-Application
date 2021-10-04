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


public class DonorController implements Initializable {

    @FXML
    private AnchorPane donorAnchor;

    public static AnchorPane static_donorAnchor;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtNic;

    @FXML
    private ToggleGroup tgGender;

    @FXML
    private TextField txtPhone;

    @FXML
    private DatePicker dob;

    @FXML
    private TextField txtCity;

    @FXML
    private ComboBox comboBloodGroup;

    @FXML
    private TextField txtWeight;

    @FXML
    private ToggleGroup tgPreviousDonations;

    @FXML
    private DatePicker lastDonateDate;

    @FXML
    private TextArea txtHealthIssues;


    @FXML
    public void back() throws Exception{
        Parent root =  FXMLLoader.load(getClass().getResource("dashboard-view.fxml"));
        Stage stage = (Stage) static_donorAnchor.getScene().getWindow();
        stage.setScene(new Scene(root,530,492));
        stage.getIcons().add(new Image("https://img.icons8.com/color/48/000000/drop-of-blood.png"));
        stage.setTitle("Dashboard");
        stage.centerOnScreen();
    }

    @FXML
    public void cancel() throws Exception{
        txtFullName.clear();
        txtNic.clear();
        dob.getEditor().clear();
        lastDonateDate.getEditor().clear();
        txtCity.clear();
        txtPhone.clear();
        txtWeight.clear();
        txtHealthIssues.clear();
        comboBloodGroup.getItems().removeAll(comboBloodGroup.getItems());
        tgGender.selectToggle(null);
        tgPreviousDonations.selectToggle(null);
    }

    @FXML
    public void save() throws Exception{

        DonorView donorView = new DonorView();

        RadioButton selectGender = (RadioButton)tgGender.getSelectedToggle();
        String tgGenderValue = selectGender.getText();

        RadioButton selectPreviousDonor = (RadioButton)tgPreviousDonations.getSelectedToggle();
        String tgPreviousDonationValue = selectPreviousDonor.getText();

        donorView.setUserDetails(txtFullName.getText(), txtNic.getText(), tgGenderValue,txtPhone.getText(), dob.getValue().toString(), txtCity.getText(), comboBloodGroup.getSelectionModel().getSelectedItem().toString());
        donorView.registerDonor(txtWeight.getText(),tgPreviousDonationValue,txtHealthIssues.getText(),lastDonateDate.getValue().toString());

        cancel();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        static_donorAnchor = donorAnchor;

        comboBloodGroup.getItems().removeAll(comboBloodGroup.getItems());
        comboBloodGroup.getItems().addAll("A+","A-","B+","B-","O+","O-","AB+","AB-");
    }
}

