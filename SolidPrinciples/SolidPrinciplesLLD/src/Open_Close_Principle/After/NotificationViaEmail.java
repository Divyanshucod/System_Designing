package Open_Close_Principle.After;

public class NotificationViaEmail implements NotificationIn{

    @Override
    public void sendNotification(String messsage) {
        System.out.println(messsage+" sended via email");
    }
}
