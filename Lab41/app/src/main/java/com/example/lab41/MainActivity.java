package com.example.lab41;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnOptionChecked{
    DynamicFragment dynamicFragment = new DynamicFragment();
    SecondDynamicFragment secondDynamicFragment = new SecondDynamicFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onOptionChecked(int id) {
        Fragment f;
        if (id == R.id.showF1){
            f  = dynamicFragment;
        }else {
            f = secondDynamicFragment;
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.fragmentActionViewer, f);
        ft.commit();
    }
}