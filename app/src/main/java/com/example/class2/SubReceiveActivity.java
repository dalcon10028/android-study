package com.example.class2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SubReceiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subreceive);

        TextView tv_subreceive = findViewById(R.id.tv_subreceive);

        // 인텐트 할당하기
        Intent SubIntent = getIntent();
        // 값 가져오기
        String name = SubIntent.getStringExtra("name");
        boolean timeChecked = SubIntent.getBooleanExtra("timeChecked", false);
        int timeRadio = SubIntent.getIntExtra("timeRadio", 0);

        StringBuilder result = new StringBuilder();
        result.append(name+"는 ");
        switch (timeRadio){
            case 1: result.append("1시간 "); break;
            case 2: result.append("2시간 "); break;
            case 3: result.append("3시간 "); break;
        }
        result.append(timeChecked ? "일찍 끝내고 싶다." : "일찍 끝내고 싶지 않다.");
        tv_subreceive.setText(result);
    }
}