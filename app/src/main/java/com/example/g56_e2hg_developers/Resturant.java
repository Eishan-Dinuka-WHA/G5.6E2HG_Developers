package com.example.g56_e2hg_developers;

public class Resturant {
    private String meal;
    private String size;
    private String quantity;
    private String details;
    private String cus_name;
    private String con_no;
    private String email;
    private String location;
    private String house_no;
    private String street;
    private String city;

    public Resturant() {
    }

    public Resturant(String meal, String size, String quantity, String details, String cus_name, String con_no, String email, String location, String house_no, String street, String city) {
        this.meal = meal;
        this.size = size;
        this.quantity = quantity;
        this.details = details;
        this.cus_name = cus_name;
        this.con_no = con_no;
        this.email = email;
        this.location = location;
        this.house_no = house_no;
        this.street = street;
        this.city = city;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getCon_no() {
        return con_no;
    }

    public void setCon_no(String con_no) {
        this.con_no = con_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHouse_no() {
        return house_no;
    }

    public void setHouse_no(String house_no) {
        this.house_no = house_no;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
