package com.example.dz_3_month_1_dz;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText email1;
    private EditText email2;
    private EditText email3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email1 = findViewById(R.id.email);
        email2 = findViewById(R.id.email2);
        email3 = findViewById(R.id.email3);
       Button open=findViewById(R.id.open);
open.setOnClickListener(v -> {
    sendMail();
});

    }
    public void sendMail(){
        String recipienList = email1.getText().toString();
        String [] recipients = recipienList.split(",");
        String theme = email2.getText().toString();
        String message = email3.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,theme);
        intent.putExtra(Intent.EXTRA_TEXT,message);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choose an email clienet"));

    }
}
