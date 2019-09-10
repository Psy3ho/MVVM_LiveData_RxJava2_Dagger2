package com.example.mvvm_livedata.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_livedata.model.Project;
import com.example.mvvm_livedata.repository.ProjectRepository;

import java.util.List;

public class ProjectListViewModel extends ViewModel {

    private MutableLiveData<List<Project>> project = new MutableLiveData<>();



    public void setProject() {
        this.project = ProjectRepository.getInstance().getProjectList("Psy3ho");

    }

    public LiveData<List<Project>> getProjectListObservable() {
        return project;
    }


}
