package com.example.inspirationalquotes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

public class QuoteFragment extends Fragment {
    public static String ARGS_QUOTE_IMAGE_ID ="quoteImage";
    private static final String TAG = "QuoteFragment";
    ImageView quoteImageView;
    Context activityContext;
    Bitmap quoteImage;
    @Override
    public void onAttach(@NonNull Context context) {
        activityContext = context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG,"onCreateView()");
        View rootView = inflater.inflate(R.layout.fragment_quote,container,false);
        quoteImageView = rootView.findViewById(R.id.imageView);

        if (getArguments()!=null)
         try {
             quoteImage = getInspirationQuoteBitmap(getArguments());
         }catch (Exception e) {Log.e(TAG,e.toString());}

        return rootView;
    }

    private Bitmap getInspirationQuoteBitmap(Bundle args) throws Exception{
        int imageID = args.getInt(ARGS_QUOTE_IMAGE_ID);
       return BitmapFactory.decodeResource(getResources(),imageID);
    }


    @Override
    public void onResume() {
        super.onResume();
        Glide.with(activityContext).load(quoteImage).into(quoteImageView);

    }
}
