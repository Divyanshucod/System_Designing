import StrategyDesignPattern.After.NotificationIn;
import StrategyDesignPattern.After.NotificationService;
import StrategyDesignPattern.After.NotificationViaEmail;
import StrategyDesignPattern.After.NotificationViaSms;
import StrategyDesignPattern.Before.NoticationService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
      //Before
        NoticationService obj = new NoticationService();
        obj.SendNotification("email","New Products added");

        //after
        NotificationIn emailNotification = new NotificationViaEmail();
        NotificationIn smsNotification = new NotificationViaSms();

        NotificationService notificationService = new NotificationService(emailNotification);
        notificationService.sendNotification("Product added");
        NotificationService notificationService2  = new NotificationService(smsNotification);
        notificationService2.sendNotification("Product added");
    }
}