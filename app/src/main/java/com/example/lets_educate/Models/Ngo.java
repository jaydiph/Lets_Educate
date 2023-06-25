package com.example.lets_educate.Models;

public class Ngo {

    private String Name;
    private String Email;
    private String Address;
    private String Phoneno;

    public Ngo(){

    }

    public Ngo(String name, String email, String phoneno, String address) {
        Name = name;
        Email = email;
        Address = address;
        Phoneno = phoneno;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneno() {
        return Phoneno;
    }

    public void setPhoneno(String phoneno) {
        Phoneno = phoneno;
    }
}
