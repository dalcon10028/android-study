package com.example.class2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button Btn_Layout, Btn_File, Btn_SubIntent, Btn_DrawCtrl;
    EditText Et_SubIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn_Layout = findViewById(R.id.btn_Layout);
        Btn_File = findViewById(R.id.btn_File);
        Btn_SubIntent = findViewById(R.id.btn_SubIntent);
        Btn_DrawCtrl = findViewById(R.id.btn_drawTest);
        Et_SubIntent = findViewById(R.id.et_SubIntent);


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

        Btn_SubIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sSendStr = Et_SubIntent.getText().toString().trim();
                // 인텐트 생성
                Intent intentFile = new Intent(MainActivity.this, SubIntentActivity.class);
                // 인자 담기
                intentFile.putExtra("mMytext", sSendStr);

                startActivity(intentFile);
            }
        });

        Btn_DrawCtrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFile = new Intent(MainActivity.this, DrawCtrlActivity.class);
                startActivity(intentFile);
            }
        });
    }
}