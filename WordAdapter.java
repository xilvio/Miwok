package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.miwok.Word;

import java.util.ArrayList;

import static android.R.attr.resource;

/**
 * Created by Thar Min Htet on 1/8/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mbackgroundColor;

    public WordAdapter(Context context, ArrayList<Word> words, int color) {
        super(context, 0, words);
        this.mbackgroundColor = color;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceID());
            imageView.setVisibility(View.VISIBLE);
        }else {
            imageView.setVisibility(View.GONE);
        }
        View textContainer = listItemView.findViewById(R.id.textLinearLayout);
        int color = ContextCompat.getColor(getContext(), mbackgroundColor);
        textContainer.setBackgroundColor(color);

        TextView miwokView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokView.setText(currentWord.getMiwokTranslation());

        TextView defaultView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultView.setText(currentWord.getDefaultTranslation());

        return listItemView;
    }
}
