package com.ceyentra.restaurant;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DialogForm extends AppCompatActivity {

    private TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_form);

        test = findViewById(R.id.test);
        Intent intent = getIntent();
        String message = intent.getStringExtra("CAT");
        System.out.println(message+"Dialog form");
    }
}
