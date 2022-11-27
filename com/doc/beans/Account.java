package com.doc.beans;

abstract public class Account {
    //---> worked all fine with private untill i created demoDB class
    //--> we need some of the variables there to create customized id etc.. --> so changing them to protected

    protected int id;
    protected String name;
    protected String mobile;
    private double balance;
    private int pin;

    // default constructor
    public Account() {this(0,null,null,0.0,0000);}

    // parameterized constructor
    public Account(int id, String name, String mobile, double balance, int pin) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.balance = balance;
        this.pin = pin;
    }

    // getters
    public int getId() {return id;}

    public String getName() {return name;}

    public String getMobile() {return mobile;}

    public double getBalance() {return balance;}

    public int getPin() {return pin;}


    // setters
    public void setId(int id) {this.id = id;}

    public void setName(String name) {this.name = name;}

    public void setMobile(String mobile) {this.mobile = mobile;}

    public void setBalance(double balance) {this.balance = balance;}

    public void setPin(int pin) {this.pin = pin;}

    abstract public void withdraw(double amount);


    public void deposit(double amount){
        if(amount>0)
            this.balance+=amount;
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", balance='" + balance + '\''+
                ", pin='" + pin +'\''+
                '}';
    }
}
