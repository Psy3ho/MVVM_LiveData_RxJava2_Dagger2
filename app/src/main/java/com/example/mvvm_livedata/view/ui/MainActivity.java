package com.example.mvvm_livedata.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.mvvm_livedata.R;
import com.example.mvvm_livedata.model.Project;

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


    public void showProjectDetails(Project project){
        projectFragment = new ProjectFragment().forProject(project.name);
        getSupportFragmentManager().beginTransaction().addToBackStack("project").replace(R.id.fragment_container, projectFragment,null).commit();
    }
}
