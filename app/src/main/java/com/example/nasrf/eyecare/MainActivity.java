package com.example.nasrf.eyecare;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.nasrf.eyecare.ColorBlindTest.ColorTestActivity;
import com.example.nasrf.eyecare.LOGIN.LoginActivity;
import com.example.nasrf.eyecare.User_Package.User;
import com.example.nasrf.eyecare.User_Settings.SettingsActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = new User(this);
        //ChangeLanguage(user.getLanguage());
        setContentView(R.layout.activity_main);

        InitNavController();

    }

    /***********************************************/
    /***** Initializing The Navigation Drawer *****/
    /***********************************************/
    private void InitNavController(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //********************************//
    // Start the eye test Activity   //
    //******************************//
    public void StartEyeTest(View view) {
        Toast.makeText(this, "Not Implemented Yet.", Toast.LENGTH_SHORT).show();
    }


    //********************************//
    // Start the color test Activity //
    //******************************//
    public void StartColorTest(View view) {
        Intent intent = new Intent(this, ColorTestActivity.class);
        startActivity(intent);
    }

    //***************************************************//
    // prevent from going back to registration Activity  //
    //      instead it returns to home screen            //
    //***************************************************//
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_help) {

        }
        else if (id == R.id.nav_about) {

        }
        else if (id == R.id.nav_settings) {
            Intent toSettings = new Intent(this, SettingsActivity.class);
            startActivity(toSettings);
        }
        else if (id == R.id.nav_logout) {
            LogOut();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void LogOut(){
        user.LogedIN(false);
        Intent toLogIn = new Intent(this, LoginActivity.class);
        startActivity(toLogIn);
    }

    //*********************************//
    // Change the Language of the app //
    //*******************************//
    private void ChangeLanguage(String lang){
        if(lang == Locale.getDefault().toString() || lang == null){
            this.setContentView(R.layout.activity_main);
        }
        else {
            String languageToLoad = lang; // your language
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());
            this.setContentView(R.layout.activity_main);
            InitNavController();
        }
    }

}
