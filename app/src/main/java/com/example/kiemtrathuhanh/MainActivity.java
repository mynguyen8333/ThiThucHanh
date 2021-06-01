package com.example.kiemtrathuhanh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText edEmail;
    EditText edpassWord;
    Button btnLogin;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edEmail = findViewById(R.id.edEmail);
        edpassWord = findViewById(R.id.edpassword);
        btnLogin = findViewById(R.id.btnLogin);

        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(view->{
            Dangnhap();
        });


    }
    private void Dangnhap(){
        String email = edEmail.getText().toString().trim();
        String pass = edpassWord.getText().toString().trim();
        if(email.equalsIgnoreCase("")){
            Toast.makeText(MainActivity.this,"Chua nhap tai khoan",Toast.LENGTH_SHORT).show();
        }else if(pass.equalsIgnoreCase("")){
            Toast.makeText(MainActivity.this,"Chua nhap mat khau",Toast.LENGTH_SHORT).show();
        }else{
            mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(MainActivity.this,"Dang nhap thanh cong",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,Manager.class));
                    }else{
                        Toast.makeText(MainActivity.this,"Sai ten tai khoan hoac mat khau",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }
}