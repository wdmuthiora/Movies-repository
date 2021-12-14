package com.moringaschool.android_ip_1.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.moringaschool.android_ip_1.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.tvSignUp) TextView tvSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        tvSignUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view==tvSignUp){

            Intent intent=new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
            finish();

        }

    }
}