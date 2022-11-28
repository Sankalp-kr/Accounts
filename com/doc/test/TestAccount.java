package com.doc.test;

import java.util.Scanner;


import com.doc.beans.Account;
import com.doc.services.AccountServices;

public class TestAccount {
    public static void main(String[] args) {
        Scanner ins = new Scanner(System.in);

        int choice=99;

        while(choice!=7){

            // Menu
            System.out.println("Menu:\n1.Withdraw Amount\n2.Deposit Amount\n"
                    + "3.Check Balance\n4.Change pin num\n"
                    + "5.Open new account\n" +
                    "6. View All info\n"+
                    "7.Exit");
            choice = ins.nextInt();

            switch (choice){

                case 1:
                    System.out.println("Enter the id of the registered customer: ");
                    int id= ins.nextInt();
                    System.out.println("Enter the pin for customerID num["+id+"]: ");
                    int pin= ins.nextInt();
                    System.out.println("Enter the amount to be withdrawn: ");
                    double amount = ins.nextDouble();
                    if(AccountServices.validateWithdraw(id,pin,amount))
                        AccountServices.demo_accs[id].withdraw(amount);

                    break;

                case 2:
                    System.out.println("Enter the id of the registered customer: ");
                    int dep_id= ins.nextInt();
                    System.out.println("Enter the pin for customerID num["+dep_id+"]: ");
                    int dep_pin= ins.nextInt();
                    System.out.println("Enter the amount to deposit: ");
                    double dep_amount= ins.nextDouble();
                    if(AccountServices.validate(dep_id,dep_pin))
                        AccountServices.demo_accs[dep_id].deposit(dep_amount);

                    break;

                case 3:
                    System.out.println("Enter the id of the registered customer: ");
                    int id3= ins.nextInt();
                    System.out.println("Enter the pin for customerID num["+id3+"]: ");
                    int pin3= ins.nextInt();
                    if(AccountServices.validate(id3,pin3)){
                        System.out.println(AccountServices.demo_accs[id3].getBalance());
                    }

                    break;

                case 4:
                    System.out.println("Enter the id of the registered customer: ");
                    int id4= ins.nextInt();
                    System.out.println("Enter the pin for customerID num["+id4+"]: ");
                    int pin4= ins.nextInt();
                    if(AccountServices.validate(id4,pin4)) {
                        System.out.println("Enter the new 4digit pin: ");
                        int newpin=ins.nextInt();
                        AccountServices.demo_accs[id4].setPin(newpin);
                    }

                    break;

                case 5:
                    //Open new account
                    System.out.println("Enter the type of account that you want to open: \n1.Savings\n2.Demat");
                    int acc_choice= ins.nextInt();
                    if (acc_choice==1){
                        int id5=AccountServices.count_index;
                        System.out.println("Enter the name of account holder: ");
                        String name51=ins.next();
                        System.out.println("Enter the Phone number: ");
                        String ph1=ins.next();
                        System.out.println("Iniial balance: ");
                        double bal1=ins.nextDouble();
                        System.out.println("Enter initial pin: ");
                        int pin51=ins.nextInt();
                        String chkbook=AccountServices.generatecCheckBookNum(name51,ph1);
                        AccountServices.createSavingAccount(id5,name51,ph1,bal1,pin51,chkbook);
                    }
                    else if( acc_choice==2){
                        int id52=AccountServices.count_index;
                        System.out.println("Enter the name of account holder: ");
                        String name52=ins.next();
                        System.out.println("Enter the Phone number: ");
                        String ph2=ins.next();
                        System.out.println("Iniial balance: ");
                        double bal2=ins.nextDouble();
                        System.out.println("Enter initial pin: ");
                        int pin52=ins.nextInt();
                        System.out.println("Enter the commision for the user: ");
                        double comm=ins.nextDouble();
                        AccountServices.createDematAccount(id52,name52,ph2,bal2,pin52,comm);
                    }

                    break;

                case 6:
                    //view all info
                    System.out.println("Enter the id of the customer you want to view the entire info of: ");
                    int viewchoice=ins.nextInt();
                    AccountServices.viewInfo(viewchoice);

                    break;




                case 7:
                    System.out.println("Thank you for using our Application..");
            }
        } 
    }
}
