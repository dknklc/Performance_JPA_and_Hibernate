package com.dekankilic.performance.domain;

import jakarta.persistence.*;

@Entity
public class BankTransfer {
    @Id
    private String id;

    private String reference;

    @ManyToOne
    private Account sender;

    @ManyToOne
    private Account receiver;

    @Embedded
    private Amount amount;

    @Enumerated(EnumType.STRING)
    private State state;

    public enum State {
        CREATED,
        SETTLED
    }

    public BankTransfer() {
    }

    public BankTransfer(String id, String reference, Account sender, Account receiver, Amount amount) {
        this.id = id;
        this.reference = reference;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.state = State.CREATED;
    }

    public void settle() {
        this.state = State.SETTLED;
    }

    public String getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public Account getSender() {
        return sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public Amount getAmount() {
        return amount;
    }

    public State getState() {
        return state;
    }
}
