package com.teambeta.bloodbank;

import javafx.scene.control.Alert;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RecipientView extends User{

    @Override
    public void setUserDetails(String fullName,String nic, String gender,String phone, String dateOfBirth, String city, String bloodGroup) {

        this.fullName = fullName;
        this.nic = nic;
        this.gender = gender;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.bloodGroup = bloodGroup;

    }

    public void registerRecipient() {

        String query = "Insert into recipients (nic,full_name,gender,blood_group,date_of_birth,city,phone,date) values (?,?,?,?,?,?,?,?)";

        Validation validation = new Validation();

        if (validation.checkRecipientValidate(fullName, nic, gender, phone, dateOfBirth, city, bloodGroup)) {

            try {
                DatabaseConnection dbCon = new DatabaseConnection();

                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Calendar cal = Calendar.getInstance();

                PreparedStatement ps = dbCon.getConnection().prepareStatement(query);
                ps.setString(1, nic);
                ps.setString(2, fullName);
                ps.setString(3, gender);
                ps.setString(4, bloodGroup);
                ps.setString(5, dateOfBirth);
                ps.setString(6, city);
                ps.setString(7, phone);
                ps.setString(8, dateFormat.format(cal.getTime()));


                if (ps.executeUpdate() > 0) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Successfully Saved");
                    alert.show();

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Error occurred");
                    alert.show();

                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
