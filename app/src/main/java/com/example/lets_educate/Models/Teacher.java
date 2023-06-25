package com.example.lets_educate.Models;

public class Teacher {

    private String Fname;
    private String Lname;
    private String Phoneno;
    private String Address;
    private String Qualification;
    private String Intrest;
    private String Skillknowledge;
    private String Subject;
    
    public Teacher(){

}

    public Teacher(String fname, String lname, String address, String phoneno, String intrest, String qualification, String skillknowledge, String subject) {
        Fname = fname;
        Lname = lname;
        Phoneno = phoneno;
        Address = address;
        Qualification = qualification;
        Intrest = intrest;
        Skillknowledge = skillknowledge;
        Subject = subject;
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

    public String getPhoneno() {
        return Phoneno;
    }

    public void setPhoneno(String phoneno) {
        Phoneno = phoneno;
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

    public String getIntrest() {
        return Intrest;
    }

    public void setIntrest(String intrest) {
        Intrest = intrest;
    }

    public String getSkillknowledge() {
        return Skillknowledge;
    }

    public void setSkillknowledge(String skillknowledge) {
        Skillknowledge = skillknowledge;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }
}
