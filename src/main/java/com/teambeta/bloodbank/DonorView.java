package com.teambeta.bloodbank;

import javafx.scene.control.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DonorView extends User {

    String newWeight,newPreviousDonations,newHealthIssues,newLastDonationDate;

    @Override
    public void setUserDetails(String fullName, String nic, String gender, String phone, String dateOfBirth, String city, String bloodGroup) {

        this.fullName = fullName;
        this.nic = nic;
        this.gender = gender;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.bloodGroup = bloodGroup;

    }

    public void registerDonor(String weight,String previousDonations, String healthIssues, String lastDonationDate) {

        String query = "Insert into donors (full_name,nic,gender,blood_group,date_of_birth,weight,phone,health_issues,previous_donation_status,date_of_last_blood_donate,date) values (?,?,?,?,?,?,?,?,?,?,?)";

        Validation validation = new Validation();

        newWeight = weight;
        newPreviousDonations = previousDonations;
        newHealthIssues = healthIssues;
        newLastDonationDate = lastDonationDate;

        if (validation.checkDonorValidate(fullName,nic,gender,phone,dateOfBirth,city,bloodGroup,newWeight,newPreviousDonations)) {

            try {
                DatabaseConnection dbCon = new DatabaseConnection();

                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Calendar cal = Calendar.getInstance();

                PreparedStatement ps = dbCon.getConnection().prepareStatement(query);
                ps.setString(1, fullName);
                ps.setString(2, nic);
                ps.setString(3, gender);
                ps.setString(4, bloodGroup);
                ps.setString(5, dateOfBirth);
                ps.setString(6, newWeight);
                ps.setString(7, phone);
                ps.setString(8, newHealthIssues);
                ps.setString(9, newPreviousDonations);
                ps.setString(10, newLastDonationDate);
                ps.setString(11, dateFormat.format(cal.getTime()));


                if (ps.executeUpdate() > 0) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Successfully Saved");
                    alert.show();

                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Error occurred");
                    alert.show();

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
