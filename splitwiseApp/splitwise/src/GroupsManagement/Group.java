package GroupsManagement;

import ExpenseP.Member;

import java.util.ArrayList;
import java.util.List;

public class Group implements GroupInterface{
    String GroupName;
    List<Member>members;
    String adminName;
    String adminEmail;
    public Group(){
        this.GroupName = "";
        this.members = new ArrayList<>();
        this.adminEmail = "";
        this.adminName = "";
    }
    public Group(List<Member>members,String GroupName,String adminName,String adminEmail){
        this.GroupName = GroupName;
        this.members = members;
        this.adminName = adminName;
        this.adminEmail = adminEmail;
    }
    @Override
    public List<Member> getGroupMembers() {
        return this.members;
    }

    @Override
    public String getGroupName() {
        return this.GroupName;
    }
    public void setGroupName(String name) {
         this.GroupName = name;
    }
    public void setAdminName(String adminName){
         this.adminName = adminName;
    }
    public void setAdminEmail(String adminEmail){
         this.adminEmail = adminEmail;
    }
    public String getAdminName(){
        return this.adminName;
    }
    public String getAdminEmail(){
        return this.adminEmail;
    }
    @Override
    public void addMembers(String name,String email) {
        //exists
        for(Member member : members){
            if(member.getEmail() == email){
                System.out.println("member already exits!");
                return;
            }
        }
        members.add(new Member(name,email));
    }

    @Override
    public void removeMembers(String email) {
        //check exist
        boolean exist = false;
        for (Member member:members){
            if(member.getEmail() == email){
                exist = true;
            }
        }
        if(exist == false){
            System.out.println("Not Exits!");
            return;
        }
        members.removeIf(member -> member.getEmail() == email);
    }
}
