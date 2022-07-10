package com.example.programminglanguagesquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity4main3 extends AppCompatActivity {
    static Button button1 , button2 , button3 , check2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity4main3);
        button1 =  findViewById(R.id.round1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
        button2 =  findViewById(R.id.round2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity32();
            }
        });
        button3 =  findViewById(R.id.round3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity33();
            }
        });
    }
    public void openActivity3() {
        Intent intent =  new Intent (this , Activity4.class);
        startActivity(intent);
    }
    public void openActivity32() {
        Intent intent =  new Intent (this , Activity42.class);
        startActivity(intent);
    }
    public void openActivity33() {
        Intent intent =  new Intent (this , Activity43.class);
        startActivity(intent);
    }
}