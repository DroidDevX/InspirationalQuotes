package com.example.inspirationalquotes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class QuoteViewpagerAdapter extends FragmentStateAdapter {
    private static final String TAG = "QuoteViewpagerAdapter";

    int[] quoteImagesID;
    public QuoteViewpagerAdapter(@NonNull FragmentActivity fragmentActivity,int[] quoteImagesIDs) {
        super(fragmentActivity);
        this.quoteImagesID = quoteImagesIDs;
    }





    @NonNull
    @Override
    public Fragment createFragment(int position) {


        Bundle quoteImageID_ARGS = new Bundle();
        quoteImageID_ARGS.putInt(QuoteFragment.ARGS_QUOTE_IMAGE_ID, quoteImagesID[position]);
        QuoteFragment fragment = new QuoteFragment();
        fragment.setArguments(quoteImageID_ARGS);

        return fragment;
    }

    @Override
    public int getItemCount() {
        return quoteImagesID.length;
    }
}
