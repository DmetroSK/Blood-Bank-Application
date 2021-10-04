package com.teambeta.bloodbank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class DonateBloodController implements Initializable {

    @FXML
    private TextField txtUserId;

    public static TextField static_userId;

    @FXML
    private AnchorPane donateAnchor;

    @FXML
    private TextField txtNic;

    @FXML
    private TextField txtFullName;

    public static TextField static_fullName;

    @FXML
    private TextField txtBloodGroup;

    public static TextField static_bloodGroup;

    @FXML
    private TextField txtHealthIssues;

    public static TextField static_healthIssues;

    @FXML
    private TextField txtPreviouBloodDonateStatus;

    public static TextField static_previouBloodDonateStatus;

    @FXML
    private TextField txtLastBloodDonateDate;

    public static TextField static_lastBloodDonateDate;

    @FXML
    private TextField txtBloodPackets;

    @FXML
    void cancel() {
        txtFullName.clear();
        txtBloodGroup.clear();
        txtHealthIssues.clear();
        txtPreviouBloodDonateStatus.clear();
        txtLastBloodDonateDate.clear();
        txtBloodPackets.clear();
        txtUserId.clear();
        txtNic.clear();
    }

    @FXML
    void donate() {
        DonateBloodView donateBloodView = new DonateBloodView();
        donateBloodView.donateBlood(txtUserId.getText(),txtBloodGroup.getText(),txtBloodPackets.getText());
        cancel();
    }

    @FXML
    void search() {
        DonateBloodView donateBloodView = new DonateBloodView();
        donateBloodView.fillDetails(txtNic.getText());
    }


    @FXML
    void back() throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("dashboard-view.fxml"));
        Stage stage = (Stage) donateAnchor.getScene().getWindow();
        stage.setScene(new Scene(root,530,492));
        stage.getIcons().add(new Image("https://img.icons8.com/color/48/000000/drop-of-blood.png"));
        stage.setTitle("Dashboard");
        stage.centerOnScreen();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        static_userId = txtUserId;
        static_fullName = txtFullName;
        static_bloodGroup = txtBloodGroup;
        static_healthIssues = txtHealthIssues;
        static_lastBloodDonateDate = txtLastBloodDonateDate;
        static_previouBloodDonateStatus = txtPreviouBloodDonateStatus;
    }
}
