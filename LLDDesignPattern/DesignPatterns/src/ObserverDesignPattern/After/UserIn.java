package ObserverDesignPattern.After;

public interface UserIn {
    public String getName();
    public void addFollower(FollowersIn follower);
    public void removeFollower(FollowersIn follower);
    public void notifyFollower();
    public String getPost();
    public void setPost(String post);
}
