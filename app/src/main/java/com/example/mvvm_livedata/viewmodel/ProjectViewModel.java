package com.example.mvvm_livedata.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvm_livedata.model.Project;
import com.example.mvvm_livedata.repository.ProjectRepository;

import java.util.Objects;

/**
 * Project ViewModel class
 *
 * This class is used for @ProjectFragment logic
 *
 * @author Eugen Benčat
 * @version 1.0
 * @date 2019-2020
 */
public class ProjectViewModel extends AndroidViewModel {

    /**
     * private final value
     * project live data
     */
    private final LiveData<Project> projectLiveData;

    /**
     * private final value
     * project live data for observe
     */
    public ObservableField<Project> project = new ObservableField<>();

    /**
     * private final value
     * project identification number
     */
    private final String projectID;

    public ProjectViewModel(Application application, String projectID) {
        super(application);
        this.projectID = projectID;
        //creating repository for specified user  - Psy3ho
        projectLiveData = ProjectRepository.getInstance().getProjectDetails("Psy3ho" ,projectID);
    }


    /**
     * Getter method return project live data
     *
     * @return project live data
     */
    public LiveData<Project> getProjectLiveData() {
        return projectLiveData;
    }

    /**
     * Setter method that set project
     *
     * @param project currently displayed
     */
    public void setProjectObservableField(Project project) {
        this.project.set(project);
    }

    /**
     * Factory class / used for ViewModels
     */
    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final Application application;

        private final String projectID;

        public Factory(@NonNull Application application, String projectID) {
            this.application = application;
            this.projectID = projectID;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return(T) new ProjectViewModel(application,projectID);
        }
    }
}
