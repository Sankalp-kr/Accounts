package com.doc.beans;

public class SavingAccounts extends Account{

    private String cb_num;

    //S_IR & minbalance is made static bcz -->it would remain same for all the users of the saving account
    // --> we don't want it to occupy space in all the ojects when the values inside all the object will be same
    static private double S_IR;
    static private double min_balance;
    static{
        S_IR=0.07;
        min_balance=2000;
    }
    // default constructor
    public SavingAccounts() {super();}

    // paramterized constructor
    public SavingAccounts(int id, String name, String phone, double balance, int pin,String cb_num) {
        super(id,name,phone,balance,pin);
        this.cb_num = cb_num;
    }

    // getters
    public String getCb_num() {return cb_num;}
    public static double getsIr() {return S_IR;}

    //setters
    public void setCb_num(String cb_num) {this.cb_num = cb_num;}
    public static void setsIr(double sIr) {S_IR = sIr;}

    // checks will not be performed here
    @Override
    public void withdraw(double amount){
        //this condition should also be in services i guess
        if((this.getBalance()-amount)>min_balance)
            this.setBalance(this.getBalance()-amount);
    }

    @Override
    public String toString() {
        return "SavingAccounts{" +
                super.toString()+
                ", cb_num='" + cb_num + '\'' +
                '}';
    }

}

