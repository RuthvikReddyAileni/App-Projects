package com.example.programminglanguagesquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ActivityCscore extends AppCompatActivity {
    TextView text;
    TextView b1, b2,b3 ,main;
    private static final String DATA1 = "Score C-R1";
    private static final String DATA2 = "Score C-R2";
    private static final String DATA3 = "Score C-R3";

    private FirebaseFirestore db =  FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cscore);

        FirebaseAuth fAuth = FirebaseAuth.getInstance();
        String userID = fAuth.getCurrentUser().getUid();
        DocumentReference noteRef1 = db.collection("Mobile Quiz").document(userID);


        b1 = findViewById(R.id.round1);
        b2 = findViewById(R.id.round2);
        b3 = findViewById(R.id.round3);

        noteRef1.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()){

                            String title1 =  documentSnapshot.getString(DATA1);
                            String title2 =  documentSnapshot.getString(DATA2);
                            String title3 =  documentSnapshot.getString(DATA3);

                            String line1 = "Round1 : " + title1 ;
                            String line2 = "Round2 : " + title2 ;
                            String line3 = "Round3 : " + title3 ;

                            b1.setText(line1);
                            b2.setText(line2);
                            b3.setText(line3);

                        }else {
                            Toast.makeText(ActivityCscore.this,"Document does not exists",Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ActivityCscore.this,"Error!",Toast.LENGTH_SHORT).show();
                        Log.d(String.valueOf(ActivityCscore.this),e.toString());
                    }
                });
        main = findViewById(R.id.back);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Activity2.class));
            }
        });

    }
    @Override
    public void onBackPressed () {
    }
}