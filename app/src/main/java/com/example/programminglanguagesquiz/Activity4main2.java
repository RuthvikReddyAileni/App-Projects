package com.example.programminglanguagesquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Activity4main2 extends AppCompatActivity {
    Button button1 , button2 , button3 , check2;
    DatabaseReference reff;
    String userID;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity4main2);

        check2 =  findViewById(R.id.check);
        check2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fAuth = FirebaseAuth.getInstance();
                userID = fAuth.getCurrentUser().getUid();

                FirebaseFirestore db = FirebaseFirestore.getInstance();
                DocumentReference reff = db.collection("Mobile Quiz").document(userID);
                reff.get()
                        .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                String c1 = null;
                                String c2 = null;
                                if (documentSnapshot.exists()) {
                                    c1 = documentSnapshot.getString("StatusJ1");
                                    c2 = documentSnapshot.getString("StatusJ2");
                                    if(documentSnapshot.getString("StatusJ1") != null && documentSnapshot.getString("StatusJ2") != null){
                                        openActivity4main3();
                                    }
                                } else {
                                    Toast.makeText(Activity4main2.this, "Document does not exist.", Toast.LENGTH_SHORT).show();
                                }
                                Toast.makeText( Activity4main2.this, "Checked successfully", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });

            }
        });


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
    }
    public void openActivity3() {
        Intent intent =  new Intent (this , Activity4.class);
        startActivity(intent);
    }
    public void openActivity32() {
        Intent intent =  new Intent (this , Activity42.class);
        startActivity(intent);
    }
    public void openActivity4main3() {
        Intent intent =  new Intent (this , Activity4main3.class);
        startActivity(intent);
    }
}