package com.teambeta.bloodbank;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginView extends LoginController{


    public void checkAuth(String email, String password)
    {

        String query = "Select * from admins where email=? and password=?";

        Validation validation = new Validation();

    if(validation.checkLoginValidate(email,password)) {

    try {

        DatabaseConnection dbCon = new DatabaseConnection();
        PreparedStatement ps = dbCon.getConnection().prepareStatement(query);

        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();


        if (rs.next())
          {
            Parent root =  FXMLLoader.load(getClass().getResource("dashboard-view.fxml"));
            Stage stage = (Stage) static_loginAnchor.getScene().getWindow();
            stage.setScene(new Scene(root,530,492));
            stage.getIcons().add(new Image("https://img.icons8.com/color/48/000000/drop-of-blood.png"));
            stage.setTitle("Dashboard");
            stage.centerOnScreen();

          }

         else {

             Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setContentText("Email or Password doesn't match with existing records");
             alert.show();

             }
    }

        catch (Exception e) {
                                e.printStackTrace();
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setContentText("Database Error");
                                alert.show();
                             }

            }


    else { return; }

    }

}
