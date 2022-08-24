package com.mintic.model;

import javax.persistence.*;

@Entity
@Table(name = "movimientoDinero")
public class MovimientoDinero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double transactionAmount;
    private String transactionConcept;

    public MovimientoDinero() {
    }
    public MovimientoDinero(double transactionAmount, String transactionConcept) {
        this.transactionAmount = transactionAmount;
        this.transactionConcept = transactionConcept;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
    public double getTransactionAmount() {
        return this.transactionAmount;
    }

    public void setTransactionConcept(String transactionConcept) {
        this.transactionConcept = transactionConcept;
    }

    public String getTransactionConcept() {
        return this.transactionConcept;
    }
}
