package com.moringaschool.android_ip_1.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.moringaschool.android_ip_1.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends AppCompatActivity {

    @BindView(R.id.startBtn) ConstraintLayout startBtn;
    @BindView(R.id.userName) TextInputEditText userName;
    @BindView(R.id.welcomeTxt) TextView welcomeTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ButterKnife.bind(this);

        startBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String inputUserName = userName.getText().toString();

                Intent intent=new Intent(WelcomeActivity.this, LoginActivity.class);
                intent.putExtra("inputUserName", inputUserName);
                startActivity(intent);

            }

        });
    }
}