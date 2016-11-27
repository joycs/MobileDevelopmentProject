package com.example.joy.mobiledevelopmentproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AddIncome extends AppCompatActivity {

    int GalleryImage = 0;
    DatabaseHelper mobileProjectDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);

        long date = System.currentTimeMillis();
        EditText dateIncomeText = (EditText)findViewById(R.id.dateTextIncome);
        SimpleDateFormat dateIncomeFormat = new SimpleDateFormat("MMM dd, yyyy");
        String dateIncomeString = dateIncomeFormat.format(date);
        dateIncomeText.setText(dateIncomeString);

        mobileProjectDatabase = new DatabaseHelper(this);
        final EditText dateIncome = (EditText)findViewById(R.id.dateTextIncome);
        final EditText amountIncome = (EditText)findViewById(R.id.incomeAmount);
        final EditText noteIncome = (EditText)findViewById(R.id.noteDetailsIncome);
        final Spinner incomeCategory = (Spinner)findViewById(R.id.catergorySpinnerIncome);
        CheckBox incomeCheckBox = (CheckBox)findViewById(R.id.repeatMonthlyIncome);
        ImageButton photoIncome = (ImageButton)findViewById(R.id.addPhotoIncome);
        Button addIncome = (Button)findViewById(R.id.addIncomeButton);

        addIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String amount = amountIncome.getText().toString();
                String date = dateIncome.getText().toString();
                String note = noteIncome.getText().toString();
                String category = incomeCategory.getSelectedItem().toString();
                // Boolean repeat = expensiveRepeat.isChecked();

                if(!amount.matches("") && !note.matches("")) {
                    ArrayList<String> incomeList = new ArrayList<String>();
                    incomeList.add(category);
                    incomeList.add(amount);
                    incomeList.add(date);
                    incomeList.add(note);

                    mobileProjectDatabase.createTable("James");

                    boolean isAdded = mobileProjectDatabase.addRec("James", incomeList);

                    if (isAdded) {
                        amountIncome.setText("");
                        noteIncome.setText("");
                        Toast.makeText(AddIncome.this, "Values Added", Toast.LENGTH_LONG).show();


                    } else {
                        Toast.makeText(AddIncome.this, "Values Not Added", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(AddIncome.this, "The Values Amount and Note Can Not Be Empty ", Toast.LENGTH_LONG).show();
                }


            }
        });




        photoIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(galleryIntent, GalleryImage);

                }
                catch (Exception e) {}
            }
        });



    }
}
