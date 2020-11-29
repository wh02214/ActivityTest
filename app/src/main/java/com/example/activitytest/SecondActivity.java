package com.example.activitytest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private EditText accountEdit;
    private EditText passwordEdit;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private CheckBox rememberPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        rememberPass = (CheckBox) findViewById(R.id.remember_pass);
        accountEdit = (EditText) findViewById(R.id.edit_account);
        passwordEdit = (EditText) findViewById(R.id.edit_password);
        boolean isRemember = preferences.getBoolean("remember_password", false);
        if (isRemember) {
            String account = preferences.getString("account", "");
            String password = preferences.getString("password", "");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Button button = (Button) findViewById(R.id.sigh_up);
        TextView textView = (TextView) findViewById(R.id.sina);//新浪登录
        TextView textView1 = (TextView) findViewById(R.id.tencent);//腾讯登录
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
                SharedPreferences pref = getSharedPreferences("usersmessage", MODE_PRIVATE);
                String account_have = pref.getString("account", "");
                String password_have = pref.getString("password", "");
                if (account.equals(account_have) && password.equals(password_have)) {
                    editor = preferences.edit();                 //remember password
                    if (rememberPass.isChecked()) {
                        editor.putBoolean("remember_password", true);
                        editor.putString("account", account);
                        editor.putString("password", password);
                    } else {
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SecondActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {           //新浪
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "新浪登录", Toast.LENGTH_SHORT).show();
            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {          //腾讯
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "腾讯微博登录", Toast.LENGTH_SHORT).show();
            }
        });

    }
}