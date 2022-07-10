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

public class Activity4score extends AppCompatActivity {
    TextView text;
    Button score , main ;
    private static final String DATA = "Student Name";
    FirebaseAuth fAuth = FirebaseAuth.getInstance();
    String userID = fAuth.getCurrentUser().getUid();
    private FirebaseFirestore db =  FirebaseFirestore.getInstance();
    private DocumentReference noteRef1 = db.collection("Mobile Quiz").document(userID);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity4score);


        text = findViewById(R.id.ending);
        noteRef1.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()){

                            String title =  documentSnapshot.getString(DATA);
                            String line ="Congratulations " + title +" you have successfully finished the Java language quiz . We are very happy that you have participated in this quiz . We are hoping we can see you in other language quizzes as well. Thank You ." ;
                            text.setText(line);
                        }else {
                            Toast.makeText(Activity4score.this,"Document does not exists",Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Activity4score.this,"Error!",Toast.LENGTH_SHORT).show();
                        Log.d(String.valueOf(Activity4score.this),e.toString());
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