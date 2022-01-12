package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class AddPerson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Genders, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                TextView firstName = (TextView) findViewById(R.id.FirstNameInput);
                String firstNameText = firstName.getText().toString();
                TextView lastName = (TextView) findViewById(R.id.LastNameInput);
                String lastNameText = lastName.getText().toString();
                TextView age = (TextView) findViewById(R.id.AgeInput);
                String ageText = age.getText().toString();
                i.putExtra("FirstName", firstNameText);
                i.putExtra("LastName", lastNameText);
                i.putExtra("Age", ageText);
                Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
                String gender = mySpinner.getSelectedItem().toString();
                i.putExtra("Gender", gender);
                setResult(Activity.RESULT_OK, i);
                finish();

            }
        });
        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);
                finish();

            }
        });
    }
}