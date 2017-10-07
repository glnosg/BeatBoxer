package com.glnosg.beatboxer;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by pawel on 07.10.17.
 */

public class MusicPatternFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.instruments_list, container, false);

        ArrayList<Instrument> instrumentList = new ArrayList<>();

        instrumentList.add(new Instrument("Hi-Hat"));
        instrumentList.add(new Instrument("Clap"));
        instrumentList.add(new Instrument("Snare"));
        instrumentList.add(new Instrument("Cowbell"));
        instrumentList.add(new Instrument("Kick"));
        instrumentList.add(new Instrument("Tom"));
        instrumentList.add(new Instrument("Cymbal"));
        instrumentList.add(new Instrument("Radzio Kutas"));


        InstrumentAdapter instrumentAdapter = new InstrumentAdapter(getActivity(), instrumentList);

        ListView listView = (ListView) view.findViewById(R.id.instruments_list);
        listView.setAdapter(instrumentAdapter);

        return view;
    }
}
