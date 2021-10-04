package com.teambeta.bloodbank;

import javafx.scene.control.Alert;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RequestBloodView extends RequestBloodController {

    public void fillDetails(String nic) {

        String query1 = "Select id,full_name,blood_group from recipients where nic=?";

        try {
            DatabaseConnection dbCon = new DatabaseConnection();
            PreparedStatement ps = dbCon.getConnection().prepareStatement(query1);

            ps.setString(1, nic);

            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("No Records");
                alert.show();

            }
            else {
                    static_userId.setText(rs.getString("id"));
                    static_fullName.setText(rs.getString("full_name"));
                    static_bloodGroup.setText(rs.getString("blood_group"));

                }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void requestBlood(String id, String blood_group, String packets){
        String query2= "Insert into blood_packets (user_id,user_type,blood_group,packets,date) values (?,?,?,?,?)";

        try {

            DatabaseConnection dbCon = new DatabaseConnection();
            PreparedStatement ps = dbCon.getConnection().prepareStatement(query2);

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();

            ps.setString(1, id);
            ps.setString(2, "recipient");
            ps.setString(3, blood_group);
            ps.setString(4, packets);
            ps.setString(5, dateFormat.format(cal.getTime()));

            if(ps.executeUpdate()>0)
            {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Successfully Saved");
                alert.show();
            }

            else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Error Occurred");
                alert.show();

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
