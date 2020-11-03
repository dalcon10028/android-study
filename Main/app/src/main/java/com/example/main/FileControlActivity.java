package com.example.main;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileControlActivity extends AppCompatActivity {
    Button btn_writeFile, btn_readFile;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filecontrol);

        btn_writeFile = findViewById(R.id.btn_writeFile);
        btn_readFile = findViewById(R.id.btn_readFile);

        btn_writeFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileOutputStream MyFile = openFileOutput("UserFile.txt", Context.MODE_PRIVATE);
                    String sUser = "yeon1028";
                    MyFile.write(sUser.getBytes(),0,sUser.length());
                    MyFile.close();
                    Toast.makeText(getApplicationContext(),"UserFile.txt OK", Toast.LENGTH_LONG).show();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
        btn_readFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream Myfile = openFileInput("UserFile.txt");
                    byte[] data = new byte[Myfile.available()];
                    while (Myfile.read(data)!=-1){}
                    Myfile.close();
                    Toast.makeText(getApplicationContext(), new String(data), Toast.LENGTH_LONG).show();

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }

}
