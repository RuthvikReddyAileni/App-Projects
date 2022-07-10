package com.example.programminglanguagesquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity2 extends AppCompatActivity {
    Button button1 , button2 ;
    String c1 =  null ;
    String c2 = null;
    AlertDialog dialog;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Activity31.i = 0;
        Activity321.i = 0;
        Activity331.i = 0;
        Activity41.i = 0;
        Activity421.i = 0;
        Activity431.i = 0;

        button1 =  findViewById(R.id.clk);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openActivity3();
            }
        });
        button2 = findViewById(R.id.clk2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openActivity4();

            }
        });
    }
        @Override
        public void onBackPressed () {
          startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }

    public void openActivity3(){
        Intent intent = new Intent(this, Activity3main.class);
        startActivity(intent);
    }
    public void openActivity3main2() {
        Intent intent =  new Intent (this , Activity3main2.class);
        startActivity(intent);
    }
    public void openActivity3main3() {
        Intent intent =  new Intent (this , Activity3main3.class);
        startActivity(intent);
    }
    public void openActivity4(){
        Intent intent = new Intent(this, Activity4main.class);
        startActivity(intent);
    }
    public void openActivity4main2() {
        Intent intent =  new Intent (this , Activity4main2.class);
        startActivity(intent);
    }
    public void openActivity4main3() {
        Intent intent =  new Intent (this , Activity4main3.class);
        startActivity(intent);
    }

}