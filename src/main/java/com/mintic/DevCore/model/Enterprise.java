package com.mintic.DevCore.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "enterprise")
public class Enterprise {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private String name;
	@Column(unique = true)
	private String document;
	private String phone;
	private String address;
	@OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL)
	private List<Employee> users;
	@OneToMany(mappedBy = "enterprise" , cascade = CascadeType.ALL)
	private List<Transaction> transactions;
	@CreatedDate
	private Date createdAt;
	@LastModifiedDate
	private Date updateAt;

	public Enterprise() {
	}

	public Enterprise(long id, String name, String document, String phone, String address, List<Employee> users, List<Transaction> transactions, Date createdAt, Date updateAt) {
		this.id = id;
		this.name = name;
		this.document = document;
		this.phone = phone;
		this.address = address;
		this.users = users;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Employee> getUsers() {
		return users;
	}

	public void setUsers(List<Employee> users) {
		this.users = users;
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


