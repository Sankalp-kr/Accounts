package com.doc.beans;

public class DematAccounts extends Account{

    private double comm;

    public static double D_IR;

    static{
        D_IR=0.08;
    }

    // default constructor
    public DematAccounts() {
        super();
        comm=0.0;
    }
    // parameterized constructor
    public DematAccounts(int id, String name, String mobile, double balance, int pin, double comm) {
        super(id, name, mobile, balance, pin);
        this.comm = comm;
    }

    //getters
    public double getComm() {return comm;}

    public static double getdIr() {return D_IR;}

    //setters
    public void setComm(double comm) {this.comm = comm;}

    public static void setdIr(double dIr) {D_IR = dIr;}

    //no critical checks would be performed here
    @Override
    public void withdraw(double amount) {
        if(amount<5000){
            this.setBalance(this.getBalance()-amount);
        }
    }

    @Override
    public String toString() {
        return "DematAccounts{" +
                super.toString()+
                " comm='" + comm + "%\'"+
                "} ";
    }



}
