package com.example.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_layoutTest, btn_fileControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_layoutTest = findViewById(R.id.btn_layoutTest);
        btn_fileControl = findViewById(R.id.btn_fileControl);

        btn_layoutTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LayoutActivity.class);
                startActivity(intent);
            }
        });

        btn_fileControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FileControlActivity.class);
                startActivity(intent);
            }
        });

    }
}