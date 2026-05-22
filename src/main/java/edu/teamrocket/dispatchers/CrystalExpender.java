package edu.teamrocket.dispatchers;

import edu.teamrocket.receptivo.GuestDispatcher;


import edu.teamrocket.payment.CreditCard;

public class CrystalExpender implements GuestDispatcher{

    private int stock;
    private double itemCost;

    public CrystalExpender (int stock, double itemCost) {
        this.stock = stock;
        this.itemCost = itemCost;
    }

    public void dispatch (CreditCard card){
        if (this.stock > 0 && card.pay(itemCost))
            this.stock -= 1;

    }

    


    @Override
    public String toString() {
        return "CrystalExpender [stock=" + stock + ", itemCost=" + itemCost + "]";
    }

    public int stock () {
        return this.stock;
    }



}