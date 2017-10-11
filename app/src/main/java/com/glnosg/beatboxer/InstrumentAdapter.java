package com.glnosg.beatboxer;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;

import java.util.ArrayList;

/**
 * Created by pawel on 07.10.17.
 */

public class InstrumentAdapter extends ArrayAdapter {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    /**
     * @param context - Current context
     * @param objects - List of object represented in ListView
     */
    public InstrumentAdapter(Context context, ArrayList objects) {
        super(context, -1, objects);
    }

    /**
     *
     * @param position - position of the item
     * @param convertView - old view to reuse when possible
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View myView = convertView;

        if (myView == null) {
            myView = LayoutInflater.from(getContext()).inflate(R.layout.instruments_list_item, parent, false);
        }

        final Instrument currentInstrument = (Instrument) getItem(position);

        Button hearTheSoundButton = (Button) myView.findViewById(R.id.hear_the_sound_button);
        hearTheSoundButton.setText(currentInstrument.getName());
        hearTheSoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(getContext(), currentInstrument.getSoundID());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(onCompletionListener);
            }
        });

        ViewGroup checkboxesLayout = (ViewGroup) myView.findViewById(R.id.checkboxes_layout);
        checkboxesLayout.removeAllViews();
        for (int i = 0; i < currentInstrument.stateOfCheckBoxes.length; i++) {
            final int currentCheckBox = i;

            CheckBox cb = new CheckBox(getContext());
            cb.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT, 1f));
            cb.setChecked(currentInstrument.stateOfCheckBoxes[i]);

            checkboxesLayout.addView(cb);

            cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    currentInstrument.stateOfCheckBoxes[currentCheckBox] = !currentInstrument.stateOfCheckBoxes[currentCheckBox];
                }
            });
        }

        return myView;
    }

    public void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}
