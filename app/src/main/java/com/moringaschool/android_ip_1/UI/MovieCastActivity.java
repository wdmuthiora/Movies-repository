package com.moringaschool.android_ip_1.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.moringaschool.android_ip_1.Adapter.MovieCastPagerAdapter;
import com.moringaschool.android_ip_1.Models.FilmEndPoint.Cast;
import com.moringaschool.android_ip_1.R;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieCastActivity extends AppCompatActivity {
    @BindView(R.id.viewPager) ViewPager mViewPager;
    private List<Cast> mCast;
    private MovieCastPagerAdapter adapterViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_cast);
        ButterKnife.bind(mViewPager,this);
        mCast= Parcels.unwrap(getIntent().getParcelableExtra("cast"));

        adapterViewPager=new MovieCastPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,mCast);
        mViewPager.setAdapter(adapterViewPager);

    }
}