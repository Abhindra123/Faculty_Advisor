package com.sonait.facultyadvisor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Student extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        bottomNavigationView = findViewById(R.id.bottomNavigationView1);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.sadd);
    }

    StudentViewFragment svf= new StudentViewFragment();
    StudentAddFragment sdf = new StudentAddFragment();
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.sadd:
                getSupportFragmentManager().beginTransaction().replace(R.id.student_container, sdf).commit();
                return true;
            case R.id.sview:
                getSupportFragmentManager().beginTransaction().replace(R.id.student_container, svf).commit();
                return true;
        }
        return false;
    }
}
