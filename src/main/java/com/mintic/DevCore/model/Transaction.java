package com.mintic.DevCore.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String concept;
    private Double amount;
    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonBackReference(value = "employee-transaction")
    private Employee users;
    @ManyToOne
    @JoinColumn(name="enterprise_id")
    @JsonBackReference(value = "enterprise-transaction")
    private Enterprise enterprise;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updateAt;

}