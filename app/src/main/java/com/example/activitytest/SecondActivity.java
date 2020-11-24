package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
//    private EditText editText_1;
//    private EditText editText_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button button = (Button) findViewById(R.id.button_2);
        ImageButton imageButton = (ImageButton) findViewById(R.id.imagebutton_sina);//新浪登录
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imagebutton_tencent);//腾讯登录
        RadioButton radioButton = (RadioButton) findViewById(R.id.radiobutton1);        //Radiobutton
        button.setOnClickListener(new View.OnClickListener() {                    //注册
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SecondActivity.this, ForthActivity.class);
                startActivity(intent);
            }
        });
        Button button1 = (Button) findViewById(R.id.button_4);
        button1.setOnClickListener(new View.OnClickListener() {               //登录
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {           //新浪
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "新浪登录", Toast.LENGTH_SHORT).show();
            }
        });
        imageButton1.setOnClickListener(new View.OnClickListener() {          //腾讯
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "腾讯微博登录", Toast.LENGTH_SHORT).show();
            }
        });
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "Agree", Toast.LENGTH_SHORT).show();
            }
        });

    }
}