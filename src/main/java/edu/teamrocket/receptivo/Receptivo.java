package edu.teamrocket.receptivo;

import edu.teamrocket.payment.CreditCard;

import java.util.ArrayList;
import java.util.List;

public class Receptivo {
    private final List<GuestDispatcher> dispatchers = new ArrayList<>();

    public Receptivo() {
    }

    public void registra(GuestDispatcher dispatcher) {
        if (dispatcher == null) {
            return;
        }
        this.dispatchers.add(dispatcher);
    }

    public void dispatch(CreditCard card) {
        for (GuestDispatcher dispatcher : dispatchers) {
            dispatcher.dispatch(card);
        }
    }
}
