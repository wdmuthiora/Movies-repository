package com.moringaschool.android_ip_1.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.moringaschool.android_ip_1.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    ProgressDialog progressDialog;

    public static final String TAG = LoginActivity.class.getSimpleName();

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

        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

                if (firebaseUser != null) {

                    Intent intent = new Intent(LoginActivity.this, MovieSearchActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();

                }
            }

        };
        
        tvSignUp.setOnClickListener(this);
        clContinue.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {


        if (view==clContinue){
            
            loginWithPassword();

        }

        if (view==tvSignUp){

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

        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Don't go making a cup of coffee just yet..."); //show this while waiting. Be sure to dismiss() after
        progressDialog.show();

        //Login using built-in Firebase method signInWithEmailAndPassword
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                        progressDialog.dismiss();


                        if (!task.isSuccessful()) {

                            Log.w(TAG, "signInWithEmail", task.getException());

                            Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                        }

                    }

                });

    }

    @Override
    public void onStart() {

        super.onStart();
        firebaseAuth.addAuthStateListener(firebaseAuthListener);

    }

    @Override
    public void onStop() {

        super.onStop();

        if (firebaseAuthListener != null) {

            firebaseAuth.removeAuthStateListener(firebaseAuthListener);

        }

    }

}