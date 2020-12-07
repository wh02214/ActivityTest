package com.example.activitytest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class ThirdActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<RvData> list = new ArrayList<>();
    private RvAdapter rvAdapter = new RvAdapter(list);

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.user:
                Toast.makeText(ThirdActivity.this, "build", Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting:
                Toast.makeText(ThirdActivity.this, "building", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Button button3 = (Button) findViewById(R.id.button_3);
        ImageButton imageButton = (ImageButton) findViewById(R.id.button_5);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://s.61.com/home/?tad=innermedia.seer.free.icon"));
                startActivity(intent);
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Intent.ACTION_VIEW);
                intent2.setData(Uri.parse("tel:"));
                startActivity(intent2);
            }
        });
        recyclerView = findViewById(R.id.rv);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(rvAdapter);

        list.add(new RvData("项目一"));
        list.add(new RvData("项目二"));
        list.add(new RvData("项目三"));
        list.add(new RvData("项目四"));
        list.add(new RvData("项目五"));
        list.add(new RvData("项目六"));
        list.add(new RvData("项目七"));
        list.add(new RvData("项目八"));
        list.add(new RvData("项目九"));
        list.add(new RvData("项目十"));

        rvAdapter.notifyDataSetChanged();
    }
}