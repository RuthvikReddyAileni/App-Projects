 package com.example.programminglanguagesquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

 public class MainActivity extends AppCompatActivity {
     public static final String TAG1 = "TAG";
     EditText mName;
     EditText mPhone;
     EditText mEmail;
     Button msubmit;
     ProgressBar progressbar;
     FirebaseAuth fAuth;
     static int score ;
     FirebaseFirestore fstore;
     static String userID;
     Button register;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         mName =  findViewById(R.id.input1);
         mPhone = findViewById(R.id.input2);
         mEmail = findViewById(R.id.input3);
         msubmit = findViewById(R.id.enter);
         fstore =  FirebaseFirestore.getInstance();
         fAuth = FirebaseAuth.getInstance();
         progressbar =  findViewById(R.id.progressBar);

         register = findViewById(R.id.clickhere1);
         register.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 openRegister();
                 finish();
             }
         });

         msubmit.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String name = mName.getText().toString().trim();
                 String phone =mPhone.getText().toString().trim();
                 String email =mEmail.getText().toString().trim();

                 if (TextUtils.isEmpty(name)) {
                     mName.setError("Name is Required");
                     return;
                 }
                 if (TextUtils.isEmpty(phone)) {
                     mPhone.setError("Roll number is Required");
                     return;
                 }
                 if (TextUtils.isEmpty(email)) {
                     mEmail.setError("Email is Required");
                     return;
                 }
                 progressbar.setVisibility(View.VISIBLE);

                 // register the user in firebase

                 fAuth.createUserWithEmailAndPassword(email, phone).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                     @Override
                     public void onComplete(@NonNull Task<AuthResult> task) {
                         if (task.isSuccessful()) {
                             Toast.makeText( MainActivity.this, "Registered.", Toast.LENGTH_SHORT).show();
                             userID = fAuth.getCurrentUser().getUid();
                             DocumentReference documentReference = fstore.collection("Mobile Quiz").document(userID);
                             Map<String,Object> user = new HashMap<>();
                             user.put("Student Name",name);
                             user.put("Password",phone);
                             user.put("Domain Mail",email);
                             documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                 @Override
                                 public void onSuccess(Void aVoid) {
                                     Log.d(TAG1,"onSuccess :user Profile is created for "+ userID );
                                 }
                             });
                            startActivity(new Intent(getApplicationContext(),Activity2.class));
                             progressbar.setVisibility(View.GONE);
                         } else {
                             Toast.makeText( MainActivity.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                             progressbar.setVisibility(View.GONE);
                         }
                     }
                 });
             }
         });
     }
     public void openRegister(){
         Intent intent =  new Intent(this,register.class);
         startActivity(intent);
     }
     public void onBackPressed() {
         System.exit(0);
     }
 }