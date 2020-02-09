package com.example.mvvm_livedata.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.mvvm_livedata.R;
import com.example.mvvm_livedata.model.Project;

/**
 * Activity for loading layout resources
 *
 * This activity is used to display different layout resources.
 * This activity serves to display the main application screen with two different fragments.
 *
 * @author Eugen Benčat
 * @version 1.0
 * @date 2019-2020
 */
public class MainActivity extends AppCompatActivity {

    /**
     * a protected value
     * a ProjectFragment value to initialize and select the fragment
     */
    protected ProjectFragment projectFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // if != null - > show last closed app preview
        if(savedInstanceState == null) {
            ProjectListFragment projectListFragment = new ProjectListFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, projectListFragment).commit();

        }


    }


    /**
     * Method that displays the user selected project on the next fragment
     *
     * @param project that was selected by the user
     */
    public void showProjectDetails(Project project){
        projectFragment = new ProjectFragment().forProject(project.name);
        getSupportFragmentManager().beginTransaction().addToBackStack("project").replace(R.id.fragment_container, projectFragment,null).commit();
    }
}
