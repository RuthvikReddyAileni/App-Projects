package com.example.programminglanguagesquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;
import java.util.Collections;

public class Activity33 extends AppCompatActivity {
    Button button1 , button2;

    private FirebaseFirestore db =  FirebaseFirestore.getInstance();


    private static final  String TAG = "Activity42";
    private static final String DATA = "DATA";
    private static final String KEY = "KEY";
    private static final String OP1 = "OP1";
    private static final String OP2 = "OP2";
    private static final String OP3 = "OP3";
    private static final String OP4 = "OP4";

    public static String questions[] = new String[15];
    public static String options[][] = new String[15][4];
    public static String key[] = new String[15];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_33);

        MainActivity.score =0;

        for(int i = 0;i<15;i++) {

            int x = i;
            int y = i + 1;
            String line = Integer.toString(y);
            line = "Q" + line;
            DocumentReference noteRef1 = db.collection("QuestionsC3").document(line);
            noteRef1.get()
                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()) {

                                String title = documentSnapshot.getString(DATA);
                                questions[x] = title;
                            } else {
                                Toast.makeText(Activity33.this, "Document does not exists", Toast.LENGTH_SHORT).show();
                            }
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Activity33.this, "Error!", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, e.toString());
                        }
                    });
        }
        for(int i = 0;i<15;i++) {

            int x = i;
            int y = i + 1;
            String line = Integer.toString(y);
            line = "Q" + line;
            DocumentReference noteRef1 = db.collection("QuestionsC3").document(line);
            noteRef1.get()
                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()) {

                                String title = documentSnapshot.getString(KEY);
                                key[x] = title;
                            } else {
                                Toast.makeText(Activity33.this, "Document does not exists", Toast.LENGTH_SHORT).show();
                            }
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Activity33.this, "Error!", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, e.toString());
                        }
                    });
        }
        for(int j = 0;j<15;j++){

            int x = j;
            int y = j+1;
            String line = Integer.toString(y);
            line = "Q"+line;
            DocumentReference noteRef1 = db.collection("AnswersC3").document(line);
            noteRef1.get()
                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if(documentSnapshot.exists()){

                                String title[] = new String[4];

                                title[0] =  documentSnapshot.getString(OP1);
                                title[1] =  documentSnapshot.getString(OP2);
                                title[2] =  documentSnapshot.getString(OP3);
                                title[3]=  documentSnapshot.getString(OP4);

                                Collections.shuffle(Arrays.asList(title));

                                options[x][0]=title[0];
                                options[x][1]=title[1];
                                options[x][2]=title[2];
                                options[x][3]=title[3];

                            }else {
                                Toast.makeText(Activity33.this,"Document does not exists",Toast.LENGTH_SHORT).show();
                            }
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Activity33.this,"Error!",Toast.LENGTH_SHORT).show();
                            Log.d(TAG,e.toString());
                        }
                    });
        }




        button1 =  findViewById(R.id.startC3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity331();
            }
        });
        button2 =  findViewById(R.id.main2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }
    @Override
    public void onBackPressed () {
    }

    public void openActivity2(){
        Intent intent =  new Intent (this , Activity2.class);
        startActivity(intent);
    }
    public void openActivity331(){
        Intent intent =  new Intent (this , Activity331.class);
        startActivity(intent);
    }

}