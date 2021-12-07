package com.moringaschool.android_ip_1.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.moringaschool.android_ip_1.R;
import com.moringaschool.android_ip_1.UI.MainActivity2;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.startBtn) ConstraintLayout startBtn;
    @BindView(R.id.userName) TextInputEditText userName;
    @BindView(R.id.welcomeTxt) TextView welcomeTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

//        if(userName.getText().toString().isEmpty()){
//            startBtn.setVisibility(View.GONE);
//            welcomeTxt.setVisibility(View.GONE);
//        }else{
//            startBtn.setVisibility(View.VISIBLE);
//            welcomeTxt.setVisibility(View.VISIBLE);
//        }

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //capture user input
                String inputUserName = userName.getText().toString();

                Intent intent=new Intent(MainActivity.this, MainActivity2.class);
                //pass the captured input to the next Activity
                intent.putExtra("inputUserName", inputUserName);
                startActivity(intent);
            }
        });
    }
}