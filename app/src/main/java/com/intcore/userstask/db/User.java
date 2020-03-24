
package com.intcore.userstask.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.intcore.userstask.data.models.UserModel;

@Entity (tableName = "usersTable")
public class User {
    @PrimaryKey
    private int id;
    private String name;
    private String email;
    private String phone;
    private String username;
    private String website;


    private String city;
    private String street;
    private String suite;
    private String zipcode;


    private String lat;
    private String lng;
    
    private String bs;
    private String catchPhrase;
    private String companyName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public User convertFromSource(UserModel item) {
        this.id=item.getId();
        this.name=item.getName();
        this.bs=item.getCompany().getBs();
        this.city=item.getAddress().getCity();
        this.street=item.getAddress().getStreet();
        this.zipcode=item.getAddress().getZipcode();
        this.suite=item.getAddress().getSuite();
        this.email=item.getEmail();
        this.phone=item.getPhone();
        this.username=item.getUsername();
        this.catchPhrase=item.getCompany().getCatchPhrase();
        this.website=item.getWebsite();
        this.lat=item.getAddress().getGeo().getLat();
        this.lng=item.getAddress().getGeo().getLng();
        this.companyName=item.getCompany().getName();
        return  this;
    }
    public String getCompleteAddress(){
        return this.city+"  "+this.street+"  "+this.suite;
    }
}
