package com.example.lab3additionaltask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem titleCheckBox = menu.getItem(3).getSubMenu().getItem(0);
        MenuItem subtitleCheckBox = menu.getItem(3).getSubMenu().getItem(1);
        titleCheckBox.setCheckable(true);
        subtitleCheckBox.setCheckable(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         ImageView image = findViewById(R.id.imageView);
         TextView title = findViewById(R.id.title);
         TextView subtitle = findViewById(R.id.subtitle);
        Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        if (item.getTitle().toString().equals("Option One")){
            image.setBackgroundColor(Color.BLACK);
        }else if (item.getTitle().toString().equals("Option Two")){
            image.setBackgroundColor(Color.RED);
        }else if (item.getTitle().toString().equals("Option Three")){
            image.setBackgroundColor(Color.GREEN);
        }else if (item.getTitle().toString().equals("Hide Title")) {
            Toast.makeText(getApplicationContext(), item.getTitle() + " " + item.getItemId() + " " + item.isChecked(), Toast.LENGTH_SHORT).show();
            item.setChecked(!item.isChecked());
            if (item.isChecked()) {
                title.setVisibility(View.INVISIBLE);
            } else {
                title.setVisibility(View.VISIBLE);
            }
        }
        else if (item.getTitle().toString().equals("Hide Subtitle")){
            item.setChecked(!item.isChecked());
            if (item.isChecked()){
                subtitle.setVisibility(View.INVISIBLE);
            }else {
                subtitle.setVisibility(View.VISIBLE);
            }
        }else if (item.getTitle().toString().equals("Next Action")){
            startActivity(new Intent(getApplicationContext(), AdditionalMenu.class));

        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.imageView).setOnLongClickListener(this);
        findViewById(R.id.imageView2).setOnLongClickListener(this);
        findViewById(R.id.imageView3).setOnLongClickListener(this);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigatin_view);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getTitle().equals("Nav Button")){
                    startActivity(new Intent(getApplicationContext(), AdditionalMenu.class));
                    return true;
                }
                return false;
            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.imageView2){
            menu.add(0, 1, Menu.NONE, "Change Title Font Size");
        }else  if (v.getId() == R.id.imageView){
            menu.add(0, 1, Menu.NONE, "Change Background Color");
        }else if (v.getId() == R.id.imageView3){
            menu.add(0, 1, Menu.NONE, "Change Title Color");
        }
            super.onCreateContextMenu(menu, v, menuInfo);


    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch ((String) item.getTitle()){
            case "Change Title Font Size": {
                TextView textView = findViewById(R.id.himymtitle);
                textView.setTextSize(10);
                break;
            }
            case "Change Background Color": {
                TextView textView = findViewById(R.id.title);
                textView.setBackgroundColor(Color.YELLOW);
                 break;
            }
            case "Change Title Color": {
                TextView textView = findViewById(R.id.tbbttitle);
                textView.setTextColor(Color.RED);
                break;
            }
            default:
                return true;
        }
        return true;
    }

    @Override
    public boolean onLongClick(View v) {
        registerForContextMenu(v);
        openContextMenu(v);
        return true;
    }
}