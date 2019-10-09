package com.mayab.calidad.doubles.tareaUnitTest;

public class Account {
	double balance;
    double comissions;
    int zone;
    AlertListener alerts;
    
    public Account() {
    	this.balance = 0.0;
    	this.comissions = 0.0;
    	this.zone = 0;
    }
    
    public Account(double comissions, double initialBalance, AlertListener alerts){
        this.comissions = comissions;
        this.balance = initialBalance;
        this.alerts = alerts;
    }
    
    public double getBalance() {
        return this.balance;
    }
    
    public double getComissions(){
        return this.comissions;
    }

    double withdraw(double quantity) {
        this.balance -= quantity;
        if(this.balance < 100){
            this.alerts.sendAlert("Warning, your account balance is below 100");
        }
        this.comissions += this.balance * (this.zone / 100.0);
        return this.balance;
    }

    void deposit(int quantity) {
        this.balance += quantity;
        this.comissions += this.balance * (this.zone / 100.0);

    }
    
    void setAlertListener(AlertListener listener){
        this.alerts = listener;
    }
}
