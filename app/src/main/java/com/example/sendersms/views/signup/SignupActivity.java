package com.example.sendersms.views.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.example.sendersms.R;
import com.example.sendersms.firebase.Firestore;
import com.example.sendersms.user.RoleEnum;
import com.example.sendersms.user.UserEnum;
import com.example.sendersms.user.UserModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;

public class SignupActivity extends FragmentActivity {

    FirebaseAuth auth;
    TextInputEditText tieName,tieLastName,tieDNI , tiePhoneNumber , tiePassword , tieEmail;
    MaterialButton btnContinuar;
    ViewPager2 viewPager2;
    private PagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        auth = FirebaseAuth.getInstance();
        viewPager2 = findViewById(R.id.view_pager);
        SlideSignupAdapter pagerAdapter = new SlideSignupAdapter(this);
        viewPager2.setAdapter(pagerAdapter);
//        tieName = findViewById(R.id.tie_name);
//        tieLastName = findViewById(R.id.tie_last_name);
//        tieDNI = findViewById(R.id.tie_dni);
//        tiePhoneNumber = findViewById(R.id.tie_phone_number);
//        tiePassword = findViewById(R.id.tie_password);
//        tieEmail = findViewById(R.id.tie_email);
//        btnContinuar = findViewById(R.id.btn_verify_phone_number);
//        btnContinuar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

    }

    private Boolean validate(){
        return true;
    }

    private void signup(){
        final DocumentReference newDoc = Firestore.getCollectionUser().document();
        UserModel newUser = new UserModel();
        newUser.setId(newDoc.getId());
        newUser.setPhoneNumber(tiePhoneNumber.getText().toString());
        newUser.setDni(tieDNI.getText().toString());
        newUser.setName(tieName.getText().toString());
        newUser.setLastName(tieLastName.getText().toString());
        newUser.setEmail(tieEmail.getText().toString());
        newUser.setPassword(tiePassword.getText().toString());
        newUser.setRole(RoleEnum.CLIENTE);
        newUser.setState(UserEnum.ACTIVE);
//        auth
    }
}