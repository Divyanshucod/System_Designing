package Open_Close_Principle.Before;

public class NoticationService {
    public void SendNotification(String method,String message){
        if(method.equals("email")){
            sendViaEmail(message);
        }
        else if(method.equals("push-notification")){
            sendViaPushNotification(message);
        }
        else{
            System.out.println("Invalid Method");
        }
    }
    public void sendViaEmail(String message){
        System.out.println(message + " sended via email");
    }
    public void sendViaPushNotification(String message){
        System.out.println(message + " sended via push notification");
    }
}
