package com.teambeta.bloodbank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtNIC;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtConfirmPassword;

    @FXML
    public Button btnRegister;

    @FXML
    private AnchorPane registerAnchor;

    public static AnchorPane static_registerAnchor;



    @FXML
    public void register() throws Exception {
        RegisterView registerView = new RegisterView();
        registerView.setDetails(txtName.getText(),txtEmail.getText(),txtPassword.getText(),txtConfirmPassword.getText(),txtNIC.getText(),txtPhone.getText());
        registerView.registerAdmin();
    }

    @FXML
    public void cancel() throws Exception {
        txtName.clear();
        txtNIC.clear();
        txtPhone.clear();
        txtEmail.clear();
        txtPassword.clear();
        txtConfirmPassword.clear();
    }

    @FXML
    public void back() throws Exception {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("login-view.fxml"));
        Stage stage = (Stage) static_registerAnchor.getScene().getWindow();
        stage.setScene(new Scene(root,630,522));
        stage.getIcons().add(new Image("https://img.icons8.com/color/48/000000/drop-of-blood.png"));
        stage.setTitle("Login");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        static_registerAnchor= registerAnchor;
    }
}
