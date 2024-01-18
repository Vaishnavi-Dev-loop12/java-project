package project;

import java.util.Scanner;

public class BankingApplication
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        BankAccount c1 = new BankAccount("vaishu","C1");
        c1.showMenu();
    }
}
class BankAccount
{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    //constructor
    BankAccount(String customerName, String customerId){
        this.customerName = customerName;
        this.customerId = customerId;
    }

    void deposite(int amount)
    {
        if(amount > 0)
        {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }
//    amount
    void withDraw(int amount)
    {
        if(amount > 0 && balance > amount)
        {
            balance = balance-amount;
            previousTransaction = -amount;
        }
    }
    void getPriviosTransaction()
    {
        if(previousTransaction > 0){
            System.out.println("Depposite : " + previousTransaction);
        }
        else if (previousTransaction<0){
            System.out.println("withdrow : "+Math.abs(previousTransaction));
        }
        else{
            System.out.println("No transaction is occurred!");
        }
    }
    void showMenu(){
        char option = '\0';
        Scanner sc = new Scanner(System.in);
        System.out.println("Wellcome : "+customerName);
        System.out.println("your id is customer id : " +customerId);
        System.out.println();
        System.out.println("A. check balance");
        System.out.println("B. Deposit");
        System.out.println("C. WithDrow");
        System.out.println("D. previos Transaction");
        System.out.println("E. Exit");

        do{
            System.out.println("=====================================");
            System.out.println("Enter the option");
            System.out.println("======================================");
            option = sc.next().charAt(0);
            option = Character.toUpperCase(option);
            switch (option){
                case 'A':
                    System.out.println("=================================");
                    System.out.println("Balance is  "+balance);
                    System.out.println("=================================");
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("=================================");
                    System.out.println("Enter the amount to deposit");
                    System.out.println("=================================");
                    int amount = sc.nextInt();
                    deposite(amount);
                    System.out.println();
                    break;
                case 'C':
                    System.out.println("=================================");
                    System.out.println("Enter the amount to withdrow");
                    System.out.println("=================================");
                    int amount2 = sc.nextInt();
                    withDraw(amount2);
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("=================================");
                    getPriviosTransaction();
                    System.out.println("=================================");
                    break;
                case 'E':
                    System.out.println("=================================");
                   break;
                default:
                    System.out.println("Invalid Option! Please try again");
            }
        }while(option != 'E');

    }
}
