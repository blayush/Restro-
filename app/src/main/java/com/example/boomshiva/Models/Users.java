package com.example.boomshiva.Models;

public class Users {
    String profilePic,userName ,mail,password,phoneNo;

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public Users(){}
    public Users( String userName, String mail, String password, String phoneNo) {
        this.userName = userName;
        this.mail = mail;
        this.password = password;
        this.phoneNo = phoneNo;

    }
    public Users(String profilePic, String userName, String mail, String password, String phoneNo) {
        this.profilePic = profilePic;
        this.userName = userName;
        this.mail = mail;
        this.password = password;
        this.phoneNo = phoneNo;

    }
}
