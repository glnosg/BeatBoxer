package com.glnosg.beatboxer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity
    implements ControlPanelFragment.OnButtonClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onOptionSelected() {

    }
}
