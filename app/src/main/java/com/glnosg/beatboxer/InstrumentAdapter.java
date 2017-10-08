package com.glnosg.beatboxer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by pawel on 07.10.17.
 */

public class InstrumentAdapter extends ArrayAdapter {

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

        Instrument currentInstrument = (Instrument) getItem(position);

        Button hearTheSoundButton = (Button) myView.findViewById(R.id.hear_the_sound_button);
        hearTheSoundButton.setText(currentInstrument.getName());

        return myView;
    }
}
