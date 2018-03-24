package com.example.nasrf.eyecare.ColorBlindTest;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nasrf.eyecare.R;
import com.example.nasrf.eyecare.User_Package.User;

import java.util.Locale;

public class ColorTestActivity extends AppCompatActivity {


    /*****************************************************/
    //***************************************************//
    //    Image Palettes and the number they contain    //
    //*************************************************//
    //     *****     Start of Modeling    *****       //
    private Integer[] images = {R.drawable.i0,R.drawable.i1,R.drawable.i2,R.drawable.i3,R.drawable.i4,
            R.drawable.i5,R.drawable.i6,R.drawable.i7,R.drawable.i8,R.drawable.i9,R.drawable.i10,
            R.drawable.i11,R.drawable.i12};
    private String[] numbers = {"6","7","26","15","6","73","5","16","45","12","29","8","74"};
    //     *****     End of Modeling    *****       //
    /***********************************************/

    private User user;
    private EditText currentNum;
    private TextView explain;
    private Button btnCont;
    private ImageView currentViewNum;
    private static int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = new User(this);
        //ChangeLanguage(user.getLanguage());
        setContentView(R.layout.activity_color_test);
        initializer();
    }

    //**********************************//
    //  Initializing local variables  //
    //********************************//
    private void initializer() {
        currentViewNum = findViewById(R.id.iv_number);
        currentViewNum.setImageResource(images[currentIndex]);
        currentNum = findViewById(R.id.et_current_num);
        explain = findViewById(R.id.tv_explain);
        btnCont = findViewById(R.id.btn_continue);
    }


    //******************************//
    //   Continue Button Pressed   //
    //****************************//
    public void Continue(View view) {
        currentViewNum.setImageResource(images[currentIndex]);
        explain.setVisibility(View.GONE);
        currentNum.setVisibility(View.VISIBLE);
        currentNum.setText(null);
    }

    //**************************//
    //   Check the user answer //
    //************************//
    public void Validate(View view) {
        String num = currentNum.getText().toString();
        if(num == null){
            return;
        }
        else {
            CheckAnswer(num);
        }
    }

    //**************************//
    //    set The second pic   //
    //************************//
    private void CheckAnswer(String number) {

        /************************************/
        //         Test is Finished        //
        //  pop up a dialpge to the user  //
        /*********************************/
        if(currentIndex > 12){
            currentIndex = 0;
            AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R.string.finished))
                    .setMessage(getString(R.string.finished_text))
                    .setPositiveButton(R.string.done, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            onBackPressed();
                        }
                    }).show();
        }


        /************************************/
        //    validate the user's answer   //
        /*********************************/
        String exp;
        switch(currentIndex){
            case 0:
                if(number.equals(numbers[currentIndex])){
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.pic_num)+" "+numbers[currentIndex]+" "+getString(R.string.most_people);
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                else{
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.pic_num)+" "+numbers[currentIndex]+" "+getString(R.string.most_people);
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                break;

            case 1:
                if(number.equals(numbers[currentIndex])){
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.pic_num)+" "+numbers[currentIndex]+" "+getString(R.string.most_people);
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                else{
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.pic_num)+" "+numbers[currentIndex]+" "+getString(R.string.most_people);
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                break;

            case 2:
                if(number.equals(numbers[currentIndex])){
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.pic_num)+" "+numbers[currentIndex]+" "+getString(R.string.normal_people);
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                else{
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.pic_num)+" "+numbers[currentIndex]+" "+getString(R.string.red_people)+" "+"6 "+
                            getString(R.string.green_people)+" "+"2";
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                break;

            case 3:
                if(number.equals(numbers[currentIndex])){
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.pic_num)+" "+numbers[currentIndex]+" "+getString(R.string.normal_people);
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                else{
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.pic_num)+" "+numbers[currentIndex]+" "+getString(R.string.red_green_people)+" "+"17";
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                break;

            case 4:
                if(number.equals(numbers[currentIndex])){
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.pic_num)+" "+numbers[currentIndex]+" "+getString(R.string.normal_people);
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                else{
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.pic_num)+" "+numbers[currentIndex]+" "+getString(R.string.most_people);
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                break;

            case 5:
                if(number.equals(numbers[currentIndex])){
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.pic_num)+" "+numbers[currentIndex]+" "+getString(R.string.normal_people);
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                else{
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.pic_num)+" "+numbers[currentIndex]+" "+getString(R.string.most_people);
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                break;

            case 6:
                if(number.equals(numbers[currentIndex])){
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.pic_num)+" "+numbers[currentIndex]+" "+getString(R.string.normal_people);
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                else{
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.pic_num)+" "+numbers[currentIndex]+" "+getString(R.string.most_people);
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                break;

            case 7:
                if(number.equals(numbers[currentIndex])){
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.pic_num)+" "+numbers[currentIndex]+" "+getString(R.string.normal_people);
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                else{
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.pic_num)+" "+numbers[currentIndex]+" "+getString(R.string.most_people);
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                break;

            case 8:
                if(number.equals(numbers[currentIndex])){
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.pic_num)+" "+numbers[currentIndex]+" "+getString(R.string.normal_people);
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                else{
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.pic_num)+" "+numbers[currentIndex]+" "+getString(R.string.most_people);
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                break;

            case 9:
                if(number.equals(numbers[currentIndex])){
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.special_case);
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                else{
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.special_case);
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                break;

            case 10:
                if(number.equals(numbers[currentIndex])){
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.pic_num)+" "+numbers[currentIndex]+" "+getString(R.string.normal_people);
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                else{
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.pic_num)+" "+numbers[currentIndex]+" "+getString(R.string.if_see)+" "+"70 "+
                            getString(R.string.most_red_green)+" "+getString(R.string.total_color_blind);
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                break;

            case 11:
                if(number.equals(numbers[currentIndex])){
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.pic_num)+" "+numbers[currentIndex]+" "+getString(R.string.normal_people);
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                else{
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.pic_num)+" "+numbers[currentIndex]+" "+getString(R.string.if_see)+
                            " "+"3 "+getString(R.string.most_red_green)+" "+getString(R.string.total_color_blind);
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                break;

            case 12:
                if(number.equals(numbers[currentIndex])){
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.pic_num)+" "+numbers[currentIndex]+" "+getString(R.string.normal_people);
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                else{
                    btnCont.setEnabled(true);
                    currentNum.setVisibility(View.GONE);
                    exp = getString(R.string.pic_num)+" "+numbers[currentIndex]+" "+getString(R.string.if_see)+
                            " "+"21 "+getString(R.string.most_red_green)+" "+getString(R.string.total_color_blind);
                    explain.setText(exp);
                    explain.setVisibility(View.VISIBLE);
                }
                break;

            default:
                break;
        }

        currentIndex++;
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
            initializer();
        }
    }

}
