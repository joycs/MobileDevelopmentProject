package com.example.joy.mobiledevelopmentproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.text.SimpleDateFormat;

public class AddIncome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);

        long date = System.currentTimeMillis();
        EditText dateIncomeText = (EditText)findViewById(R.id.dateTextIncome);
        SimpleDateFormat dateIncomeFormat = new SimpleDateFormat("MMM MM dd, yyyy");
        String dateIncomeString = dateIncomeFormat.format(date);
        dateIncomeText.setText(dateIncomeString);



    }
}
