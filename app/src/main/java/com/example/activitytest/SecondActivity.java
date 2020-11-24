package com.example.activitytest;

import androidx.appcompat.app.ActionBar;
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

    private EditText accountEdit;
    private EditText passwordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        accountEdit = (EditText) findViewById(R.id.edit_account);
        passwordEdit = (EditText) findViewById(R.id.edit_password);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        Button button = (Button) findViewById(R.id.sigh_up);
        ImageButton imageButton = (ImageButton) findViewById(R.id.imagebutton_sina);//新浪登录
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imagebutton_tencent);//腾讯登录
        button.setOnClickListener(new View.OnClickListener() {                    //注册
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SecondActivity.this, ForthActivity.class);
                startActivity(intent);
            }
        });
        Button button1 = (Button) findViewById(R.id.sigh_in);
        button1.setOnClickListener(new View.OnClickListener() {               //登录
            @Override
            public void onClick(View v) {
                //登录逻辑
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if (account.equals("123456") && password.equals("123456")) {
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SecondActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                }
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

    }
}