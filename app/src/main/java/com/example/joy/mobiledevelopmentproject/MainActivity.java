package com.example.joy.mobiledevelopmentproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        long date = System.currentTimeMillis();
        EditText dateText = (EditText)findViewById(R.id.dateText);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM MM dd, yyyy");
        String dateString = dateFormat.format(date);
        dateText.setText(dateString);



    }



}
