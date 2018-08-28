package com.example.saurav.myads;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_1(View view) {
        startActivity(new Intent(MainActivity.this,MyApp_01.class));
    }

    public void btn_2(View view) {
        startActivity(new Intent(MainActivity.this,MyApp_02.class));
    }

    public void sample_btn(View view) {
        startActivity(new Intent(MainActivity.this,Sample.class));
    }
}
