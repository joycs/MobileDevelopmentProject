package com.example.joy.mobiledevelopmentproject;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class Bills extends AppCompatActivity {
    DatabaseHelper dbh;
    ArrayList<String> billsList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);

        dbh = new DatabaseHelper(this);
        ListView lv = (ListView)findViewById(R.id.listView);
        Button btnAB = (Button)findViewById(R.id.btnAddBill);

        Cursor r = dbh.viewRec("bills");
        StringBuilder str = new StringBuilder();
        if(r.getCount()>0){
            while(r.moveToNext()){
                str.append(r.getString(1) + "\n");
                str.append(r.getString(2) + "/Month \n");
                str.append(r.getString(3) + " of each month \n");
            }
            billsList.add(str.toString());
        }else{
            Toast.makeText(Bills.this,"No record to display",Toast.LENGTH_LONG).show();
        }

        btnAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(Bills.this,AddExpense.class);
                //startActivity(intent);
            }
        });
    }
}
