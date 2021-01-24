package com.example.sendersms.views.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sendersms.MainActivity;
import com.example.sendersms.R;
import com.example.sendersms.firebase.Firestore;
import com.example.sendersms.user.UserEnum;
import com.example.sendersms.user.UserModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText tieEmail , tiePassword;
    MaterialButton btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tieEmail = findViewById(R.id.tie_email);
        tiePassword = findViewById(R.id.tie_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    login(tieEmail.getText().toString(),tiePassword.getText().toString());
                }else{

                }
            }
        });

    }

    private boolean validate(){
        return true;
    }

    private void login(String email , String password){
//        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
//                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
//                    @Override
//                    public void onSuccess(AuthResult authResult) {
//                        goToMainActivity();
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                e.printStackTrace();
//            }
//        });
//        final DocumentReference document = Firestore.getCollectionUser().document();
//        UserModel user = new UserModel();
//        user.setId(document.getId());
//        document.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void aVoid) {
//
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                e.printStackTrace();
//            }
//        });
        goToMainActivity();
    }

    private void goToMainActivity(){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}