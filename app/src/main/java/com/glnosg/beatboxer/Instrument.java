package com.glnosg.beatboxer;


/**
 * Created by pawel on 07.10.17.
 */

public class Instrument {

    private String mInstrumentName;
    private int mSoundSrcID;

    /**
     *
     * @param name - name of the instrument
     * @param soundID - ID of sound resource
     */
    public Instrument (String name, int soundID) {
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
