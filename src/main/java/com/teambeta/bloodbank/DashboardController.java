package com.teambeta.bloodbank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private Label lblDonors;

    public static Label static_lblDonors;

    @FXML
    private Label lblRecipients;

    public static Label static_lblRecipients;

    @FXML
    private Label lblAplus;

    public static Label static_lblAplus;

    @FXML
    private Label lblAminus;

    public static Label static_lblAminus;

    @FXML
    private Label lblBplus;

    public static Label static_lblBplus;

    @FXML
    private Label lblBminus;

    public static Label static_lblBminus;

    @FXML
    private Label lblABplus;

    public static Label static_lblABplus;

    @FXML
    private Label lblABminus;

    public static Label static_lblABminus;

    @FXML
    private Label lblOplus;

    public static Label static_lblOplus;

    @FXML
    private Label lblOminus;

    public static Label static_lblOminus;

    @FXML
    private AnchorPane dashboardsAnchor;

    @FXML
    void exit() {
        Stage stage = (Stage) dashboardsAnchor.getScene().getWindow();
        stage.close();
    }

    @FXML
    void donorRegister() throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("donor-view.fxml"));
        Stage stage = (Stage) dashboardsAnchor.getScene().getWindow();
        stage.setScene(new Scene(root,525,857));
        stage.getIcons().add(new Image("https://img.icons8.com/color/48/000000/drop-of-blood.png"));
        stage.setTitle("Donor Details");
        stage.centerOnScreen();
    }

    @FXML
    void recipientRegister() throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("recipient-view.fxml"));
        Stage stage = (Stage) dashboardsAnchor.getScene().getWindow();
        stage.setScene(new Scene(root,525,534));
        stage.getIcons().add(new Image("https://img.icons8.com/color/48/000000/drop-of-blood.png"));
        stage.setTitle("Recipient Details");
        stage.centerOnScreen();
    }

    @FXML
    void donate() throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("donate-blood-view.fxml"));
        Stage stage = (Stage) dashboardsAnchor.getScene().getWindow();
        stage.setScene(new Scene(root,527,575));
        stage.getIcons().add(new Image("https://img.icons8.com/color/48/000000/drop-of-blood.png"));
        stage.setTitle("Donate Blood");
        stage.centerOnScreen();
    }

    @FXML
    void request() throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("request-blood-view.fxml"));
        Stage stage = (Stage) dashboardsAnchor.getScene().getWindow();
        stage.setScene(new Scene(root,527,488));
        stage.getIcons().add(new Image("https://img.icons8.com/color/48/000000/drop-of-blood.png"));
        stage.setTitle("Request Blood");
        stage.centerOnScreen();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        static_lblAplus = lblAplus;
        static_lblAminus = lblAminus;
        static_lblBplus = lblBplus;
        static_lblBminus = lblBminus;
        static_lblABplus = lblABplus;
        static_lblABminus = lblABminus;
        static_lblOplus = lblOplus;
        static_lblOminus = lblOminus;

        static_lblDonors = lblDonors;
        static_lblRecipients = lblRecipients;

        DashboardView dashboardView = new DashboardView();
    }
}
