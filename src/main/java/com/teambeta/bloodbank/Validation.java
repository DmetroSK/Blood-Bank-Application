package com.teambeta.bloodbank;

import javafx.scene.control.Alert;

public class Validation {

    Alert alert = new Alert(Alert.AlertType.ERROR);

    public Boolean checkLoginValidate(String email, String password){

        if(!checkEmailValidate(email)){
            return false;
        }
        else if(password.equals("")){
            alert.setContentText("Please Enter Password");
            alert.show();
            return false;

        }
        else{
            return true;
        }
    }

    public Boolean checkNicValidate(String nic){
        if(nic.equals("")){
            alert.setContentText("Please Enter NIC Number");
            alert.show();
            return false;
        }
        else if(!isValidNic(nic)){
            alert.setContentText("Please Enter Valid NIC Number");
            alert.show();
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean checkPhoneValidate(String phone){
        if(phone.equals("")){
            alert.setContentText("Please Enter Phone Number");
            alert.show();
            return false;
        }
        else if(!isValidPhone(phone)){
            alert.setContentText("Please Enter Valid Mobile Number");
            alert.show();
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean checkEmailValidate(String email){
        if(email.equals("")){
            alert.setContentText("Please Enter Email");
            alert.show();
            return false;
        }
        else if(!isValidEmail(email)){
            alert.setContentText("Please Enter Valid Email");
            alert.show();
            return false;
        }
        else{
            return true;
        }
    }



    public Boolean checkRegisterValidate(String name,String email,String password,String confirmPassword,String nic,String phone){

        if(name.equals("")){
            alert.setContentText("Please Enter Name");
            alert.show();
            return false;

        }

        else if(!checkNicValidate(nic)){
            return false;
        }

        else if(!checkPhoneValidate(phone)){
            return false;
        }

        else if(!checkLoginValidate(email,password)){
            return false;
        }

        else if(!checkEmailValidate(email)){
            return false;
        }
        else if(password.equals("")){
            alert.setContentText("Please Enter Password");
            alert.show();
            return false;

        }else if(confirmPassword.equals("")){
            alert.setContentText("Please Enter Confirm Password");
            alert.show();
            return false;

        }
        else if(!password.equals(confirmPassword)){
            alert.setContentText("Please enter correct password");
            alert.show();
            return false;

        }
        else {
            return true;
        }
    }

    public boolean checkRecipientValidate(String fullName, String nic, String gender, String phone, String dob, String city, String bloodGroup){
        if(fullName.equals("")){
            alert.setContentText("Please Enter Name");
            alert.show();
            return false;
        }

        else if(!checkNicValidate(nic)){
            return false;
        }

        else if(gender == null){
            alert.setContentText("Please Select Gender");
            alert.show();
            return false;
        }

        else if(!checkPhoneValidate(phone)){
            return false;
        }

        else if(dob.equals("")){
            alert.setContentText("Please Select Date of Birth");
            alert.show();
            return false;
        }

        else if(city.equals("")){
            alert.setContentText("Please Enter City");
            alert.show();
            return false;
        }

        else if(bloodGroup.equals("")){
            alert.setContentText("Please Select Blood Group");
            alert.show();
            return false;
        }
        else{
            return true;
        }
    }

    public boolean checkDonorValidate(String fullName, String nic, String gender, String phone, String dob, String city, String bloodGroup, String weight, String prv_blood_donate_status){

       if(!checkRecipientValidate(fullName,nic,gender,phone,dob,city,bloodGroup)){
            return false;
        }

        else if(weight.equals("")){
            alert.setContentText("Please Enter Weight");
            alert.show();
            return false;
        }

        else if(prv_blood_donate_status.equals("")){
            alert.setContentText("Please Select Last Blood Donate Status");
            alert.show();
            return false;
        }

        else {
            return true;
        }

    }

    static boolean isValidEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public  boolean isValidPhone(String phone)
    {
        String regex = "^\\d{10}$";
        return phone.matches(regex);
    }

    public  boolean isValidNic(String nic)
    {
        String regex = "\\d+";
        return nic.matches(regex);
    }

}
