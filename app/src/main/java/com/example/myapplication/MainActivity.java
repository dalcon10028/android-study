package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    CheckBox ck_phone, ck_notebook;
    EditText et_phone, et_notebook;
    RadioGroup rg;
    RadioButton rd_card, rd_cash, rd_toss;
    Button bt_submit, bt_reset;
    TextView tv_phone, tv_notebook, tv_sum, tv_choice, tv_bank, tv_timestamp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ck_phone = findViewById(R.id.ck_phone);
        ck_notebook = findViewById(R.id.ck_notebook);
        et_phone = findViewById(R.id.et_phone);
        et_notebook = findViewById(R.id.et_notebook);
        rg = findViewById(R.id.radioG);
        rd_card = findViewById(R.id.rd_card);
        rd_cash = findViewById(R.id.rd_cash);
        rd_toss = findViewById(R.id.rd_toss);

        bt_submit = findViewById(R.id.btn_submit);
        bt_reset = findViewById(R.id.btn_reset);

        tv_phone = findViewById(R.id.tv_phone);
        tv_notebook = findViewById(R.id.tv_notebook);
        tv_sum = findViewById(R.id.tv_sum);
        tv_choice = findViewById(R.id.tv_choice);
        tv_bank = findViewById(R.id.tv_bank);
        tv_timestamp = findViewById(R.id.tv_timestamp);

        bt_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ck_phone.setChecked(false);
                ck_notebook.setChecked(false);
                et_phone.setText("핸드폰 수량 입력");
                et_notebook.setText("노트북 수량 입력");
                rd_card.setChecked(false);
                rd_cash.setChecked(false);
                rd_toss.setChecked(false);
                tv_phone.setText("핸드폰: ");
                tv_notebook.setText("노트북: ");
                tv_sum.setText("결제금액: ");
                tv_choice.setText("결제방법: ");
            }
        });
        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int phoneCount=0, notebookCount=0;
                int sum=0;
                int choice=-1; // 0 카드 1 현금 2 계좌이체 -1 미선택
                try {
                    if(ck_phone.isChecked())
                        phoneCount = Integer.parseInt(et_phone.getText().toString());
                    if(ck_notebook.isChecked())
                        notebookCount = Integer.parseInt(et_notebook.getText().toString());
                    if(!ck_phone.isChecked() && !ck_notebook.isChecked())
                        Toast.makeText(getApplicationContext(), "체크박스를 체크해주세요", Toast.LENGTH_LONG).show();
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "숫자를 입력해주세요", Toast.LENGTH_LONG).show();
                }
                if(rd_card.isChecked())
                    choice = 0;
                else if(rd_cash.isChecked())
                    choice = 1;
                else if(rd_cash.isChecked())
                    choice = 2;

                sum = phoneCount*2000+notebookCount*3000;
                tv_phone.setText("핸드폰: "+phoneCount+" 개");
                tv_notebook.setText("노트북: "+notebookCount+" 개");
                tv_sum.setText("결제금액: "+sum+" 원");
                switch (choice){
                    case 0:
                        tv_choice.setText("결제방법: 카드");
                        break;
                    case 1:
                        tv_choice.setText("결제방법: 현금");
                        break;
                    case 2:
                        tv_choice.setText("결제방법: 계좌이체");
                        break;
                }
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Calendar cal = Calendar.getInstance();
                tv_timestamp.setText(formatter.format(cal.getTime()));
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                tv_bank.setVisibility(View.INVISIBLE);
                if(i==R.id.rd_card) tv_choice.setText("결제방법: 카드");
                else if(i==R.id.rd_cash) tv_choice.setText("결제방법: 현금");
                else if(i==R.id.rd_toss) {
                    tv_choice.setText("결제방법: 계좌이체");
                    tv_bank.setVisibility(View.VISIBLE);
                }
            }
        });
        et_phone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(et_phone.getText().toString().equals("핸드폰 수량 입력")) {
                    et_phone.setText("");
                    et_phone.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                }
            }
        });

        et_notebook.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(et_notebook.getText().toString().equals("노트북 수량 입력")) {
                    et_notebook.setText("");
                    et_notebook.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                }
            }
        });
    }
}
