package com.example.mvvm_livedata.repository;

import com.example.mvvm_livedata.model.Project;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Interface for GitHub connection
 *
 * This class uses RESTfull api to join github.
 *
 * @author Eugen Benčat
 * @version 1.0
 * @date 2019-2020

 */
interface GitHubConnection {

    /**
     * GitHub api url
     */
    String HTTP_API_GITHUB_URL = "https://api.github.com/";


    /**
     * RestFull API Call
     *
     * @param user user on GitHub
     * @return a list of user projects
     */
    @GET("users/{user}/repos")
    Call<List<Project>> getProjectList(@Path("user") String user);


    /**
     * RestFull API Call
     *
     * @param user logged in user on GitHub
     * @param projectName that was selected by the user
     * @return a project details
     */
    @GET("/repos/{user}/{reponame}")
    Call<Project> getProjectDetails(@Path("user") String user, @Path("reponame") String projectName);
}
