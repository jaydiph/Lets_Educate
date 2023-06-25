package com.example.lets_educate.Models;

public class Student {
    private String Fname;
    private String Lname;
    private String Email;
    private String Phoneno;
    private String School_college;
    private String Address;
    private String Qualification;
    private String Fav_subject;
    private String Percentage;


    public Student() {

    }

    public Student(String fname, String lname, String email, String address, String phoneno, String school_college, String qualification, String fav_subject, String percentage) {
        Fname= fname;
         Lname= lname;
         Email= email;
       Phoneno= phoneno;
        School_college= school_college;
        Address= address;
         Qualification=qualification;
        Fav_subject=fav_subject;
         Percentage=percentage;

    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneno() {
        return Phoneno;
    }

    public void setPhoneno(String phoneno) {
        Phoneno = phoneno;
    }

    public String getSchool_college() {
        return School_college;
    }

    public void setSchool_college(String school_college) {
        School_college = school_college;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getQualification() {
        return Qualification;
    }

    public void setQualification(String qualification) {
        Qualification = qualification;
    }

    public String getFav_subject() {
        return Fav_subject;
    }

    public void setFav_subject(String fav_subject) {
        Fav_subject = fav_subject;
    }

    public String getPercentage() {
        return Percentage;
    }

    public void setPercentage(String percentage) {
        Percentage = percentage;
    }
}