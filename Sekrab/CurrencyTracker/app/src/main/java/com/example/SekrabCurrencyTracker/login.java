package com.example.SekrabCurrencyTracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class login extends AppCompatActivity {

    Button BtnLogin;
    EditText EdNama;
    Spinner SpinnerFaksi;
    String[] Faksi = {"Sultana Al Turi A", "Democratic People of Mrisi", "New Republic of Merapi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        BtnLogin = findViewById(R.id.BtnLogin);
        EdNama = findViewById(R.id.EdNama);
        SpinnerFaksi = findViewById(R.id.SpinnerFaksi);


        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Faksi);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        SpinnerFaksi.setAdapter(aa);

        SpinnerFaksi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView selectedText = (TextView) parent.getChildAt(0);
                if (selectedText != null) {
                    selectedText.setTextColor(Color.BLACK);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        CheckUser();

    }

    private void CheckUser() {
        //Check user data in shared pref manager, if the data is exists then proceed to Main Activity

    }

    public void Login(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        //Pass Name and Faksi to Activity Main


        startActivity(intent);
    }
}