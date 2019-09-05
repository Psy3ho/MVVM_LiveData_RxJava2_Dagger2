package com.example.mvvm_livedata.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvm_livedata.model.Project;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProjectRepository {
    private GitHubConnection gitHubConnection;
    private static ProjectRepository projectRepository;

    public ProjectRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(gitHubConnection.HTTP_API_GITHUB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        gitHubConnection = retrofit.create(GitHubConnection.class);
    }

    public synchronized static ProjectRepository getInstance() {

        if (projectRepository == null) {
            projectRepository = new ProjectRepository();

        }
        return projectRepository;
    }




    public MutableLiveData<List<Project>> getProjectList(String userId) {
        final MutableLiveData<List<Project>> data = new MutableLiveData<>();

        gitHubConnection.getProjectList(userId).enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
                data.setValue(response.body());
                Log.i("internet", "uspech");
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {
                Log.i("internet", "neuspech");

                data.setValue(null);
            }
        });

        return data;
    }

    public LiveData<Project> getProjectDetails(String userID, String projectName) {

        final MutableLiveData<Project> data = new MutableLiveData<>();

        gitHubConnection.getProjectDetails(userID, projectName).enqueue(new Callback<Project>() {

            @Override
            public void onResponse(Call<Project> call, Response<Project> response) {

                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Project> call, Throwable t) {

                data.setValue(null);
            }
        });

        return data;
    }
}
