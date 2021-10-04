package com.teambeta.bloodbank;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.sql.PreparedStatement;

public class RegisterView extends RegisterController{

    private String newName,newEmail,newPassword,newConfirmPassword,newNic,newPhone;

    public void setDetails(String name,String email,String password,String confirmPassword,String nic,String phone){
        this.newName = name;
        this.newEmail = email;
        this.newPassword = password;
        this.newConfirmPassword = confirmPassword;
        this.newNic = nic;
        this.newPhone = phone;
    }

    public void registerAdmin(){

        String query = "Insert into admins (name,email,password,nic,phone) values (?,?,?,?,?)";

        Validation validation = new Validation();

        if(validation.checkRegisterValidate(newName,newEmail,newPassword,newConfirmPassword,newNic,newPhone)){

            try {
                DatabaseConnection dbCon = new DatabaseConnection();
                PreparedStatement ps = dbCon.getConnection().prepareStatement(query);

                ps.setString(1,newName);
                ps.setString(2,newEmail);
                ps.setString(3,newPassword);
                ps.setString(4,newNic);
                ps.setString(5,newPhone);

                if(ps.executeUpdate()>0)
                {
                    Parent root =  FXMLLoader.load(getClass().getResource("login-view.fxml"));
                    Stage stage = (Stage) static_registerAnchor.getScene().getWindow();
                    stage.setScene(new Scene(root,630,522));
                    stage.getIcons().add(new Image("https://img.icons8.com/color/48/000000/drop-of-blood.png"));
                    stage.setTitle("Login");
                    stage.centerOnScreen();


                }

                else {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Error Occurred");
                    alert.show();

                     }

            } catch (Exception e) {e.printStackTrace();}

        }

    }

    public String getNewName() {
        return newName;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getNewConfirmPassword() {
        return newConfirmPassword;
    }

    public String getNewNic() {
        return newNic;
    }

    public String getNewPhone() {
        return newPhone;
    }
}
