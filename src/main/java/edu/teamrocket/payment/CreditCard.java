package edu.teamrocket.payment;

public class CreditCard {

 

    private final String owner;
    private final String number;
    private double credit;
    private final String SYMBOL;

    CreditCard(String owner, String number) {
        this.owner = owner;
        this.number = number;
        this.credit = 0.0;
        this.SYMBOL = "EZI";
    }

    Boolean pay (double charge) {
        if (this.credit >= charge) {
            this.credit -= charge;
            return true;
        }        return false;

    }

    String number() {
        return this.number;
    }

    String CardOwner() {
        return this.owner;
    }

    Double credit() {
        return this.credit;
    }

    
    @Override
    public String toString() {
        return "CreditCard [owner=" + owner + ", number=" + number + ", credit=" + credit + ", SYMBOL=" + SYMBOL
                + ", number()=" + number() + ", CardOwner()=" + CardOwner() + ", credit()=" + credit() + "]";
    }
}

