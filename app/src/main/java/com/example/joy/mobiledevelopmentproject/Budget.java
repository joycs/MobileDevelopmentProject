package com.example.joy.mobiledevelopmentproject;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Budget extends AppCompatActivity {
    DatabaseHelper dbh;
    ArrayList<String> billsList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        dbh = new DatabaseHelper(this);
        ListView lv = (ListView)findViewById(R.id.listView2);
        Button btnAB = (Button)findViewById(R.id.btnAddExpense);

        Cursor r = dbh.viewRec();
        StringBuilder str = new StringBuilder();
        if(r.getCount()>0){
            while(r.moveToNext()){
                str.append(r.getString(1) + "\n");
                str.append(r.getString(2) + "/Month \n");
                str.append(r.getString(3) + " of each month \n");
            }
            billsList.add(str.toString());
        }else{
            Toast.makeText(Budget.this,"No record to display",Toast.LENGTH_LONG).show();
        }

        btnAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(Budget.this,AddExpense.class);
                //startActivity(intent);
            }
        });
    }
}
