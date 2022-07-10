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

public class Activity431 extends AppCompatActivity {

    TextView question ;
    Button op1 , op2 , op3 , op4 ,quit;
    String key;
    Button next;
    static int i ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_431);

        next = findViewById(R.id.next);
        question = findViewById(R.id.question);
        op1 = findViewById(R.id.key1);
        op2 = findViewById(R.id.key2);
        op3 = findViewById(R.id.key3);
        op4 = findViewById(R.id.key4);

        if(i==4){
            Activity43.questions[4] = "What does AWT stands for ?";
        } if(i==14){
            Activity43.questions[14] = "A class member declared protected becomes a member of subclass of which type ?";
        }
        if(i!=15) {
            question.setText(Activity43.questions[i]);
            op1.setText(Activity43.options[i][0]);
            op2.setText(Activity43.options[i][1]);
            op3.setText(Activity43.options[i][2]);
            op4.setText(Activity43.options[i][3]);
            key = Activity43.key[i];
        }
        else {

            Map<String, Object> data1 = new HashMap<>();
            data1.put("Score J-R3",MainActivity.score);


            FirebaseFirestore db = FirebaseFirestore.getInstance();
            FirebaseAuth fAuth = FirebaseAuth.getInstance();
            String userID = fAuth.getCurrentUser().getUid();

            db.collection("Mobile Quiz").document(userID)
                    .set(data1, SetOptions.merge())
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d("Activity431", "DocumentSnapshot successfully written!");
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w("Activity431", "Error writing document", e);
                        }
                    });

            if(MainActivity.score < 10)
            {
                Toast.makeText(Activity431.this, "You didn't qualify for round 3 as you scored less than 10.", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), Activity43.class));
                Activity431.i=0;
            } else {

                Map<String, Object> data = new HashMap<>();
                //data.put("Score C-R3",MainActivity.score);
                data.put("StatusJ3","true");


                FirebaseFirestore db1 = FirebaseFirestore.getInstance();
                FirebaseAuth fAuth1 = FirebaseAuth.getInstance();
                String userID1 = fAuth1.getCurrentUser().getUid();

                db1.collection("Mobile Quiz").document(userID1)
                        .set(data, SetOptions.merge())
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("Activity431", "DocumentSnapshot successfully written!");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("Activity431", "Error writing document", e);
                            }
                        });

                Toast.makeText(Activity431.this, "Congratulations !", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), Activity4score.class));


            }
        }
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity431.i = Activity431.i + 1;
                openActivity431();
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
        Toast.makeText(Activity431.this,"You can't go to previous screen . You can quit the test if you want to .",Toast.LENGTH_SHORT).show();
        quit.setVisibility(View.VISIBLE);
    }
    public void openActivity43(){
        Intent intent =  new Intent (this , Activity4score.class);
        startActivity(intent);
    }
    public void openActivity431(){
        Intent intent =  new Intent (this , Activity431.class);
        startActivity(intent);
    }
    public void openActivity2(){
        Intent intent =  new Intent (this , Activity2.class);
        startActivity(intent);
    }
}