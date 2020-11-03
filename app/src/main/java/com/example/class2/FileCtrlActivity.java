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
    EditText Et_UserID, Et_UserPWD, Et_UserName,Et_LoginID, Et_LoginPWD;
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
        Et_UserName = findViewById(R.id.et_UserName);
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
                    FileOutputStream UsersFile = openFileOutput("Users.txt", Context.MODE_PRIVATE);

                    if(Et_UserID.getText().length()<1 || Et_UserPWD.getText().length()<1 || Et_UserName.getText().length()<1)
                        Toast.makeText(getApplicationContext(), "빈 칸을 모두 채워주세요!", Toast.LENGTH_LONG).show();
                    else {
                        if(Et_UserID.getText().length()>10)
                            Toast.makeText(getApplicationContext(), "아이디를 10자 이내로 입력해주세요!", Toast.LENGTH_LONG).show();
                        else if(Et_UserPWD.getText().length()>10)
                            Toast.makeText(getApplicationContext(), "패스워드를 10자 이내로 입력해주세요!", Toast.LENGTH_LONG).show();
                        else if( Et_UserName.getText().length()>10)
                            Toast.makeText(getApplicationContext(), "이름을 10자 이내로 입력해주세요!", Toast.LENGTH_LONG).show();
                        else {
                            // 아이디 등록
                            String sUser = Et_UserID.getText().toString() + ",";
                            UsersFile.write(sUser.getBytes(), 0, sUser.length());
                            // 비밀번호 등록
                            String sPwd = Et_UserPWD.getText().toString() + ",";
                            UsersFile.write(sPwd.getBytes(), 0, sPwd.length());
                            // 이름 등록
                            String sName = Et_UserName.getText().toString() + ",";
                            UsersFile.write(sName.getBytes(), 0, sName.length());

                            UsersFile.close();
                            Toast.makeText(getApplicationContext(), "회원 등록 완료", Toast.LENGTH_LONG).show();
                        }
                    }
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        });

        Btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileInputStream UsersFile = openFileInput("Users.txt");
                    byte[] user = new byte[33];
                    UsersFile.read(user);

                    String UserInfo[] = new String(user).split(",");
                    String UserId = UserInfo[0]; // 아이디
                    String UserPw = UserInfo[1]; // 비번
                    String UserName = UserInfo[2]; // 이름
                    // 아이디 비번 불일치
                    if(!UserId.equals(Et_LoginID.getText().toString()) && !UserPw.equals(Et_LoginPWD.getText().toString()))
                        Toast.makeText(getApplicationContext(), "아이디와 패스워드가 다릅니다.", Toast.LENGTH_SHORT).show();
                    else if(!UserId.equals(Et_LoginID.getText().toString()))
                        Toast.makeText(getApplicationContext(), "아이디가 다릅니다.", Toast.LENGTH_SHORT).show();
                    else if(!UserPw.equals(Et_LoginPWD.getText().toString()))
                        Toast.makeText(getApplicationContext(), "패스워드가 다릅니다.", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(), UserName+"님이 로그인 하셨습니다.", Toast.LENGTH_SHORT).show();
                    UsersFile.close();
                }

                catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}