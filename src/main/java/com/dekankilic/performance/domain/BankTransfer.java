package com.dekankilic.performance.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate // Hibernate will track which fields on the entity have changed, and it will update only those fields. But, this comes with a cost that Hibernate has to track it.
public class BankTransfer {
    @Id
    private String id;

    private String reference;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account sender;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account receiver;

    @Embedded
    private Amount amount;

    @Enumerated(EnumType.STRING)
    private State state;

    @Version
    private Long version;


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
