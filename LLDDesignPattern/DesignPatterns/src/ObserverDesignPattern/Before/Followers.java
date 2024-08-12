package ObserverDesignPattern.Before;

import ObserverDesignPattern.After.FollowersIn;
import ObserverDesignPattern.After.UserIn;

public class Followers{
    User user;
    String name;
    public Followers(User user, String name){
        this.user = user;
        this.name = name;
    }
    public void update() {
        System.out.println("Hi! "+this.name+" "+user.getName()+" posted a "+user.getPost());
    }
}
