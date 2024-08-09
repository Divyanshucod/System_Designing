package StrategyDesignPattern.After;

public class NotificationViaSms implements NotificationIn{

    @Override
    public void sendNotification(String messsage) {
        System.out.println(messsage+" sended via sms");
    }
}
