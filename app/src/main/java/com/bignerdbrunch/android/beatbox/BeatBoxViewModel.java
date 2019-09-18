package com.bignerdbrunch.android.beatbox;

import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.widget.SeekBar;

public class BeatBoxViewModel extends BaseObservable{
    private BeatBox mBeatBox;

    public ObservableField<Integer> mPlaybackSpeedValue = new ObservableField<>(1);
    public ObservableField<String> mPlaybackSpeedLabel = new ObservableField<>();

    public BeatBoxViewModel(BeatBox beatBox) {
        mBeatBox = beatBox;
    }

    public void onPlaybackSpeedChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
        float playbackSpeed;

        if (progressValue == 0) {
            playbackSpeed = 0f;
        } else {
            playbackSpeed = progressValue / 100.0f;
        }

        mBeatBox.setPlaybackSpeed(playbackSpeed);
        mPlaybackSpeedValue.set(progressValue);
        mPlaybackSpeedLabel.set(Float.toString(playbackSpeed));
    }
}
