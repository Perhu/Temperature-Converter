package com.example.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.temperatureconverter.controller.ButtonController;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    //creating a controller
    private ButtonController btnControl;
    //Getting the View
    public View getView(){
        return findViewById(android.R.id.content);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Linking the controller
        this.btnControl=new ButtonController(this);
    }
//  when opening the application after being minimized
    @Override
    protected void onResume() {
        super.onResume();
        //reset the values
        btnControl.buttonResetAction();
    }
    //Calling the controller functions from the Main
    public void buttonCalculateAction(View view) {
        btnControl.buttonCalculateAction();
    }
    public void buttonResetAction(View view) {
        btnControl.buttonResetAction();
    }
}