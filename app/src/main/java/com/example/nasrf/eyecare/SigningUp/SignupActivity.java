package com.example.nasrf.eyecare.SigningUp;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.nasrf.eyecare.R;

import java.util.Locale;


public class SignupActivity extends AppCompatActivity {


    private Spinner languageSpinner, countrySpinner, govSpinner, citySpinner;
    private String userLang, userCountry, userGov, userCity;
    private Button btnDoneLang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initializer();

    }


    //*********************************//
    //    Initialize the variables    //
    //*******************************//
    private void initializer() {
        //spinners
        languageSpinner = findViewById(R.id.language_spinner);
        countrySpinner = findViewById(R.id.country_spinner);
        govSpinner = findViewById(R.id.gov_spinner);
        citySpinner = findViewById(R.id.city_spinner);
        btnDoneLang = findViewById(R.id.btnDoneLanguage);

        //setting the spinners
        setLanSpinner();            // language spinner
        setCountrySpinner();       // country spinner
        setGovernorateSpinner();  // Governorate spinner
        setCitySpinner();        // city spinner
    }


    //*********************************//
    //    Set the Language Spinner    //
    //*******************************//
    private void setLanSpinner(){
        //initializing the language spinner with dummy data
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.language_array,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapter);

        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        userLang = "en";
                        btnDoneLang.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ChangeLanguage("en");
                            }
                        });
                        break;

                    case 1:
                        userLang = "ar";
                        btnDoneLang.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ChangeLanguage("en");   //for testing
                            }
                        });
                        break;

                    case 2:
                        userLang = "fr";
                        btnDoneLang.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ChangeLanguage("fr");  //for testing
                            }
                        });
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                    userLang = Locale.getDefault().toString();
            }
        });
    }


    //*********************************//
    //    Set the Country Spinner     //
    //*******************************//
    private void setCountrySpinner(){
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.country_array,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(adapter);

        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0 :
                        userCountry = "Egypt";
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                userCountry = "Egypt";            }
        });
    }


    //*********************************//
    //  Set the Governorate Spinner   //
    //*******************************//
    private void setGovernorateSpinner(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.Governorate_array,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        govSpinner.setAdapter(adapter);

        govSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        userGov = "Cairo";
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                userGov = "Cairo";

            }
        });

    }


    //*********************************//
    //      Set the City Spinner      //
    //*******************************//
    private void setCitySpinner(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.city_array,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(adapter);

        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        userCity = "Giza";
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                userCity="Giza";
            }
        });
    }


    //*********************************//
    // Change the Language of the app //
    //*******************************//
    private void ChangeLanguage(String lang){

        if(lang == Locale.getDefault().toString()){

        }
        else {
            String languageToLoad = lang; // your language
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());
            this.setContentView(R.layout.activity_signup);
            initializer();
        }
    }


    //*************************************//
    // user finished Regional Registering //
    //***********************************//
    public void RegCompleted(View view) {
        Intent intent = new Intent(getApplicationContext(),CompleteRegActivity.class);
        intent.putExtra("language",userLang);
        intent.putExtra("country",userCountry);
        intent.putExtra("gov",userGov);
        intent.putExtra("city",userCity);
        //Toast.makeText(this, userLang + " " + userCountry +" "+userGov+" "+userCity, Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }


}
