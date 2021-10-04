package com.teambeta.bloodbank;


import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DashboardView extends DashboardController{

         public DashboardView(){
             try {
                 DatabaseConnection dbCon = new DatabaseConnection();

                 PreparedStatement ps1 = dbCon.getConnection().prepareStatement("select COUNT(*) AS num1 from donors");
                 PreparedStatement ps2 = dbCon.getConnection().prepareStatement("select COUNT(*) AS num2 from recipients");

                 PreparedStatement ps3 = dbCon.getConnection().prepareStatement("SELECT sum(CAST(packets AS UNSIGNED)) AS num3 FROM blood_packets WHERE blood_group='A+' and user_type='donor'");
                 PreparedStatement ps4 = dbCon.getConnection().prepareStatement("SELECT sum(CAST(packets AS UNSIGNED)) AS num4 FROM blood_packets WHERE blood_group='A-' and user_type='donor'");
                 PreparedStatement ps5 = dbCon.getConnection().prepareStatement("SELECT sum(CAST(packets AS UNSIGNED)) AS num5 FROM blood_packets WHERE blood_group='B+' and user_type='donor'");
                 PreparedStatement ps6 = dbCon.getConnection().prepareStatement("SELECT sum(CAST(packets AS UNSIGNED)) AS num6 FROM blood_packets WHERE blood_group='B-' and user_type='donor'");
                 PreparedStatement ps7 = dbCon.getConnection().prepareStatement("SELECT sum(CAST(packets AS UNSIGNED)) AS num7 FROM blood_packets WHERE blood_group='AB+' and user_type='donor'");
                 PreparedStatement ps8 = dbCon.getConnection().prepareStatement("SELECT sum(CAST(packets AS UNSIGNED)) AS num8 FROM blood_packets WHERE blood_group='AB-' and user_type='donor'");
                 PreparedStatement ps9 = dbCon.getConnection().prepareStatement("SELECT sum(CAST(packets AS UNSIGNED)) AS num9 FROM blood_packets WHERE blood_group='O+' and user_type='donor'");
                 PreparedStatement ps10 = dbCon.getConnection().prepareStatement("SELECT sum(CAST(packets AS UNSIGNED)) AS num10 FROM blood_packets WHERE blood_group='O-' and user_type='donor'");

                 PreparedStatement ps11 = dbCon.getConnection().prepareStatement("SELECT sum(CAST(packets AS UNSIGNED)) AS num11 FROM blood_packets WHERE blood_group='A+' and user_type='recipient'");
                 PreparedStatement ps12 = dbCon.getConnection().prepareStatement("SELECT sum(CAST(packets AS UNSIGNED)) AS num12 FROM blood_packets WHERE blood_group='A-' and user_type='recipient'");
                 PreparedStatement ps13 = dbCon.getConnection().prepareStatement("SELECT sum(CAST(packets AS UNSIGNED)) AS num13 FROM blood_packets WHERE blood_group='B+' and user_type='recipient'");
                 PreparedStatement ps14 = dbCon.getConnection().prepareStatement("SELECT sum(CAST(packets AS UNSIGNED)) AS num14 FROM blood_packets WHERE blood_group='B-' and user_type='recipient'");
                 PreparedStatement ps15 = dbCon.getConnection().prepareStatement("SELECT sum(CAST(packets AS UNSIGNED)) AS num15 FROM blood_packets WHERE blood_group='AB+' and user_type='recipient'");
                 PreparedStatement ps16 = dbCon.getConnection().prepareStatement("SELECT sum(CAST(packets AS UNSIGNED)) AS num16 FROM blood_packets WHERE blood_group='AB-' and user_type='recipient'");
                 PreparedStatement ps17 = dbCon.getConnection().prepareStatement("SELECT sum(CAST(packets AS UNSIGNED)) AS num17 FROM blood_packets WHERE blood_group='O+' and user_type='recipient'");
                 PreparedStatement ps18 = dbCon.getConnection().prepareStatement("SELECT sum(CAST(packets AS UNSIGNED)) AS num18 FROM blood_packets WHERE blood_group='O-' and user_type='recipient'");

                 ResultSet rs1 = ps1.executeQuery();
                 ResultSet rs2 = ps2.executeQuery();
                 ResultSet rs3 = ps3.executeQuery();
                 ResultSet rs4 = ps4.executeQuery();
                 ResultSet rs5 = ps5.executeQuery();
                 ResultSet rs6 = ps6.executeQuery();
                 ResultSet rs7 = ps7.executeQuery();
                 ResultSet rs8 = ps8.executeQuery();
                 ResultSet rs9 = ps9.executeQuery();
                 ResultSet rs10 = ps10.executeQuery();

                 ResultSet rs11 = ps11.executeQuery();
                 ResultSet rs12 = ps12.executeQuery();
                 ResultSet rs13 = ps13.executeQuery();
                 ResultSet rs14 = ps14.executeQuery();
                 ResultSet rs15 = ps15.executeQuery();
                 ResultSet rs16 = ps16.executeQuery();
                 ResultSet rs17 = ps17.executeQuery();
                 ResultSet rs18 = ps18.executeQuery();

                 if (!rs1.next() || !rs2.next() || !rs3.next() || !rs4.next() || !rs5.next() || !rs6.next() || !rs7.next() || !rs8.next() || !rs9.next() || !rs10.next()
                         || !rs11.next() || !rs12.next() || !rs13.next() || !rs14.next() || !rs15.next() || !rs16.next()|| !rs17.next()|| !rs18.next())  {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                     alert.setContentText("No Records");
                     alert.show();

                 }

                 else {

                        static_lblDonors.setText(String.valueOf(rs1.getInt("num1")));
                        static_lblRecipients.setText(String.valueOf(rs2.getInt("num2")));
                        static_lblAplus.setText(String.valueOf(rs3.getInt("num3")-rs11.getInt("num11")));
                        static_lblAminus.setText(String.valueOf(rs4.getInt("num4")-rs12.getInt("num12")));
                        static_lblBplus.setText(String.valueOf(rs5.getInt("num5")-rs13.getInt("num13")));
                        static_lblBminus.setText(String.valueOf(rs6.getInt("num6")-rs14.getInt("num14")));
                        static_lblABplus.setText(String.valueOf(rs7.getInt("num7")-rs15.getInt("num15")));
                        static_lblABminus.setText(String.valueOf(rs8.getInt("num8")-rs16.getInt("num16")));
                        static_lblOplus.setText(String.valueOf(rs9.getInt("num9")-rs17.getInt("num17")));
                        static_lblOminus.setText(String.valueOf(rs10.getInt("num10")-rs18.getInt("num18")));


                 }

             }
             catch (Exception e) {
                 e.printStackTrace();
             }
         }

}
