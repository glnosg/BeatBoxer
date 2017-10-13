package com.glnosg.beatboxer;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static android.R.id.button1;
import static android.R.id.button2;

/**
 * Created by pawel on 07.10.17.
 */

public class ControlPanelFragment extends Fragment {

    private OnButtonClickListener mCallback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_control_panel, container, false);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.play_button:
                        mCallback.onOptionSelectedPlay();
                        break;
                    case R.id.stop_button:
                        mCallback.onOptionSelectedStop();
                        break;
                    default:
                        break;
                }
            }
        };

        Button playButton = (Button) view.findViewById(R.id.play_button);
        Button stopButton = (Button) view.findViewById(R.id.stop_button);

        playButton.setOnClickListener(clickListener);
        stopButton.setOnClickListener(clickListener);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (OnButtonClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                + " must implement OnButtonClickListener");
        }
    }

    public interface OnButtonClickListener {
        public void onOptionSelectedPlay();
        public void onOptionSelectedStop();
    }
}
