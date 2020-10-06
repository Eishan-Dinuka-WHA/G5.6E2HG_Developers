package com.example.g56_e2hg_developers;


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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {

    private EditText eEmail_edittext;
    private EditText ePassword_edittext;
    private ProgressBar eprogressBar;

    private Button signin;
    private Button signup;

    private FirebaseAuth eAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eAuth = FirebaseAuth.getInstance();
        eEmail_edittext = (EditText) findViewById(R.id.email_editText);
        ePassword_edittext = (EditText) findViewById(R.id.editTextTextPassword);

        signin = (Button) findViewById(R.id.signin);
        signup = (Button) findViewById(R.id.signup);

        eprogressBar = (ProgressBar) findViewById(R.id.progressBarl);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty()) return;
                inProgress(true);
                eAuth.signInWithEmailAndPassword(eEmail_edittext.getText().toString(),ePassword_edittext.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(LoginActivity.this,"User Sign in Successfully",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                        return;
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        inProgress(false);
                        Toast.makeText(LoginActivity.this,"Sign in Failed"+e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty()) return;
                inProgress(true);
                eAuth.createUserWithEmailAndPassword(eEmail_edittext.getText().toString(),ePassword_edittext.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(LoginActivity.this,"User Registered Successfully",Toast.LENGTH_SHORT).show();

                        inProgress(false);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        inProgress(false);
                        Toast.makeText(LoginActivity.this," User Registered Failed"+e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });



    }

    private  void inProgress (boolean x){
        if(x){
            eprogressBar.setVisibility(View.VISIBLE);
            signin.setEnabled(false);
            signup.setEnabled(false);
        }else{
            eprogressBar.setVisibility(View.GONE);
            signin.setEnabled(true);
            signup.setEnabled(true);
        }
    }
    private boolean isEmpty(){
        if(TextUtils.isEmpty(eEmail_edittext.getText().toString())){
            eEmail_edittext.setError("REQUIRED");
            return true;
        }
        if(TextUtils.isEmpty(ePassword_edittext.getText().toString())){
            ePassword_edittext.setError("REQUIRED");
            return true;
        }
        return false;
    }
}