package com.example.SekrabCurrencyTracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.budiyev.android.codescanner.ScanMode;
import com.google.zxing.Result;

import java.util.ArrayList;

public class Add extends AppCompatActivity {

    CodeScannerView ViewScanner;
    CodeScanner Scanner;
    EditText EdScannerText, EdDescAddCurrency, EdAmountAddCurrency;
    Button BtnAddCurrency;
    ListView ListHistory;
    TextView TxtvCurrency;

    ArrayList<String> Items;
    ArrayAdapter<String> Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        EdScannerText = findViewById(R.id.EdScannerText);
        ViewScanner = findViewById(R.id.scanner_view);
        BtnAddCurrency = findViewById(R.id.BtnAddCurrency);
        EdDescAddCurrency = findViewById(R.id.EdDescAddCurrency);
        EdAmountAddCurrency = findViewById(R.id.EdAmountAddCurrency);

        ListHistory = findViewById(R.id.ListHistory);


        Scanner = new CodeScanner(this, ViewScanner);
        Scanner.setCamera(CodeScanner.CAMERA_BACK);
        Scanner.setFormats(CodeScanner.ALL_FORMATS);
        Scanner.setScanMode(ScanMode.CONTINUOUS);
        Scanner.setAutoFocusEnabled(true);
        Scanner.setFlashEnabled(false);
        Scanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull Result result) {
                EdScannerText.setText(result.getText().toString());
            }
        });

        Adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1, Items);


        BtnAddCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = EdDescAddCurrency.getText().toString();
                String text2 = EdAmountAddCurrency.getText().toString();
                if (text1 == null || text1.length() == 0 ){
                    Toast.makeText(Add.this, "Enter Description.",
                            Toast.LENGTH_LONG).show();
                }
                else {

//                    addItem(text1);
                    Toast.makeText(Add.this, "Added",
                            Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Add.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    public void addItem(String item){
        Items.add(item);
        ListHistory.setAdapter(Adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Scanner.startPreview();
    }

    @Override
    protected void onPause() {
        Scanner.releaseResources();
        super.onPause();
    }
}