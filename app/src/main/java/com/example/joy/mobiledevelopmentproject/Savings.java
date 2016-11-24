package com.example.joy.mobiledevelopmentproject;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Savings extends AppCompatActivity {
    DatabaseHelper dbh;
    ArrayList<String> savingList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings);

        dbh = new DatabaseHelper(this);
        ListView lv = (ListView)findViewById(R.id.listView4);
        Button btnAB = (Button)findViewById(R.id.btnAddSavings);

        Cursor r = dbh.viewRec("savings");
        StringBuilder str = new StringBuilder();
        if(r.getCount()>0){
            while(r.moveToNext()){
                str.append(r.getString(1) + "\n");
                str.append(r.getString(2) + "/Month \n");
                str.append(r.getString(3) + " of each month \n");
            }
            savingList.add(str.toString());
        }else{
            Toast.makeText(Savings.this,"No record to display",Toast.LENGTH_LONG).show();
        }

        ArrayAdapter<String> aa = new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1, savingList);
        lv.setAdapter(aa);

        btnAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Savings.this,AddIncome.class));
            }
        });

    }
}
