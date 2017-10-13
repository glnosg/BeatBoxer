package com.glnosg.beatboxer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import static android.R.attr.data;
import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity
    implements ControlPanelFragment.OnButtonClickListener, MusicPatternFragment.OnDataPass{

    private String dataFromMusicPattern;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onOptionSelectedPlay() {
        Toast.makeText(this, dataFromMusicPattern + " Play", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onOptionSelectedStop() {
        Toast.makeText(this, dataFromMusicPattern + " Stop", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataPass(String data) {
        dataFromMusicPattern = data;
    }
}
