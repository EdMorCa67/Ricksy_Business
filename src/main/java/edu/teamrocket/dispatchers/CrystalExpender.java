package edu.teamrocket.dispatchers;

import edu.teamrocket.receptivo.GuestDispatcher;

import java.util.Map;

import edu.teamrocket.payment.CreditCard;
import edu.teamrocket.payment.PaymentMethod;

public class CrystalExpender implements GuestDispatcher{

    private int stock;
    private double itemCost;

    public CrystalExpender (int stock, double itemCost) {
        this.stock = stock;
        this.itemCost = itemCost;
    }

    public void dispatch (CreditCard card){
        if (this.containsCard(card.number())) {
            return;
        }

        Map.Entry<String, String> ufo = flota.entrySet().stream()
            .filter(entry -> entry.getValue() == null)
            .findFirst()
            .orElse(null);

        if (ufo == null) {
            return;
        }

        if (card.pay(fee)) {
            ufo.setValue(card.number());
        }
    }


    public int stock () {
        return this.stock;
    }



}