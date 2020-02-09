package com.example.mvvm_livedata.model;
import java.util.Date;

/**
 * POJO class User
 * Class intended for users with its attributes
 *
 * @author Eugen Benčat
 * @version 1.0
 * @date 2019-2020
 */
public class User {

    /**
     * a public value
     * user login
     */
    public String login;

    /**
     * a public value
     * user id
     */
    public long id;
    /**
     * a public value
     * url image of user avatar
     */
    public String avatar_url;
    /**
     * a public value
     * user avatar image id
     */
    public String gravatar_id;
    /**
     * a public value
     * user url
     */
    public String url;
    /**
     * a public value
     * user html url
     */
    public String html_url;
    /**
     * a public value
     * url for list of followers
     */
    public String followers_url;
    /**
     * a public value
     * url for list of following
     */
    public String following_url;
    /**
     * a public value
     * urls for list gists
     */
    public String gists_url;
    /**
     * a public value
     * urls for starred
     */
    public String starred_url;
    /**
     * a public value
     * urls for subscriptions
     */
    public String subscriptions_url;
    /**
     * a public value
     * url of organization where user work
     */
    public String organizations_url;
    /**
     * a public value
     * urls for repositories
     */
    public String repos_url;
    /**
     * a public value
     * urls for events
     */
    public String events_url;
    /**
     * a public value
     * urls for received events
     */
    public String received_events_url;
    /**
     * a public value
     * users gender
     */
    public String type;
    /**
     * a public value
     * users name
     */
    public String name;
    /**
     * a public value
     * users blog
     */
    public String blog;
    /**
     * a public value
     * users location
     */
    public String location;
    /**
     * a public value
     * users email
     */
    public String email;
    /**
     * a public value
     * number of public repositories
     */
    public int public_repos;
    /**
     * a public value
     * number of public gists
     */
    public int public_gists;
    /**
     * a public value
     * number of followers
     */
    public int followers;
    /**
     * a public value
     * number of following
     */
    public int following;
    /**
     * a public value
     * the date the account was created
     */
    public Date created_at;
    /**
     * a public value
     * the date of the update
     */
    public Date updated_at;
}
