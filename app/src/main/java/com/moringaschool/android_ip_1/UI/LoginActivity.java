package com.moringaschool.android_ip_1.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.moringaschool.android_ip_1.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;


    @BindView(R.id.tvSignUp) TextView tvSignUp;
    @BindView(R.id.clContinue) ConstraintLayout clContinue;
    @BindView(R.id.tvLoginPassword) TextView tvLoginPassword;
    @BindView(R.id.tvLoginEmail) TextView tvLoginEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        firebaseAuth = FirebaseAuth.getInstance();
        
        tvSignUp.setOnClickListener(this);
        clContinue.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {


        if (view==clContinue){
            
            loginWithPassword();

        }

        if (view==tvSignUp){
            Intent intent=new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
        }

    }

    private void loginWithPassword() {

        String email = tvLoginEmail.getText().toString().trim();
        String password = tvLoginPassword.getText().toString().trim();
        if (email.equals("")) {
            tvLoginEmail.setError("Please enter your email");
            return;
        }
        if (password.equals("")) {
            tvLoginPassword.setError("Password cannot be blank");
            return;
        }

    }
}