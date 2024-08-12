import SIngleResposibilityPrinciple.After.InvoiceGenerator;
import SIngleResposibilityPrinciple.After.InvoiceSys;
import SIngleResposibilityPrinciple.After.PrintInvoice;
import SIngleResposibilityPrinciple.Before.Invoice;
import StrategyDesignPattern.After.NotificationIn;
import StrategyDesignPattern.After.NotificationService;
import StrategyDesignPattern.After.NotificationViaEmail;
import StrategyDesignPattern.After.NotificationViaSms;
import StrategyDesignPattern.Before.NoticationService;

import java.lang.reflect.GenericArrayType;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Before
        Invoice newInvoiceBeforeVersion = new Invoice("Rahul",8000);
        String generatedInvoice = newInvoiceBeforeVersion.GenerateInvoice();
        newInvoiceBeforeVersion.printInvoice();

        //After
        InvoiceSys newInvoiceAfterVersion = new InvoiceSys("Rahul",8000);
        InvoiceGenerator generator = new InvoiceGenerator();
         generatedInvoice = generator.generateInvoice(newInvoiceAfterVersion);
        PrintInvoice printers = new PrintInvoice();
        printers.printInvoice(generatedInvoice);

        // ----- Open_close principle ------
        //Before
        NoticationService obj = new NoticationService();
        obj.SendNotification("email","New Products added");

        //after
        NotificationIn emailNotification = new NotificationViaEmail();
        NotificationIn smsNotification = new NotificationViaSms();

        NotificationService notificationService = new NotificationService(emailNotification);
        notificationService.sendNotification("Product added");
        NotificationService notificationService2  = new NotificationService(smsNotification);
        notificationService2.sendNotification("Product added");
    }
}