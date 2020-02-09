package com.example.mvvm_livedata.model;

import java.util.Date;

/**
 * POJO class Project
 * Class intended for the user project with its attributes
 *
 * @author Eugen Benčat
 * @version 1.0
 * @date 2019-2020
 */
public class Project {

    /**
     * a public value
     * project id
     */
    public long id;
    /**
     * a public value
     * project name
     */
    public String name;
    /**
     * a public value
     * project full name
     */
    public String full_name;
    /**
     * a public value
     * project owner
     */
    public User owner;
    /**
     * a public value
     * project url in html
     */
    public String html_url;
    /**
     * a public value
     * project basic description
     */
    public String description;
    /**
     * a public value
     * project url
     */
    public String url;
    /**
     * a public value
     * the date the project was created
     */
    public Date created_at;
    /**
     * a public value
     * the date the project was updated
     */
    public Date updated_at;
    /**
     * a public value
     * the date the project was pushed on git
     */
    public Date pushed_at;
    /**
     * a public value
     * project git url
     */
    public String git_url;
    /**
     * a public value
     * project ssh url
     */
    public String ssh_url;
    /**
     * a public value
     * project url to clone repository
     */
    public String clone_url;
    /**
     * a public value
     * project svn url
     */
    public String svn_url;
    /**
     * a public value
     * project homepage
     */
    public String homepage;
    /**
     * a public value
     * stars count
     */
    public int stargazers_count;
    /**
     * a public value
     * watchers count
     */
    public int watchers_count;
    /**
     * a public value
     * the language in which the project was programmed
     */
    public String language;
    /**
     * a public value
     * project boolean value if he has ussues
     */
    public boolean has_issues;
    /**
     * a public value
     * project has downloads - boolean value
     */
    public boolean has_downloads;

    /**
     * a public value
     * project has wiki - boolean value
     */
    public boolean has_wiki;
    /**
     * a public value
     * project has pages - boolean value
     */
    public boolean has_pages;
    /**
     * a public value
     * project forks count
     */
    public int forks_count;
    /**
     * a public value
     * project issues count
     */
    public int open_issues_count;
    /**
     * a public value
     * project number of forks
     */
    public int forks;

    /**
     * a public value
     * project number of open issues
     */
    public int open_issues;
    /**
     * a public value
     * project number of watchers
     */
    public int watchers;
    /**
     * a public value
     * project default branch
     */
    public String default_branch;

    /**
     * Empty constructor
     */
    public Project() {
    }

    /**
     * Constructor with name
     *
     * @param name the user name of the project owner
     */
    public Project(String name) {
        this.name = name;
    }



    /**
     * Method that serves as getter of a name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method that serves as getter of a watchers count
     * @return watchers count
     */
    public String getWatchers_count() {
        String a = watchers_count + " ";
        return a;
    }

    /**
     * Method that serves as getter of a project language
     * @return language
     */
    public String getLanguage() {
        return language;
    }
}
