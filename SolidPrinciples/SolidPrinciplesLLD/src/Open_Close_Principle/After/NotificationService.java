package Open_Close_Principle.After;

public class NotificationService implements NotificationIn{
    NotificationIn obj = null;
    NotificationService(NotificationIn notificationObj){
        this.obj = notificationObj;
    }
    @Override
    public void sendNotification(String messsage) {
        obj.sendNotification(messsage);
    }
}
