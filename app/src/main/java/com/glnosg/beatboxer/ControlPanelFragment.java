package com.glnosg.beatboxer;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by pawel on 07.10.17.
 */

public class ControlPanelFragment extends Fragment {

    private OnButtonClickListener mCallback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_control_panel, container, false);
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
        public void onOptionSelected();
    }
}
