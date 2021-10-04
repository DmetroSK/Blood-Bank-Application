package com.teambeta.bloodbank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RequestBloodController implements Initializable {

    @FXML
    private AnchorPane requestAnchor;

    public static AnchorPane static_requestAnchor;

    @FXML
    private TextField txtNic;

    @FXML
    private TextField txtFullName;

    public static TextField static_fullName;

    @FXML
    private TextField txtBloodGroup;

    public static TextField static_bloodGroup;

    @FXML
    private TextField txtBloodPackets;

    @FXML
    private TextField txtUserId;

    public static TextField static_userId;


    @FXML
    void cancel() {
        txtNic.clear();
        txtFullName.clear();
        txtBloodGroup.clear();
        txtBloodPackets.clear();
        txtUserId.clear();
    }

    @FXML
    void request() {
        RequestBloodView requestBloodView = new RequestBloodView();
        requestBloodView.requestBlood(txtUserId.getText(),txtBloodGroup.getText(),txtBloodPackets.getText());
        cancel();
    }

    @FXML
    void search() {
        RequestBloodView requestBloodView = new RequestBloodView();
        requestBloodView.fillDetails(txtNic.getText());
    }

    @FXML
    void back() throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("dashboard-view.fxml"));
        Stage stage = (Stage) static_requestAnchor.getScene().getWindow();
        stage.setScene(new Scene(root,530,492));
        stage.getIcons().add(new Image("https://img.icons8.com/color/48/000000/drop-of-blood.png"));
        stage.setTitle("Dashboard");
        stage.centerOnScreen();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        static_requestAnchor = requestAnchor;
        static_fullName = txtFullName;
        static_bloodGroup = txtBloodGroup;
        static_userId = txtUserId;
    }
}
