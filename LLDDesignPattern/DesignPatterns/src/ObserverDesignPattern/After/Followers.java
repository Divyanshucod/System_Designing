package ObserverDesignPattern.After;

public class Followers implements FollowersIn{
    UserIn user;
    String name;
    public Followers(UserIn user,String name){
        this.user = user;
        this.name = name;
    }
    @Override
    public void update() {
        System.out.println("Hi! "+this.name+" "+user.getName()+" posted a "+user.getPost());
    }
}
