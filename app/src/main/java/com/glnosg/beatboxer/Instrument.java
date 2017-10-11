package com.glnosg.beatboxer;


import android.content.Context;
import android.widget.CheckBox;

/**
 * Created by pawel on 07.10.17.
 */

public class Instrument {

    private static final int PATTERN_LENGTH = 12;

    private String mInstrumentName;
    private int mSoundSrcID;

    public boolean[] stateOfCheckBoxes = new boolean[PATTERN_LENGTH];

    /**
     *
     * @param name - name of the instrument
     * @param soundID - ID of sound resource
     */
    public Instrument (String name, int soundID, Context context) {
        mInstrumentName = name;
        mSoundSrcID = soundID;
    }

    public String getName() {
        return mInstrumentName;
    }

    public int getSoundID() {
        return mSoundSrcID;
    }

}
