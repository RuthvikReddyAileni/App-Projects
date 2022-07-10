package com.example.programminglanguagesquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class Activity41 extends AppCompatActivity {
    TextView question ;
    Button op1 , op2 , op3 , op4 , quit ;
    Button next;
    String key ;
    static int i ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_41);


        if(i==4){
            Activity4.questions[4] = "Java is a _________ language ?";
        } if(i==14){
            Activity4.questions[14] = "What software compiles a Java Program?";
        }

        next = findViewById(R.id.next);
        question = findViewById(R.id.question);
        op1 = findViewById(R.id.key1);
        op2 = findViewById(R.id.key2);
        op3 = findViewById(R.id.key3);
        op4 = findViewById(R.id.key4);

        if(i!=15) {
            question.setText(Activity4.questions[i]);
            op1.setText(Activity4.options[i][0]);
            op2.setText(Activity4.options[i][1]);
            op3.setText(Activity4.options[i][2]);
            op4.setText(Activity4.options[i][3]);
            key = Activity4.key[i];
        }
        else {

            Map<String, Object> data1 = new HashMap<>();
            data1.put("Score J-R1",MainActivity.score);


            FirebaseFirestore db = FirebaseFirestore.getInstance();
            FirebaseAuth fAuth = FirebaseAuth.getInstance();
            String userID = fAuth.getCurrentUser().getUid();

            db.collection("Mobile Quiz").document(userID)
                    .set(data1, SetOptions.merge())
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d("Activity41", "DocumentSnapshot successfully written!");
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w("Activity41", "Error writing document", e);
                        }
                    });

            if(MainActivity.score < 10)
            {
                Toast.makeText(Activity41.this, "You didn't qualify for round 2 as you scored less than 10.", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), Activity4.class));
                Activity41.i=0;
            } else {

                Map<String, Object> data = new HashMap<>();
                //data.put("Score C-R3",MainActivity.score);
                data.put("StatusJ1","true");


                FirebaseFirestore db1 = FirebaseFirestore.getInstance();
                FirebaseAuth fAuth1 = FirebaseAuth.getInstance();
                String userID1 = fAuth1.getCurrentUser().getUid();

                db1.collection("Mobile Quiz").document(userID1)
                        .set(data, SetOptions.merge())
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("Activity331", "DocumentSnapshot successfully written!");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("Activity331", "Error writing document", e);
                            }
                        });

                Toast.makeText(Activity41.this, "Congratulations , you are qualified to round 2 by scoring  "+ MainActivity.score +" .", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), Activity42.class));


            }
        }
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity41.i = Activity41.i + 1;
                quit.setVisibility(View.INVISIBLE);
                openActivity41();
            }
        });
        quit =  findViewById(R.id.quit);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String op = (String) op1.getText();
                if(op.equalsIgnoreCase(key) == true){
                    op1.setTextColor(Color.parseColor("#14E31C"));
                    MainActivity.score =  MainActivity.score + 1 ;
                    op1.setEnabled(false);
                    op2.setEnabled(false);
                    op3.setEnabled(false);
                    op4.setEnabled(false);
                }else {
                    op1.setTextColor(Color.parseColor("#FD0707"));
                    op1.setEnabled(false);
                    op2.setEnabled(false);
                    op3.setEnabled(false);
                    op4.setEnabled(false);
                }

            }
        });
        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String op = (String) op2.getText();
                if(op.equalsIgnoreCase(key) == true){
                    op2.setTextColor(Color.parseColor("#14E31C"));
                    MainActivity.score =  MainActivity.score + 1 ;
                    op1.setEnabled(false);
                    op2.setEnabled(false);
                    op3.setEnabled(false);
                    op4.setEnabled(false);
                }else {
                    op2.setTextColor(Color.parseColor("#FD0707"));
                    op1.setEnabled(false);
                    op2.setEnabled(false);
                    op3.setEnabled(false);
                    op4.setEnabled(false);
                }
            }
        });
        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String op = (String) op3.getText();
                if(op.equalsIgnoreCase(key) == true){
                    op3.setTextColor(Color.parseColor("#14E31C"));
                    MainActivity.score =  MainActivity.score + 1 ;
                    op1.setEnabled(false);
                    op2.setEnabled(false);
                    op3.setEnabled(false);
                    op4.setEnabled(false);
                }else {
                    op3.setTextColor(Color.parseColor("#FD0707"));
                    op1.setEnabled(false);
                    op2.setEnabled(false);
                    op3.setEnabled(false);
                    op4.setEnabled(false);
                }
            }
        });
        op4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String op = (String) op4.getText();
                if(op.equalsIgnoreCase(key) == true){
                    op4.setTextColor(Color.parseColor("#14E31C"));
                    MainActivity.score =  MainActivity.score + 1 ;
                    op1.setEnabled(false);
                    op2.setEnabled(false);
                    op3.setEnabled(false);
                    op4.setEnabled(false);
                }else {
                    op4.setTextColor(Color.parseColor("#FD0707"));
                    op1.setEnabled(false);
                    op2.setEnabled(false);
                    op3.setEnabled(false);
                    op4.setEnabled(false);
                }
            }
        });

    }
    @Override
    public void onBackPressed () {
        Toast.makeText(Activity41.this,"You can't go to previous screen . You can quit the test if you want to .",Toast.LENGTH_SHORT).show();
        quit.setVisibility(View.VISIBLE);
    }
    public void openActivity32(){
        Intent intent =  new Intent (this , Activity32.class);
        startActivity(intent);
    }
    public void openActivity41(){
        Intent intent =  new Intent (this , Activity41.class);
        startActivity(intent);
    }
    public void openActivity2(){
        Intent intent =  new Intent (this , Activity2.class);
        startActivity(intent);
    }
}