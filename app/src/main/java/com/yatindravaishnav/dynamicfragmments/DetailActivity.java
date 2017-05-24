package com.yatindravaishnav.dynamicfragmments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;

/**
 * Created by Yatindra Vaishnav on 8/10/2016.
 */
public class DetailActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail_act);
        Bundle bundle = getIntent().getExtras();
        int position = bundle.getInt("position");
        System.out.println("RR : position is : " + position);

        Integer[] images = { R.drawable.sample_0,
                R.drawable.sample_1,
                R.drawable.sample_2,
                R.drawable.sample_3,
                R.drawable.sample_4,
                R.drawable.sample_5,
                R.drawable.sample_6,
                R.drawable.sample_7,
        };

        final ImageView imgview = (ImageView) findViewById(R.id.imageView1);
        imgview.setImageResource(images[position]);

        // DetailFragment detailFragment = new DetailFragment(position);
        // FragmentManager fm = getSupportFragmentManager();
        // FragmentTransaction ft =fm.beginTransaction();
        // ft.add(android.R.id.content, detailFragment).commit();

    }
}