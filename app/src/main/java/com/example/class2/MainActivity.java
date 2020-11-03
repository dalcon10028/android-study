package com.example.class2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button Btn_Layout, Btn_File;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn_Layout = findViewById(R.id.btn_Layout);
        Btn_File = findViewById(R.id.btn_File);

        Btn_Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLayout = new Intent(MainActivity.this, LayoutActivity.class);
                startActivity(intentLayout);
            }
        });

        Btn_File.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFile = new Intent(MainActivity.this, FileCtrlActivity.class);
                startActivity(intentFile);
            }
        });


    }
}