package StrategyDesignPattern.After;

public class NotificationService implements NotificationIn{
    NotificationIn obj = null;
    public NotificationService(NotificationIn notificationObj){
        this.obj = notificationObj;
    }
    @Override
    public void sendNotification(String messsage) {
        obj.sendNotification(messsage);
    }
}
