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

public class AddExpense extends AppCompatActivity {
    DatabaseHelper mobileProjectDatabase;
    int GalleryImage = 0;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);


        long date = System.currentTimeMillis();
        EditText dateText = (EditText)findViewById(R.id.dateText);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        String dateString = dateFormat.format(date);
        dateText.setText(dateString);

        mobileProjectDatabase = new DatabaseHelper(this);
        final EditText expenseAmount = (EditText)findViewById(R.id.amountText);
        final EditText expenseDate = (EditText)findViewById(R.id.dateText);
        final EditText expenseNote = (EditText)findViewById(R.id.noteText);
        final ImageButton expensePhoto = (ImageButton)findViewById(R.id.addPhotoButton);
        final Spinner expenseCategory = (Spinner)findViewById(R.id.categorySpinner);
        final CheckBox expensiveRepeat = (CheckBox) findViewById(R.id.monthlyCheckbox);
        final Button addExpenseBtn = (Button)findViewById(R.id.addExpense);



        addExpenseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount = expenseAmount.getText().toString();
                String date = expenseDate.getText().toString();
                String note = expenseNote.getText().toString();
                String category = expenseCategory.getSelectedItem().toString();
                // Boolean repeat = expensiveRepeat.isChecked();
                if (!amount.matches("") && !note.matches("")) {
                    ArrayList<String> list = new ArrayList<String>();
                    list.add(category);
                    list.add(amount);
                    list.add(date);
                    list.add(note);

                boolean isAdded = mobileProjectDatabase.addRec("bills", list);

                if (isAdded == true) {
                    expenseAmount.setText("");
                    expenseNote.setText("");
                    Toast.makeText(AddExpense.this, "Values Added", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(AddExpense.this, Bills.class));
                } else {
                    Toast.makeText(AddExpense.this, "Values Not Added", Toast.LENGTH_LONG).show();
                }
               }
                else{
                    Toast.makeText(AddExpense.this, "The Values Amount and Note Can Not Be Empty ", Toast.LENGTH_LONG).show();
                }

            }
        });

        expensePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
