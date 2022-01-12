package com.example.lab3java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem checkableItem = menu.add("Item 1");
        checkableItem.setCheckable(true);
        menu.add("Item 2");
        menu.add(0,1,Menu.NONE, "Id Item 1");
        menu.add (0, 2, Menu.NONE, "Id Item 2");
        SubMenu subMenu = menu.addSubMenu(0,3,Menu.NONE,"SubMenu");
        subMenu.add(0,4,0,"SubMenu Item 1");
        subMenu.add(0,5,0,"SubMenu Item 2");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.isCheckable()){
            item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    item.setChecked(!item.isChecked());

                    return true;
                }
            });
            Toast.makeText(getApplicationContext(), item.getTitle() + " " + item.isChecked(), Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == 1) {
            startActivity(new Intent(getApplicationContext(), ExtraMenu.class));
            return true;
        }
        Toast.makeText(getApplicationContext(), item.getTitle() + " " + item.getItemId(), Toast.LENGTH_SHORT).show();
        return true;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.firstString){
            menu.add(0,1,Menu.NONE,"Item 1");
            menu.add(0,2,Menu.NONE,"Item 2");
        }else {
            menu.add(0,3,Menu.NONE,"Item 3");
            menu.add(0,4,Menu.NONE,"Item 4");
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == 3) {
            startActivity(new Intent(getApplicationContext(), ExtraMenu.class));
        }else {
            Toast.makeText(getApplicationContext(), item.getTitle() + " " + item.getItemId(), Toast.LENGTH_SHORT).show();
        }
        return true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerForContextMenu(findViewById(R.id.firstString));
        registerForContextMenu(findViewById(R.id.secondString));
    }
    public void openActionMode(View v){
        startActionMode(new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                menu.add(0,2,Menu.NONE,"Item 1");
                menu.add(0,3,Menu.NONE,"Item 3");
                menu.add(0,4,Menu.NONE,"Item 5");
                menu.add(0,5,Menu.NONE,"Item 7");
                menu.add(0,6,Menu.NONE,"Item 9");
                menu.add(0,7,Menu.NONE,"Item 11");
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                Toast.makeText(getApplicationContext(), item.getTitle() + " " + item.getItemId(), Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }
}