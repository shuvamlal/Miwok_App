package com.example.android.miwok;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;


public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        LayoutInflater miwokInflater = LayoutInflater.from(getContext());
        View wordView = convertView;
        if (wordView == null) {
            wordView = miwokInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list__itemm.xml layout with the ID default_text_view.
        TextView defaultTextView = wordView.findViewById(R.id.default_text_view);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        defaultTextView.setText(currentWord.getmDefaultTranslation());

        // Find the TextView in the word_list.xmll layout with the ID miwok_text_view.
        TextView miwokTextView = wordView.findViewById(R.id.miwok_text_view);
        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        miwokTextView.setText(Objects.requireNonNull(currentWord).getmMiwokTranslation());

        // Find the ImageView in the word_list.xmll layout with the ID image.
        ImageView imageView = wordView.findViewById(R.id.image);

        // Find the ImageView in the word_list.xmll layout with the ID image.
        View playImageView = wordView.findViewById(R.id.play_key);

        if (currentWord.hasImage()) {
            // if an image is available, display the provided image based on resourceId
            imageView.setImageResource(currentWord.getmImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        //Set the theme color for the list item
        View textContainer = wordView.findViewById(R.id.text_container);
        //Find the color that resource Id maps to
        final int color = ContextCompat.getColor(getContext(), mColorResourceId);
        //Set the background color of the text container
        textContainer.setBackgroundColor(color);
        playImageView.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return wordView;
    }
}
