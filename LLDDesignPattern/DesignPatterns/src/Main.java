import ObserverDesignPattern.After.Followers;
import ObserverDesignPattern.After.User;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //------------ Strategy Design Pattern -------------
       //Before
//        NoticationService obj = new NoticationService();
//        obj.SendNotification("email","New Products added");
//
//        //after
//        NotificationIn emailNotification = new NotificationViaEmail();
//        NotificationIn smsNotification = new NotificationViaSms();
//
//        NotificationService notificationService = new NotificationService(emailNotification);
//        notificationService.sendNotification("Product added");
//        NotificationService notificationService2  = new NotificationService(smsNotification);
//        notificationService2.sendNotification("Product added");
        //------------ observer design pattern -------------
        //Before

        //After
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