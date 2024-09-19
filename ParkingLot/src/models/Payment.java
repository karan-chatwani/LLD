package models;

import java.util.UUID;

public class Payment {
    private String paymentId;
    private String tickedId;
    private double ticketFare;
    private double amount;
    private PaymentStatus paymentStatus;

    public Payment(String tickedId, double ticketFare, double amount) {
        this.paymentId = UUID.randomUUID().toString();
        this.tickedId = tickedId;
        this.ticketFare = ticketFare;
        this.amount = amount;
        this.paymentStatus = PaymentStatus.CREATED;
    }

    public PaymentStatus process() {
        if (ticketFare != amount) {
            paymentStatus = PaymentStatus.CANCELLED;
        } else {
            paymentStatus = PaymentStatus.SUCCESS;
        }
        return this.paymentStatus;
    }
}
