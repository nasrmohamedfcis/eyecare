package com.example.nasrf.eyecare.User_Settings;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.nasrf.eyecare.R;
import com.example.nasrf.eyecare.User_Package.User;

import java.util.Locale;

public class SettingsActivity extends AppCompatActivity {

    private Spinner languageSpinner;
    private Button btnDoneLang;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = new User(this);
        ChangeLanguage(user.getLanguage());
        //setContentView(R.layout.activity_settings);
        Initializer();
    }

    private void Initializer(){

        languageSpinner = findViewById(R.id.change_language_spinner);
        btnDoneLang = findViewById(R.id.btnChangeLanguage);
        setLanSpinner();
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
                        user.setLanguage("en");
                        btnDoneLang.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ChangeLanguage("en");
                                //onBackPressed();
                            }
                        });
                        break;

                    case 1:
                        user.setLanguage("ar");
                        btnDoneLang.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ChangeLanguage("en");   //for testing
                                //onBackPressed();
                            }
                        });
                        break;

                    case 2:
                        user.setLanguage("en");
                        btnDoneLang.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ChangeLanguage("en");  //for testing
                                //onBackPressed();
                            }
                        });
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                user.setLanguage(Locale.getDefault().toString());
            }
        });
    }

    //*********************************//
    // Change the Language of the app //
    //*******************************//
    private void ChangeLanguage(String lang){
        if(lang == Locale.getDefault().toString() || lang == null){
            this.setContentView(R.layout.activity_settings);
        }
        else {
            String languageToLoad = lang; // your language
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());
            this.setContentView(R.layout.activity_settings);
            Initializer();
        }
    }
}
