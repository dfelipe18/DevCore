package com.mintic.DevCore.model;

import com.mintic.DevCore.enums.Enum_RoleName;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique=true)
    private String email;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "profile_id")
    private Profile profile;
    @Enumerated(EnumType.STRING)
    private Enum_RoleName role;
    @ManyToOne
    @JoinColumn(name="enterprise_id")
    private Enterprise enterprise;
    @OneToMany(mappedBy = "users")
    private List<Transaction> transactions;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updateAt;

    public Employee() {
    }

    public Employee(long id, String email, Profile profile, Enum_RoleName role, Enterprise enterprise, List<Transaction> transactions, Date createdAt, Date updateAt) {
        this.id = id;
        this.email = email;
        this.profile = profile;
        this.role = role;
        this.enterprise = enterprise;
        this.transactions = transactions;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Enum_RoleName getRole() {
        return role;
    }

    public void setRole(Enum_RoleName role) {
        this.role = role;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}