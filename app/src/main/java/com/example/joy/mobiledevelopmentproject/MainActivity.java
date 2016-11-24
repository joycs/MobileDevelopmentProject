package com.example.joy.mobiledevelopmentproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*ArrayList<String> temp = new ArrayList<String>();
        temp.add("1");
        temp.add("tw");
        temp.add("th");
        temp.add("fo");


        DatabaseHelper dbh;
        dbh = new DatabaseHelper(this);
        dbh.addRec("bills",temp);*/
        Button addBtn = (Button)findViewById(R.id.addButton);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddExpense.class));
            }
        });
        Button billsBtn = (Button)findViewById(R.id.billsButton);
        billsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Bills.class));
            }
        });

        Button budgetBtn = (Button)findViewById(R.id.budgetBtn);
        budgetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Budget.class));
            }
        });

        Button incomeBtn = (Button)findViewById(R.id.incomeBtn);
        incomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Income.class));
            }
        });

        Button savingsBtn = (Button)findViewById(R.id.savingsBtn);
        savingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Savings.class));
            }
        });
    }
}
