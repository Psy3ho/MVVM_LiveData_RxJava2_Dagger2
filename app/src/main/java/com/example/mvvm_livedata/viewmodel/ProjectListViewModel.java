package com.example.mvvm_livedata.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_livedata.model.Project;
import com.example.mvvm_livedata.repository.ProjectRepository;

import java.util.List;


/**
 * Project ViewModel class
 *
 * This class is used for @ProjectListFragment logic
 *
 * @author Eugen Benčat
 * @version 1.0
 * @date 2019-2020
 */
public class ProjectListViewModel extends ViewModel {


    /**
     * private value
     * mutable data / list of projects
     */
    private MutableLiveData<List<Project>> project = new MutableLiveData<>();


    /**
     * Setter method
     *
     * method for call repository and show list of project of specified user
     */
    public void setProject() {
        this.project = ProjectRepository.getInstance().getProjectList("Psy3ho");

    }

    /**
     * Getter method
     *
     * method for get live data of List of projects
     */
    public LiveData<List<Project>> getProjectListObservable() {
        return project;
    }


}
