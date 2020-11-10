package com.example.class2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SubIntentActivity extends AppCompatActivity {


    Button btn_SubIntent_Submit;
    EditText et_SubIntent_Name;
    CheckBox cb_SubInent_Check;
    RadioGroup rg_SubIntent_Radio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subintent);

        // 인텐트 할당하기
        Intent MainIntent = getIntent();
        // 값 가져오기
        String mytxt =  MainIntent.getStringExtra("mMytext");
        // int는 두 번째 인자로 default값을 넣어줘야됨
        Toast.makeText(getApplicationContext(), mytxt, Toast.LENGTH_LONG).show();

        btn_SubIntent_Submit = findViewById(R.id.btn_SubIntent_Submit);
        et_SubIntent_Name = findViewById(R.id.et_SubIntent_Name);
        cb_SubInent_Check = findViewById(R.id.CB_SubIntent_Check);
        rg_SubIntent_Radio = findViewById(R.id.RG_SubIntent_Radio);

        btn_SubIntent_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 이름
                String name = et_SubIntent_Name.getText().toString().trim();
                // 일찍 끝내고 싶다
                boolean timeChecked = cb_SubInent_Check.isChecked();
                // 몇시간 1, 2, 3
                int timeRadio =  rg_SubIntent_Radio.getCheckedRadioButtonId();

                // 인텐트 생성
                Intent intentFile = new Intent(SubIntentActivity.this, SubReceiveActivity.class);
                // 인자 담기
                intentFile.putExtra("name", name);
                intentFile.putExtra("timeChecked", timeChecked);
                intentFile.putExtra("timeRadio", timeRadio);

                startActivity(intentFile);
            }
        });
    }


}