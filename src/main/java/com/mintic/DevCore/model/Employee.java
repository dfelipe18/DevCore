package com.mintic.DevCore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mintic.DevCore.enums.Enum_RoleName;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique=true, length = 45)
    private String email;
    @Column(length = 64)
    private String password;
    @JsonBackReference(value="profile-employee")
    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "profile_id")
    private Profile profile;
    @Enumerated(EnumType.STRING)
    private Enum_RoleName role;
    @Column(name = "first_name", length = 20)
    private String firstName;
    @Column(name = "last_name", length = 20)
    private String lastName;
    @Column(unique = true)
    private String document;
    @JsonBackReference(value="enterprise-employee")
    @ManyToOne
    @JoinColumn(name="enterprise_id")
    private Enterprise enterprise;
    @JsonManagedReference(value = "employee-transaction")
    @OneToMany(mappedBy = "users")
    private List<Transaction> transactions;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updateAt;
}