package com.glnosg.beatboxer;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by pawel on 07.10.17.
 */

public class MusicPatternFragment extends Fragment {

    private OnDataPass dataPasser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.instruments_list, container, false);

        ArrayList<Instrument> instrumentList = new ArrayList<>();

        instrumentList.add(new Instrument("Clap", R.raw.clap, getActivity()));
        instrumentList.add(new Instrument("Close Flam", R.raw.close_flam, getActivity()));
        instrumentList.add(new Instrument("Close Hi-Hat", R.raw.close_hi_hat, getActivity()));
        instrumentList.add(new Instrument("Close Kick", R.raw.close_kick, getActivity()));
        instrumentList.add(new Instrument("Close Op-Hat", R.raw.close_op_hat, getActivity()));
        instrumentList.add(new Instrument("Close Rim", R.raw.close_rim, getActivity()));
        instrumentList.add(new Instrument("Close SdSt", R.raw.close_sd_st, getActivity()));
        instrumentList.add(new Instrument("Close Snare", R.raw.close_snr, getActivity()));
        instrumentList.add(new Instrument("Close Snare Off", R.raw.close_snr_off, getActivity()));

        String as = "Elo";
        passData(as);

        InstrumentAdapter instrumentAdapter = new InstrumentAdapter(getActivity(), instrumentList);

        ListView listView = (ListView) view.findViewById(R.id.instruments_list);
        listView.setAdapter(instrumentAdapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dataPasser = (OnDataPass) context;
    }

    public interface OnDataPass {
        public void onDataPass(String data);
    }

    public void passData(String data) {
        dataPasser.onDataPass(data);
    }
}
