package com.example.nasrf.eyecare.SigningUp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.nasrf.eyecare.MainActivity;
import com.example.nasrf.eyecare.R;
import com.example.nasrf.eyecare.User_Package.User;

public class CompleteRegActivity extends AppCompatActivity {

    private EditText etFirstName, etLastName, etPhone, etEmail,etPass,etAgainPass;
    private User user;
    private Intent prev , toMain;   //"prev" gets the data from previous activity
    private String userLan, userCountry, userGov, userCity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_reg);
        initializer();
    }

    //*************************************//
    //     Initializing variables         //
    //***********************************//
    private void initializer(){
        //edit texts
        etFirstName = findViewById(R.id.et_first_name);
        etLastName = findViewById(R.id.et_last_name);
        etPhone = findViewById(R.id.et_phone);
        etEmail = findViewById(R.id.et_email);
        etPass = findViewById(R.id.et_password);
        etAgainPass = findViewById(R.id.et_renter_pass);

        //intents
        prev = getIntent();
        userLan = prev.getStringExtra("language");
        userCountry = prev.getStringExtra("country");
        userGov = prev.getStringExtra("gov");
        userCity = prev.getStringExtra("city");


        //user class
        user = new User(this);

    }

    //*************************************//
    //     user finished Registering      //
    //***********************************//
    public void btnDoneReg(View view) {

        //always start filling the user object with language and end filling with email
        toMain = new Intent(CompleteRegActivity.this,MainActivity.class);
        if(CheckFields() == true){
            user.setLanguage(userLan);
            user.setCountry(userCountry);
            user.setGovernorate(userGov);
            user.setCity(userCity);
            user.setFirstName(etFirstName.getText().toString());
            user.setLastName(etLastName.getText().toString());
            user.setPhoneNo(etPhone.getText().toString());
            user.setPassword(etPass.getText().toString());
            user.setEmailAddress(etEmail.getText().toString());
            user.LogedIN(true);
            startActivity(toMain);
        }

    }

    private boolean CheckFields(){
        String phone = etPhone.getText().toString();
        String pass, passAgain;
        pass = etPass.getText().toString();
        passAgain = etAgainPass.getText().toString();
        if(phone.length() > 11 || phone.length() < 11){
            Toast.makeText(this, getString(R.string.phone_format), Toast.LENGTH_SHORT).show();
            etPhone.setTextColor(getResources().getColor(R.color.wrong));
            return false;
        }
        
        else if(etFirstName.getText().toString() == null ||
                etLastName.getText().toString() == null ||
                etPhone.getText().toString() == null ||
                etEmail.getText().toString() == null ||
                etPass.getText().toString() == null ||
                etAgainPass.getText().toString() == null){
            Toast.makeText(this, getString(R.string.check_fields), Toast.LENGTH_SHORT).show();
            return false;
        }

        else if(pass == passAgain){
            etPass.setTextColor(getResources().getColor(R.color.wrong));
            etPass.setTextColor(getResources().getColor(R.color.wrong));
            Toast.makeText(this, getString(R.string.pass_not_match), Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }
    } // end of check fields
}
