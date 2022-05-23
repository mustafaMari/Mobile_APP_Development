package com.example.lab6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

public class AudioRecord extends AppCompatActivity {
    MediaRecorder mediaRecorder;
    MediaPlayer mediaPlayer;
    String audioDirPath = null;
    String audioFilePath = null;
    String audioFileName = "audio_recording" + ".3gp";
    public static final int REQUEST_AUDIO_PERMISSION_CODE = 11;
    PackageManager packageManager = this.getPackageManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_record);
        if (packageManager.hasSystemFeature((PackageManager.FEATURE_MICROPHONE))){
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getApplicationContext(), "permission denied", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, REQUEST_AUDIO_PERMISSION_CODE);
            }
        }else{
            Toast.makeText(getApplicationContext(), "There is no microphone support", Toast.LENGTH_SHORT).show();
        }


    }

    public void startRecording (View v){
        audioDirPath = getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_MUSIC).toString();
        audioFilePath = audioDirPath + "/" + audioFileName;

    }


}