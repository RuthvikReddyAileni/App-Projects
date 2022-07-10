package com.example.programminglanguagesquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class register extends AppCompatActivity {
    EditText mName;
    EditText mPhone;
    EditText mEmail;
    Button msubmit;
    String TAG = "TAG";
    ProgressBar progressbar;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    String userID;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mPhone = findViewById(R.id.input2);
        mEmail = findViewById(R.id.input3);
        msubmit = findViewById(R.id.enter2);
        fstore =  FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();
        progressbar =  findViewById(R.id.progressBar1);

        login = findViewById(R.id.clkhere2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainactivity();
                finish();
            }
        });

        msubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone =mPhone.getText().toString().trim();
                String email =mEmail.getText().toString().trim();

                if (TextUtils.isEmpty(phone)) {
                    mPhone.setError("Roll number is Required");
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Email is Required");
                    return;
                }
                progressbar.setVisibility(View.VISIBLE);

                //register the user in firebase

                fAuth.signInWithEmailAndPassword(email, phone).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText( register.this, "Logging in...", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Activity2.class));
                            progressbar.setVisibility(View.GONE);
                        } else {
                            Toast.makeText( register.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressbar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });
    }
    public void openMainactivity(){
        Intent intent =  new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void onBackPressed() {
        System.exit(0);
    }
}