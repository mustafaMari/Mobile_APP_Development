package com.example.lab5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.lab5.Placeholder.ItemData;
import com.example.lab5.Placeholder.ListFragment;
import com.example.lab5.Placeholder.ListFragmentInteractionListener;
import com.example.lab5.Placeholder.Repository;
import com.example.lab5.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ListFragmentInteractionListener {

    static Repository repository;
    private AppBarConfiguration appBarConfiguration;
    ListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new Repository(this.getApplication());


        com.example.lab5.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        listFragment = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_content_main);

        setSupportActionBar(binding.toolbar);
        assert listFragment != null;
        listFragment.setList(repository.getAllPeople());
        ActivityResultLauncher<Intent> rl = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        ItemData d = new ItemData();
                        assert data != null;
                        d.firstName = data.getStringExtra("FirstName");
                        d.lastName = data.getStringExtra("LastName");
                        d.age = data.getStringExtra("Age");
                        d.gender = data.getStringExtra("Gender");
                        repository.insertPerson(d);
                        listFragment.setList(repository.getAllPeople());

                    }
                }
        );
        binding.fab.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), AddPerson.class);
            rl.launch(i);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up add_button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onDeleteItem(ItemData itemData) {
        repository.deletePerson(itemData);
        listFragment.setList(repository.getAllPeople());
    }

    @Override
    public List<ItemData> getRepositoryList() {
        return repository.getAllPeople();
    }
}