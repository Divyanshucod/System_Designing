package GroupsManagement;

import ExpenseP.Member;

import java.util.List;

public interface GroupInterface {
    public List<Member> getGroupMembers();
    public String getGroupName();
    public String getAdminName();
    public String getAdminEmail();
    public void setGroupName(String name);
    public void setAdminName(String adminName);
    public void setAdminEmail(String adminEmail);
    public void addMembers(String name,String email);
    public void removeMembers(String email);
}
