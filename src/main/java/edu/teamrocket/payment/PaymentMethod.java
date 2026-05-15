package edu.teamrocket.payment;

public interface PaymentMethod {
    String number();
    double credit();
    boolean pay(double charge);
    String cardOwner();
}