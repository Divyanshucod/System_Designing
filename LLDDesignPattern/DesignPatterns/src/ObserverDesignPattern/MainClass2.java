package ObserverDesignPattern;

import ObserverDesignPattern.After.Followers;
import ObserverDesignPattern.After.User;

public class MainClass2 {
    public static void main(String[] args){
        //------------ observer design pattern -------------
        //Before //After (in both cases this code will be same the difference is how you implement it) see explanation.
        User user = new User("Rahul");
        Followers follower1 = new Followers(user,"Raju");
        Followers follower2 = new Followers(user,"Mohan");
        Followers follower3 = new Followers(user,"Midoriya");
        user.addFollower(follower1);
        user.addFollower(follower2);
        user.addFollower(follower3);
        user.setPost("Posting image");
    }
}
