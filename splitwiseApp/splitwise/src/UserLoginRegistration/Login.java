package UserLoginRegistration;

import GroupsManagement.Group;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;

public class Login {
    String email;
    String password;
    List<Group>listOfGroups;
    Login(String email,String password){
        this.email = email;
        this.password = password;
        this.listOfGroups = new ArrayList<>();
    }
    public void createGroups(Group group){
        this.listOfGroups.add(group);
        System.out.println("Group Created!");
    }
    public String getEmail(){
        return this.email;
    }
    public List<Group> Groups(){
        return this.listOfGroups;
    }
}
