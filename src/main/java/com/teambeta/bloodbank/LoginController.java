package com.teambeta.bloodbank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private AnchorPane loginAnchor;

    public static AnchorPane static_loginAnchor;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    public void login() throws IOException
    {
        LoginView loginView = new LoginView();
        loginView.checkAuth(txtEmail.getText(),txtPassword.getText());
    }

    @FXML
    public void cancel() throws IOException
    {
        txtEmail.clear();
        txtPassword.clear();
    }

    @FXML
    public void register() throws Exception{

            Parent root =  FXMLLoader.load(getClass().getResource("register-view.fxml"));
            Stage stage = (Stage) txtEmail.getScene().getWindow();
            stage.setScene(new Scene(root,525,687));
            stage.getIcons().add(new Image("https://img.icons8.com/color/48/000000/drop-of-blood.png"));
            stage.setTitle("Register");

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        static_loginAnchor = loginAnchor;
    }
}
