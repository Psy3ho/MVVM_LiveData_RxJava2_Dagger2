package com.example.mvvm_livedata.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.mvvm_livedata.R;

public class MainActivity extends AppCompatActivity {

    protected ProjectFragment projectFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            ProjectListFragment projectListFragment = new ProjectListFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, projectListFragment).commit();

        }


    }


    public void showProjectDetails(){
        projectFragment = new ProjectFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, projectFragment).commit();
    }
}
