package edu.teamrocket.dispatchers;

import edu.teamrocket.payment.CreditCard;
import edu.teamrocket.receptivo.GuestDispatcher;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;


public class UfosPark implements GuestDispatcher {

    private double fee = 500d;
    private final Map<String, String> flota = new HashMap<String, String>();

   public UfosPark(){};

   public void add (String ufosId){
        flota.putIfAbsent(ufosId , null);
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

    public String getUfoOf(String cardNumber){
        return flota.entrySet().stream()
                .filter(entry -> cardNumber.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString(){
        return "UfosPark{" +
                "fee=" + fee +
                ", flota=" + flota +
                '}';
    }

    public boolean containsCard(String cardNumber){
        return flota.containsValue(cardNumber);
    }

    Collection<String> cardNumbers() {
        return this.flota.values();
    }
}