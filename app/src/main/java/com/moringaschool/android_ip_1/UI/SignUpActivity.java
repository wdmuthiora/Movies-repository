package com.moringaschool.android_ip_1.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.moringaschool.android_ip_1.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.tvSignUpName) TextView tvSignUpName;
    @BindView(R.id.tvSignUpEmail) TextView tvSignUpEmail;
    @BindView(R.id.tvSignUpPassword) TextView tvSignUpPassword;
    @BindView(R.id.tvSignUpConfirmPassword) TextView tvSignUpConfirmPassword;
    @BindView(R.id.clSignUpCreateAccount) ConstraintLayout clSignUpCreateAccount;
    @BindView(R.id.tvSignUpSignIn) TextView tvSignUpSignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View view) {

        if (view ==clSignUpCreateAccount){
            createNewUser();
        }

        if (view==tvSignUpSignIn){
            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }


    }

    private void createNewUser() {
    }

}