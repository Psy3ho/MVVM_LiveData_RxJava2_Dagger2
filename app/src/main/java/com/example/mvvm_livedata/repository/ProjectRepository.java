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

/**
 * Project Repository
 *
 * Class designed as a repository for calling the GitHub API for a user or project
 *
 * @author Eugen Benčat
 * @version 1.0
 * @date 2019-2020
 */
public class ProjectRepository {

    /**
     * a private value
     * interface value for GitHub connection
     */
    private GitHubConnection gitHubConnection;

    /**
     * a private value
     * project repository
     */
    private static ProjectRepository projectRepository;


    /**
     * Constructor without parameters
     *
     * Used technology for build connection - Retrofit
     */
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



    /**
     * Method that displays the user selected project on the next fragment
     *
     * @param userId that was selected by the user
     * @return Mutable list of projects
     */
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

    /**
     * Method that displays the user selected project on the next fragment
     *
     * @param userID user identification number
     * @param projectName name of the project
     * @return mutable data about project
     */
    public MutableLiveData<Project> getProjectDetails(String userID, String projectName) {

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
