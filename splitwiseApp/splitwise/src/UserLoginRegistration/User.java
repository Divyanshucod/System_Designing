package UserLoginRegistration;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<RegistrationIN>ListOfRegistrations = new ArrayList<>();
    List<Login>ListOfLoginUsers = new ArrayList<>();
    public User(){
        this.ListOfRegistrations = new ArrayList<>();
        this.ListOfLoginUsers = new ArrayList<>();
    }
    public String CheckRegistration(String name,String email){
        for(RegistrationIN user:ListOfRegistrations){
            if(user.getEmail().equals(email)){
                return "Email is already registered!";
            }
            if(user.getName().equals(name)){
                return "UserName is already taken!";
            }
        }
        return "GoodToGO";
    }
    public void RegisterNewUser(String name,String email,String password){
        String Result = CheckRegistration(name,email);
        if(!Result.equals("GoodToGO")){
            System.out.println(Result);
            return;
        }
        ListOfRegistrations.add(new Registration(name,email,password));
        System.out.println("User Registered Successfully!");
    }
    public String CheckAbleToLogin(String password,String email){
        for(RegistrationIN user:ListOfRegistrations){
            if(user.getEmail().equals(email)){
                if(!user.getPassword().equals(password)){
                    return "Invalid Password!";
                }
                return "User Login Successfully!";
            }
        }
       return "User Not Registered!";
    }
    public boolean LoginUser(String email,String password){
        String Result = CheckAbleToLogin(password,email);
        if(Result.equals("Invalid Password!") || Result.equals("User Not Registered!")) {
            System.out.println(Result);
            return false;
        }
        ListOfLoginUsers.add(new Login(email,password));
        System.out.println("User Login Successfully!");
        return true;
    }
    public List<Login> getListOfLoginUsers(){
        return this.ListOfLoginUsers;
    }
    public List<RegistrationIN> getListOfRegistrationUsers(){
        return this.ListOfRegistrations;
    }
}
