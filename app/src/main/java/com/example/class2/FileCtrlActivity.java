package com.example.class2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCtrlActivity extends AppCompatActivity {

    Button Btn_FileWrite, Btn_FileRead, Btn_Save, Btn_Login;
    EditText Et_UserID, Et_UserPWD, Et_LoginID, Et_LoginPWD;
    int IDCount = 0;
    int PWDCount = 0;

    public String setTenString(String sInput){
        String sResult = sInput;
        int nCount = 10 - sInput.length();

        for(int i = 0; i < nCount; i++ ){
            sResult = sResult + " ";
        }

        return sResult;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_ctrl);

        Btn_FileWrite = findViewById(R.id.btn_FileWrite);
        Btn_FileRead = findViewById(R.id.btn_FileRead);
        Btn_Save = findViewById(R.id.btn_Save);
        Btn_Login = findViewById(R.id.btn_Login);
        Et_UserID = findViewById(R.id.et_UserID);
        Et_UserPWD = findViewById(R.id.et_UserPWD);
        Et_LoginID = findViewById(R.id.et_LoginID);
        Et_LoginPWD = findViewById(R.id.et_LoginPWD);

        Btn_FileWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileOutputStream FoMyFile = openFileOutput("UserFile.txt", Context.MODE_PRIVATE);
                    String sUser = "candy143";
                    FoMyFile.write(sUser.getBytes(), 0, sUser.length());

                    String sPwd = "0000";
                    FoMyFile.write(sPwd.getBytes(), 0, sPwd.length());

                    FoMyFile.close();
                    Toast.makeText(getApplicationContext(), "UserFile.txt", Toast.LENGTH_SHORT).show();
                }

                catch (IOException e){

                }

            }
        });

        Btn_FileRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileInputStream FiMyFile = openFileInput("UserFile.txt");
                    byte[] baUser = new byte[8];
                    byte[] baPwd = new byte[4];
                    FiMyFile.read(baUser);
                    FiMyFile.read(baPwd);

                    String sRUSer = new String(baUser);
                    String sRPwd = new String(baPwd);

                    Toast.makeText(getApplicationContext(), sRUSer.trim(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), sRPwd.trim(), Toast.LENGTH_SHORT).show();
                    FiMyFile.close();
                }

                catch (IOException e){
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileOutputStream WritePI = openFileOutput("PI.txt", Context.MODE_PRIVATE);
                    if(Et_UserID.length() < 1){
                        Toast.makeText(getApplicationContext(), "아이디를 입력해 주세요.", Toast.LENGTH_SHORT).show();
                    }
                    else if(Et_UserPWD.length() < 1){
                        Toast.makeText(getApplicationContext(), "비밀번호를 입력해 주세요.", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if(Et_UserID.length() > 10) {
                            Toast.makeText(getApplicationContext(), "10자리 이하로 입력해 주세요.", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            String sUser = setTenString(Et_UserID.getText().toString());
                            WritePI.write(sUser.getBytes(), 0, sUser.length());
                            //IDCount = (int)sUser.length();
                        }

                        if(Et_UserPWD.length() > 10){
                            Toast.makeText(getApplicationContext(), "10자리 이하로 입력해 주세요.", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            String sPwd = setTenString(Et_UserPWD.getText().toString());
                            WritePI.write(sPwd.getBytes(), 0, sPwd.length());
                            //PWDCount = (int) sPwd.length();
                        }
                    }

                }
                catch (IOException e){
                }
            }
        });

        Btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileInputStream ReadPI = openFileInput("PI.txt");
                    byte[] baUserID = new byte[10];
                    byte[] baUserPWD = new byte[10];
                    ReadPI.read(baUserID);
                    ReadPI.read(baUserPWD);

                    String sRUserID = new String(baUserID);
                    String sRUserPwd = new String(baUserPWD);

                    if(Et_LoginID.length() < 1){
                        Toast.makeText(getApplicationContext(), "아이디를 입력해 주세요.", Toast.LENGTH_SHORT).show();
                    }
                    else if(Et_LoginPWD.length() < 1){
                        Toast.makeText(getApplicationContext(), "비밀번호를 입력해 주세요.", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if (Et_LoginID.getText().toString().equals(sRUserID.trim()) && Et_LoginPWD.getText().toString().equals(sRUserPwd.trim())) {
                            Toast.makeText(getApplicationContext(), "로그인에 성공했습니다.", Toast.LENGTH_SHORT).show();
                        } else if (Et_LoginID.getText().toString().equals(sRUserID.trim()) && !Et_LoginPWD.getText().toString().equals(sRUserPwd.trim())) {
                            Toast.makeText(getApplicationContext(), "비밀번호가 다릅니다.", Toast.LENGTH_SHORT).show();
                        } else if (!Et_LoginID.getText().toString().equals(sRUserID.trim()) && Et_LoginPWD.getText().toString().equals(sRUserPwd.trim())) {
                            Toast.makeText(getApplicationContext(), "아이디가 다릅니다.", Toast.LENGTH_SHORT).show();
                        } else if (!Et_LoginID.getText().toString().equals(sRUserID.trim()) && !Et_LoginPWD.getText().toString().equals(sRUserPwd.trim())) {
                            Toast.makeText(getApplicationContext(), "아이디와 비밀번호가 다릅니다.", Toast.LENGTH_SHORT).show();
                        }
                    }




                    ReadPI.close();
                }

                catch (IOException e){
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}