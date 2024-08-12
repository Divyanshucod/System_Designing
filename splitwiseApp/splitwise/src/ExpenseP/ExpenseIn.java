package ExpenseP;

import java.util.List;

public interface ExpenseIn {
    public double getAmount();
    public String getTitle();
    public List<Member> getMembers();
    public int getId();
}
