package com.example.f1_viewer.Firebase.firebase_administration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.f1_viewer.MainActivity;
import com.example.f1_viewer.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText email;
    TextInputEditText password;
    TextView tvRegister;
    Button btn_Login;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.editText_New_Email);
        password = findViewById(R.id.editText_New_Password);
        tvRegister = findViewById(R.id.textView_redirect_login);
        btn_Login = findViewById(R.id.btn_register);
        mAuth = FirebaseAuth.getInstance();

        btn_Login.setOnClickListener(view -> {
            loginUser();
        });
        tvRegister.setOnClickListener(view ->{
            startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
        });
    }

    private void loginUser(){

        String sEmail = email.getText().toString();
        String sPassword = password.getText().toString();

        if(TextUtils.isEmpty(sEmail)){
            email.setError("Popuni email");
            email.requestFocus();
        }else if(TextUtils.isEmpty(sPassword)){
            password.setError("Popuni email");
            password.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(sEmail, sPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(LoginActivity.this, "Uspješno ste ulogirani", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this , MainActivity.class));
                    }else{
                        Toast.makeText(LoginActivity.this, "Neuspješno" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }
}