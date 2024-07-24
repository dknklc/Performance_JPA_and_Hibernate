package com.dekankilic.performance.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {

    @Id
    private String id;

    private String iban;
    private String firstName;
    private String lastName;

    @ElementCollection
    private List<PhoneNumber> phoneNumbers;

    public Account() {
    }

    public Account(String id, String iban, String firstName, String lastName) {
        this.id = id;
        this.iban = iban;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumbers = new ArrayList<>();
    }

    public void addPhoneNumber(PhoneNumber phoneNumber) {
        if(!phoneNumbers.contains(phoneNumber)) {
            this.phoneNumbers.add(phoneNumber);
        }
    }

    public String getId() {
        return id;
    }

    public String getIban() {
        return iban;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }
}
