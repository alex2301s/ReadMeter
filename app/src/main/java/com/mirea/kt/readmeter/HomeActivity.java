package com.mirea.kt.readmeter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements PersonAdapter.OnPersonClickListener {
    private Button bFlash;
    private FlashClass flashClass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);  
        ActionBar tb1 = getSupportActionBar();
        if (tb1 != null) {
//            tb1.setTitle("Second");
            tb1.setHomeButtonEnabled(true);
            tb1.setDisplayHomeAsUpEnabled(true);
        }


        getSupportActionBar().setTitle("ReadMeter");
        replaceFragment(new WaterFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.first) {
                replaceFragment(new WaterFragment());
                return true;
            } else if (itemId == R.id.second) {
                replaceFragment(new ElectricalFragment());
                return true;
            } else if (itemId == R.id.third) {
                replaceFragment(new RaschetesFragment());
                return true;
            }
            return false;
        });
        init();

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Холодная", "вода", 1055, null));
        persons.add(new Person("Горячая", "вода", 18345, null));
        persons.add(new Person("Холодная", "вода", 2836, null));
        persons.add(new Person("Горячая", "вода", 4537, null));
        persons.add(new Person("Холодная", "вода", 280036, null));
        persons.add(new Person("Горячая", "вода", 450037, null));
        persons.add(new Person("Холодная", "вода", 2230036, null));
        persons.add(new Person("Горячая", "вода", 4770037, null));
        persons.add(new Person("Холодная", "вода", 2190036, null));
        persons.add(new Person("Горячая", "вода", 9340037, null));
        RecyclerView rcView = findViewById(R.id.recyclerView);
        PersonAdapter adapter = new PersonAdapter(persons, this);
        rcView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcView.setAdapter(adapter);

    }
    @Override
    public void onPersonClick(Person person, int position) {
        Toast.makeText(this, "Click on" + person.getFirstName() + " "+ person.getLastName(), Toast.LENGTH_LONG).show();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_delete) {
            Toast.makeText(this, "Click delete icon on Toolbar", Toast.LENGTH_LONG).show();
            return true;
        } else if (itemId == R.id.action_add) {
            Toast.makeText(this, "Click add on Toolbar", Toast.LENGTH_LONG).show();
            return true;

//        } else if (itemId == R.id.action_highlight) {
//            finish();
//            return true;
        } else if (itemId == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.relative_layout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void init(){
        bFlash = findViewById(R.id.b1);
        flashClass = new FlashClass(this);

    }
    public void OnClickFlash(View view){
        if(flashClass.isFlash_status()){
            flashClass.flashOff();
            bFlash.setText("On");
        }
        else{
            flashClass.flashOn();
            bFlash.setText("Off");
        }
    }


}


