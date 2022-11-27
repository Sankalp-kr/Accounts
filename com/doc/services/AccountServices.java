package com.doc.services;
import com.doc.beans.Account;
import com.doc.beans.DematAccounts;
import com.doc.beans.SavingAccounts;

abstract public class AccountServices extends Account{
    public static Account[] demo_accs= new Account[10];
    public static int count_index;

    static{
        demo_accs[count_index]= new SavingAccounts(1,"Sankalp","+91-9558905711",99000,9876,"AB88#8");
        demo_accs[count_index]= new SavingAccounts(2,"Prem","+91-9979880986",89000,6074,"AB33#2");
        count_index++;
        demo_accs[count_index]= new DematAccounts(3,"Antra","+91-9558905711",79000,1234,50.0);
        count_index++;
        demo_accs[count_index] = new DematAccounts(4,"Neeraj","+91-9712940986",1000000,1974,100.0);
        count_index=4;
        //count_index++; do this before adding the next object in array
    }
    public  static String generatecCheckBookNum(String name, String ph){
        return name.substring(0,4) + ph.substring(11,14);
    }
    public static boolean validateWithdraw(int id, int pin, double amount){
        for(int i=0;i<=count_index;i++){
            if(demo_accs[i].getId()==id){
                if(demo_accs[i].getPin()==pin){
                    if(demo_accs[i].getBalance()>0){
                        if(amount>0){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean validate(int id, int pin){
        for(int i=0;i<=count_index;i++){
            if(demo_accs[i].getId()==id){
                if(demo_accs[i].getPin()==pin){
                    return true;
                }
            }
        }
        return false;
    }

    public static void createSavingAccount(int id, String name, String ph, double bal, int pin, String chkbk){
        if(count_index+1< demo_accs.length) {
            count_index++;
            demo_accs[count_index] = new SavingAccounts(id, name, ph, bal, pin, chkbk);
        }else {
            System.out.println("No new accounts can be created at the moment");
        }


    }

    public static void createDematAccount(int id, String name, String ph, double bal, int pin, double comm) {
        if(count_index+1< demo_accs.length) {
            count_index++;
            demo_accs[count_index] = new DematAccounts(id, name, ph, bal, pin, comm);
        }else {
            System.out.println("No new accounts can be created at the moment");
        }
    }

    public static void viewInfo(int id){
        for(int i=0;i<=demo_accs.length;i++){
            if(demo_accs[i].getId()==id){
                System.out.println(demo_accs[id]);
            }
        }
    }


}
