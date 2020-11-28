package com.example.activitytest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ForthActivity extends AppCompatActivity {
    private EditText account;
    private EditText password;
    private EditText password0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);
        ///////////////////////////////////////////////////////
        account = (EditText) findViewById(R.id.set_account);
        password = (EditText) findViewById(R.id.set_password);
        password0 = (EditText) findViewById(R.id.reset_password);
        ////////////////////////////////////////////////////////
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        ImageButton imageButton = (ImageButton) findViewById(R.id.button_back);             //back
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button button = (Button) findViewById(R.id.sign_up);                   //sign up
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account1 = account.getText().toString();
                String password1 = password.getText().toString();
                String password_re = password0.getText().toString();
                SharedPreferences.Editor editor = getSharedPreferences("usersmessage", MODE_PRIVATE).edit();
                if (!password_re.equals(password1)) {
                    Toast.makeText(ForthActivity.this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
                } else if (password_re.isEmpty() || account1.isEmpty() || password1.isEmpty()) {
                    Toast.makeText(ForthActivity.this, "还有未输入的空格", Toast.LENGTH_SHORT).show();
                } else {
                    editor.putString("account", account1);
                    editor.putString("password", password1);
                    editor.apply();
                    Toast.makeText(ForthActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

    }
}