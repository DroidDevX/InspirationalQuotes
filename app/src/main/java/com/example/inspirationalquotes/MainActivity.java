package com.example.inspirationalquotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    int inspirationalQuoteResources[] = new int[]{
            R.mipmap.a,
            R.mipmap.b,
            R.mipmap.c,
            R.mipmap.d,
            R.mipmap.e,
            R.mipmap.g,
            R.mipmap.h,
            R.mipmap.i,
            R.mipmap.j
    };

    QuoteViewpagerAdapter adapter;
    ViewPager2 quoteViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quoteViewPager = findViewById(R.id.quoteViewPager);
        adapter = new QuoteViewpagerAdapter(this,inspirationalQuoteResources);
        quoteViewPager.setAdapter(adapter);
    }



    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}