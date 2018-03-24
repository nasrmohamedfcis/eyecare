package com.example.nasrf.eyecare.LOGIN;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nasrf.eyecare.MainActivity;
import com.example.nasrf.eyecare.R;
import com.example.nasrf.eyecare.SigningUp.SignupActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPass;
    private SharedPreferences userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        userData = getSharedPreferences(getString(R.string.SP_Name),MODE_PRIVATE);
        boolean logged = userData.getBoolean("Key_Registered",false);

        super.onCreate(savedInstanceState);

        //**************************************//
        // checking whether the user is logged //
        //************************************//
        if( logged == true){
            Intent main = new Intent(this,MainActivity.class);
            startActivity(main);
        }
        else {
            setContentView(R.layout.activity_login);
            initializer();
        }

    }


    //****************************//
    //    Initializing Data      //
    //**************************//
    private void initializer(){
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
    }


    //****************************//
    //       User Login          //
    //**************************//
    public void Login(View view) {
        // in this function it check the fields
        // and check if the email and pass is valid
        String pass = etPass.getText().toString();
        String email = etEmail.getText().toString();
        if(email == null || pass == null){
            Toast.makeText(this, getString(R.string.email_pass_null), Toast.LENGTH_SHORT).show();
        }
        else{
            CheckCredintials(email,pass);
        }
    }

    //************************************//
    //  Check user Credintials to Login  //
    //**********************************//
    private void CheckCredintials(String email, String pass) {

    }

    //****************************//
    //       User Signup         //
    //**************************//
    public void Signup(View view) {
        Intent intent = new Intent(getApplicationContext(),SignupActivity.class);
        startActivity(intent);
    }

    //****************************//
    //   User Forget Password    //
    //**************************//
    public void ForgetPassword(View view) {
    }


}
