import ExpenseP.Expense;
import ExpenseP.Member;
import GroupsManagement.Group;
import Payment.Payment;
import UserLoginRegistration.Login;
import UserLoginRegistration.User;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class SplitWiseInAction {
    List<Expense>expensesList;
    List<Payment>paymentsList;
    List<Double>percentages = new ArrayList<>();
    List<String>emails = new ArrayList<>();
    boolean LoggedIn = false;
    Login LoggedUser = null;
    User user;
    SplitWiseInAction(){
        this.user = new User();
        this.expensesList = new ArrayList<>();
        this.paymentsList = new ArrayList<>();
         Action();
    }
    public void Action(){
        System.out.println("WELCOME TO SPLITWISE APP!");
        while(true){
            System.out.println("Choose Option");
            if(!LoggedIn){
                System.out.println("1 -> Login To Splitwise");
                System.out.println("2 -> Register To Splitwise");
            }
            if(LoggedIn){
                System.out.println("3 -> Add New Expense into Splitwise");
                System.out.println("4 -> Pay to Expense To Splitwise");
                System.out.println("5 -> Create Groups");
                System.out.println("6 -> Check History");
                System.out.println(" -> Type (exit) for exit <-");
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Choice: ");
            String inputValue = scanner.nextLine();
            if(inputValue.toLowerCase().equals("exit")){
                break;
            }
            MatchOptions(inputValue);
        }

    }
    public void MatchOptions(String options){
        switch (options){
            case "1":
                LoginFunction();
                break;
            case "2":
                RegistrationFunction();
                break;
            case "3":
                AddExpenseFunction();
                break;
            case "4":
                PaymentToExpenseFunction();
                break;
            case "5":
                CreateGroupFunction();
                break;
            case "6":
                CheckHistoryFunction();
                break;
            default:
                System.out.println("Invalid Option!");
                break;
        }
    }
    public void LoginFunction(){
        System.out.println("--------> Login To Splitwise <----------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Email: ");
        String Email = scanner.nextLine();
        System.out.println("Enter Password:");
        String Password = scanner.nextLine();
        boolean val =  user.LoginUser(Email,Password);
        LoggedIn = val;
    }
    public void RegistrationFunction(){
        System.out.println("--------> Register To Splitwise <----------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Email: ");
        String Email = scanner.nextLine();
        System.out.println("Enter Password:");
        String Password = scanner.nextLine();
        System.out.println("Enter Username:");
        String Username = scanner.nextLine();
        user.RegisterNewUser(Username,Email,Password);
    }
    public void AddExpenseFunction(){
        System.out.println("--------> Add New Expense To Splitwise <----------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Title: ");
        String title = scanner.nextLine();
        System.out.println("Enter Amount:");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter Type Of Distribution: Ex -> Equal,Percentage");
        String type = scanner.nextLine();
        List<Member>membersList = AddMembersInExpenseFunction(type);
        if(membersList.size() != 0) {
            Expense newExpense = new Expense(title, amount, membersList, type);
            if(type.toLowerCase().equals("equal")){
                newExpense.EqualDistribution();
            }
            else{
                newExpense.PercentageDistribution(emails,percentages);
                emails = new ArrayList<>();
                percentages = new ArrayList<>();
            }
            expensesList.add(newExpense);
        }
    }
    public void PaymentToExpenseFunction(){
        System.out.println("--------> Payment To Expense <----------");
        while(true){
            System.out.println("Choose Option");
            System.out.println("1 -> Show Expense Info");
            System.out.println("2 -> Pay To Expense");
            System.out.println("E -> Exit");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Choice: ");
            String inputValue = scanner.nextLine();
            if(inputValue.toLowerCase().equals("e"))
                break;
            if(inputValue.equals("2")){
                System.out.println("Enter ExpenseId:");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter Your Email:");
                String email = scanner.nextLine();
                System.out.println("Enter Amount:");
                double amount = scanner.nextDouble();
                Payment newPayment = new Payment();
                if(newPayment.DoPayment(expensesList,id,email,amount) == false){
                    continue;
                }
                paymentsList.add(newPayment);
            }
            if(inputValue.equals("1")){
                printExpenseDetails();
            }
        }
    }
    public void CreateGroupFunction(){
        System.out.println("--------> Create Groups <----------");
        while(true){
            System.out.println("Choose Option");
            System.out.println("1 -> Show Existing Groups");
            System.out.println("2 -> Create New Group");
            System.out.println("E -> Exit");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Choice: ");
            String inputValue = scanner.nextLine();

            if(inputValue.toLowerCase().equals("e"))
                break;

            if(inputValue.equals("2")){
                System.out.println("Enter GroupName:");
                String GroupName = scanner.nextLine();
                System.out.println("Enter AdminName:");
                String admin = scanner.nextLine();
                System.out.println("Enter AdminEmail:");
                String aemail = scanner.nextLine();
                //group creation
                List<Member>GroupMembers = createMembersList("Notype");
                for (Login login:user.getListOfLoginUsers()){
                    if(login.getEmail().equals(aemail)){
                        LoggedUser = login;
                        break;
                    }
                }
                if(LoggedUser != null){
                    Group group = new Group(GroupMembers,GroupName,admin,aemail);
                    LoggedUser.createGroups(group);
                }
                else{
                    System.out.println("First Login To create Groups");
                }
            }
            if(inputValue.equals("1")){
               printGroupInfo(LoggedUser);
            }
        }
    }
    public void CheckHistoryFunction() {
        System.out.println("--------> Check Payment History <----------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Email: ");
        String email = scanner.nextLine();
        if(paymentsList.size() == 0){
            System.out.println("No payment done by you!");
            return;
        }
        for (Payment payment : paymentsList) {
            if (payment.getPayerEmail().equals(email)) {
                System.out.println("Amount: " + payment.getPayedAmount() + " ExpenseId: " + payment.getPayedExpenseId());
            }
        }
    }
    public List<Member> AddMembersInExpenseFunction(String type){
        System.out.println("-> Add Members <-");

        if(type.toLowerCase().equals("equal")){
            System.out.println("Enter Name and Email: EX. Rahul,rahul@gmail.com");
            System.out.println("For Exit Enter -> E");
            return createMembersList(type);
        }
        else if(type.equals("percentage")){
            System.out.println("Enter Name and Email: EX. Rahul,rahul@gmail.com");
            System.out.println("For Exit Enter -> E");
            return createMembersList(type);
        }
        else{
            System.out.println("Invalid Type");
        }
        return new ArrayList<>();
    }
     public List<Member> createMembersList(String type){
         if(type.equals("Notype")){
             System.out.println("Enter Name and Email: EX. Rahul,rahul@gmail.com");
             System.out.println("For Exit Enter -> E");
         }
         List<Member>listofmembers = new ArrayList<>();
         while(true){
             System.out.println("Enter Member Info: ");
            Scanner scanner = new Scanner(System.in);
            String inputValue = scanner.nextLine();
             if(inputValue.toLowerCase().equals("e"))
                 break;
             double percentage =0;
             if(type.toLowerCase().equals("percentage")){
                 System.out.println("Enter Percentage: ");
                 percentage = scanner.nextDouble();
             }
            String[] nameAndemail = inputValue.split(",");
            Member newMember = new Member(nameAndemail[0],nameAndemail[1]);
            if(listofmembers.contains(newMember)){
                System.out.println("Member Already Exist!");
                continue;
            }
            if (type.toLowerCase().equals("percentage")){
                percentages.add(percentage);
            }
            emails.add(nameAndemail[1]);
            listofmembers.add(newMember);
        }
         return listofmembers;
    }
    public void printExpenseDetails(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Email: ");
        String email = scanner.nextLine();

        for (Expense expense:expensesList) {
            for (Member member : expense.getMembers()) {
                if (member.getEmail().equals(email)) {
                    System.out.println("ExpenseId: "+expense.getId()+" Expense-title: "+expense.getTitle()+" Expense-Amount: "+expense.getAmount()+" Debt: "+member.getAmount());
                    break;
                }
            }
        }
    }
    public void printGroupInfo(Login obj){
        if(obj == null){
            System.out.println("No Group Exist!");
            return;
        }
        for (Group group:obj.Groups()) {
            System.out.println("------------> Group <-------------");
            System.out.println("GroupName: "+group.getGroupName()+" Group-Admin: "+group.getAdminName()+" Group-Admin-Email: "+group.getAdminEmail());
            System.out.println("------------> Members <-------------");
            for (Member member : group.getGroupMembers()) {
                    System.out.println("MemberName: "+member.getName()+" Member-Email: "+member.getEmail());
                }
            }
        }
}
