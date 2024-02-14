package com.example.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

//  buffer variable that is used to monitor if Celsius is changed
    private double theCl=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//  when opening the application after being minimilzed
    @Override
    protected void onResume() {
        super.onResume();
        //reset the values
        buttonResetAction(findViewById(android.R.id.content));
    }
//    Getter for the Celsius field
    private TextInputEditText getFieldCel()
    {
        return (TextInputEditText) this.findViewById(R.id.NumberBoxCel);
    }
//    getter for fahrenheit field
    private TextInputEditText getFieldFh()
    {
        return (TextInputEditText) this.findViewById(R.id.NumberBoxFh);
    }
//    function to reset the values
    public void buttonResetAction(View view) {
        getFieldCel().setText("0");
        getFieldFh().setText("32");
    }
//function to calculate and set the values
    public void buttonCalculateAction(View view) {
        //parsing the values from String to double
        double cl=Double.parseDouble(String.valueOf(getFieldCel().getText()));
        double fh=Double.parseDouble(String.valueOf(getFieldFh().getText()));;
        /*
        the way i'm checking which field is changed is by comparing
        the buffer variable to the current value of Celsius.
        -in case Celsius is changed, Fahrenheit is calculated
        -in case Celsius is not changed, that could mean the FH was changed,
        therefore Celsius is calculated
        -in case neither is changed, there would be no change(except maybe making CL from int to double)
        -in case both are changed Celsius takes priority (it was not specified which one takes priority,
        "TextChangedListener" could've been used to check which field was changed last but )
        no such requirement was specified)
        */
        if(cl!=theCl){
            getFieldFh().setText(String.valueOf((cl * 1.8) + 32));
        }else {
            getFieldCel().setText(String.valueOf((fh-32)/1.8));
        }
        theCl=cl;
    }


}