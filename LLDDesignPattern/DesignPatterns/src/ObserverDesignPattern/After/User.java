package ObserverDesignPattern.After;

import java.util.ArrayList;
import java.util.List;

public class User implements UserIn{
    List<FollowersIn> listOfFollowers;
    String post;
    String name;
    public User(String name){
        this.listOfFollowers = new ArrayList<>();
        this.post = "No Posts!";
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFollower(FollowersIn follower) {
      listOfFollowers.add(follower);
    }

    @Override
    public void removeFollower(FollowersIn follower) {
      listOfFollowers.remove(follower);
    }

    @Override
    public void notifyFollower() {
       for (FollowersIn follower:listOfFollowers){
           follower.update();
       }
    }

    @Override
    public String getPost() {
        return this.post;
    }

    @Override
    public void setPost(String post) {
        this.post = post;
        notifyFollower();
    }
}
