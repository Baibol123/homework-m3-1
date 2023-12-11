package com.example.homework_m2_6;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private EditText editTextText;
    private EditText editTextText2;
    private EditText editTextText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextText = findViewById(R.id.editTextText);
        editTextText2 = findViewById(R.id.editTextText2);
        editTextText3 = findViewById(R.id.editTextText3);
    }

    public void buttonSend(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{editTextText.getText().toString()});
        intent.putExtra(Intent.EXTRA_SUBJECT, editTextText2.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT, editTextText3.getText().toString());
        startActivity(intent);
    }

    public void onNextButtonClick(View view) {
        finish();
    }
}