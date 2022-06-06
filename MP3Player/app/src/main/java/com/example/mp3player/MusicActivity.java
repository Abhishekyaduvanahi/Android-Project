package com.example.mp3player;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MusicActivity extends AppCompatActivity {

    private Button buttonplayPause ,buttonPrevious,buttonNext;
    private TextView textViewFileNameMusic,textViewProgress,textViewTotalTime;
    private SeekBar seekBarVolume ,seekBarMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        buttonplayPause =findViewById(R.id.buttonpause);
        buttonNext = findViewById(R.id.buttonNext);
        buttonPrevious =findViewById(R.id.buttonPrevoius);

        textViewFileNameMusic = findViewById(R.id.textViewFileNameMusic);
        textViewProgress =findViewById(R.id.textViewProgress);
        textViewTotalTime =findViewById(R.id.textViewTotalTime);

        seekBarMusic = findViewById(R.id.musicSeekBar);
        seekBarVolume = findViewById(R.id.volumeSeekBar);

    }
}