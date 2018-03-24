package com.example.nasrf.eyecare.User_Package;

/**
 * Created by nasrf on 23/02/2018.
 */


/*********************************************/
/*                                          */
/*  This class takes the user information  */
/*  and store it in share by refrence     */
/*                                       */
/****************************************/

import android.content.Context;
import android.content.SharedPreferences;

import com.example.nasrf.eyecare.R;



public class User {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNo;
    private String country;
    private String city;
    private String language;
    private String governorate;
    private String password;
    private Context context;
    private SharedPreferences userData;
    private SharedPreferences.Editor editor;

    public User(Context context) {
        this.context = context;
        this.firstName = null;
        this.lastName = null;
        this.emailAddress = null;
        this.phoneNo = null;
        this.country = null;
        this.city = null;
        this.language = null;
        this.governorate = null;
        this.password = null;

        setSharedPrefrence();
    }

    public User(Context context, String firstName, String lastName,
                String emailAddress, String phoneNo, String country, String city, String language , String governorate, String password) {
        this.context = context;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNo = phoneNo;
        this.country = country;
        this.city = city;
        this.language = language;
        this.governorate = governorate;
        this.password = password;

        setSharedPrefrence();
    }

    //Getter and Setter


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        editor.putString("Key_Pass",password);
        editor.apply();
        editor.commit();
    }

    public String getFirstName() {
        return userData.getString("Key_FirstName",null);
    }

    public String getGovernorate() {
        return userData.getString("Key_Gov",null);
    }

    public void setGovernorate(String governorate) {
        this.governorate = governorate;
        editor.putString("Key_Gov",governorate);
        editor.apply();
        editor.commit();
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
        editor.putString("Key_FirstName",firstName);
        editor.apply();
        editor.commit();
    }

    public String getLastName() {
        return userData.getString("Key_LastName",null);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        editor.putString("Key_LastName",lastName);
        editor.apply();
        editor.commit();
    }

    public String getEmailAddress() {
        return userData.getString("Key_Email",null);
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        editor.putString("Key_Email",emailAddress);
        editor.apply();
        editor.commit();
    }

    public String getPhoneNo() {
        return userData.getString("Key_Phone",null);
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
        editor.putString("Key_Phone",phoneNo);
        editor.apply();
        editor.commit();
    }

    public String getCountry() {
        return userData.getString("Key_Country",null);
    }

    public void setCountry(String country) {
        this.country = country;
        editor.putString("Key_Country",country);
        editor.apply();
        editor.commit();
    }

    public String getCity() {
        return userData.getString("Key_City",null);
    }

    public void setCity(String city) {
        this.city = city;
        editor.putString("Key_City",city);
        editor.apply();
        editor.commit();
    }

    public String getLanguage() {
        return userData.getString("Key_Language",null);
    }

    public void setLanguage(String language) {
        this.language = language;
        setSharedPrefrence();
        this.language = language;
        editor.putString("Key_Language",language);
        editor.apply();
        editor.commit();
    }


    private void setSharedPrefrence() {
        //this method initializes the SharedPrefrence
        //it called only one time from the set language
        userData = context.getSharedPreferences(context.getString(R.string.SP_Name),context.MODE_PRIVATE);
        editor = userData.edit();
    }

    public void LogedIN(boolean in){
        if(in == true){
            editor.putBoolean("Key_Registered",true);
            editor.apply();
            editor.commit();
        }
        else{
            editor.putBoolean("Key_Registered",false);
            editor.apply();
            editor.commit();
        }
    }

    public void LogOut(){
        setSharedPrefrence();
        editor.clear();
    }
}
