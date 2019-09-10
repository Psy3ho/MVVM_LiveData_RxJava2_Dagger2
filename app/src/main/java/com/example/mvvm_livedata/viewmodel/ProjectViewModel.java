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

public class ProjectViewModel extends AndroidViewModel {

    private final LiveData<Project> projectLiveData;

    public ObservableField<Project> project = new ObservableField<>();

    private final String projectID;

    public ProjectViewModel(Application application, String projectID) {
        super(application);
        this.projectID = projectID;
        projectLiveData = ProjectRepository.getInstance().getProjectDetails("Psy3ho" ,projectID);
    }

    public LiveData<Project> getProjectLiveData() {
        return projectLiveData;
    }

    public void setProjectObservableField(Project project) {
        this.project.set(project);
    }

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
