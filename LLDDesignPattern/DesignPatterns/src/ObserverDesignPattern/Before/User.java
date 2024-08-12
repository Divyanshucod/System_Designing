package ObserverDesignPattern.Before;

import ObserverDesignPattern.After.Followers;
import ObserverDesignPattern.After.FollowersIn;
import ObserverDesignPattern.After.UserIn;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<Followers> listOfFollowers;
    String post;
    String name;
    public User(String name){
        this.listOfFollowers = new ArrayList<>();
        this.post = "No Posts!";
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


    public void addFollower(Followers follower) {
      listOfFollowers.add(follower);
    }


    public void removeFollower(Followers follower) {
      listOfFollowers.remove(follower);
    }


    public void notifyFollower() {
       for (Followers follower:listOfFollowers){
           follower.update();
       }
    }
    public String getPost() {
        return this.post;
    }
    public void setPost(String post) {
        this.post = post;
        notifyFollower();
    }
}
