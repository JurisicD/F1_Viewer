package com.example.f1_viewer.Firebase.firebase_administration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.f1_viewer.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    TextInputEditText email;
    TextInputEditText password;
    TextView tvLogin;
    Button btn_Register;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.editText_New_Email);
        password = findViewById(R.id.editText_New_Password);
        tvLogin = findViewById(R.id.textView_redirect_login);
        btn_Register = findViewById(R.id.btn_register);
        mAuth = FirebaseAuth.getInstance();

        btn_Register.setOnClickListener(view ->{
            createUser();
        });

        tvLogin.setOnClickListener(view -> {
            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
        });
    }

    private void createUser(){
        String sEmail = email.getText().toString();
        String sPassword = password.getText().toString();

        if(TextUtils.isEmpty(sEmail)){
            email.setError("Popuni email");
            email.requestFocus();
        }else if(TextUtils.isEmpty(sPassword)){
            password.setError("Popuni email");
            password.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(sEmail, sPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(SignUpActivity.this, "Uspješno ste registirani", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignUpActivity.this , LoginActivity.class));
                    } else {
                        Toast.makeText(SignUpActivity.this, "Neuspješna registracija" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}