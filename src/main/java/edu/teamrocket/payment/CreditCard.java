package edu.teamrocket.payment;

public class CreditCard implements PaymentMethod {

 

    private final String owner;
    private final String number;
    private double credit = 3000d;
    private final String SYMBOL = "EZI";

    public CreditCard(String owner, String number) {
        this.owner = owner;
        this.number = number;
    }

    public boolean pay (double charge) {
        if (this.credit -1 >= charge) {
            this.credit -= charge;
            return true;
        }        return false;

    }

    public String number() {
        return this.number;
    }

    public String cardOwner() {
        return this.owner;
    }

    public double credit() {
        return this.credit;
    }
    
    @Override
    public String toString() {
        return "CreditCard [owner=" + owner + ", number=" + number + ", credit=" + credit + ", SYMBOL=" + SYMBOL
                + ", number()=" + number() + ", cardOwner()=" + cardOwner() + ", credit()=" + credit() + "]";
    }
}

