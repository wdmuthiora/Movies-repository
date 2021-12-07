package com.moringaschool.android_ip_1.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.ListView;

import com.moringaschool.android_ip_1.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleList extends AppCompatActivity {
    public static final String TAG = ArticleList.class.getSimpleName();

    //a bunch of items to be displayed inside the ListView, using the custom adapter.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_list);

        ButterKnife.bind(this);


    }
}