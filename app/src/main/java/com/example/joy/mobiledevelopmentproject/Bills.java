package com.example.joy.mobiledevelopmentproject;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class Bills extends AppCompatActivity {
    DatabaseHelper dbh;
    ArrayList<String> billsList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);

        dbh = new DatabaseHelper(this);
        ListView lv = (ListView)findViewById(R.id.listView);

        //below run on startup of activity
        Cursor r = dbh.viewRec();
        StringBuilder str = new StringBuilder();
        if(r.getCount()>0){
            while(r.moveToNext()){
                str.append("ID: " + r.getString(0) + "\n");
                str.append("Fname: " + r.getString(1) + "\n");
                str.append("Lname: " + r.getString(2) + "\n");
                str.append("Phone: " + r.getString(3) + "\n");
            }
            lv.add.setText(str);
        }else{
            Toast.makeText(MainActivity.this,"No record to display",Toast.LENGTH_LONG).show();
        }

        Button btnAB = (Button)findViewById(R.id.btnAddBill);
    }
}
