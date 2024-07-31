package com.ecommerce.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class WebOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "address_id",nullable = false)
	private Address address;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id",nullable = false)
	private LocalUser user;
	
	@OneToMany(mappedBy = "order",cascade = CascadeType.REMOVE,orphanRemoval = true)
	private List<WebOrderQuantity> quantities = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public LocalUser getUser() {
		return user;
	}

	public void setUser(LocalUser user) {
		this.user = user;
	}

	public List<WebOrderQuantity> getQuantities() {
		return quantities;
	}

	public void setQuantities(List<WebOrderQuantity> quantities) {
		this.quantities = quantities;
	}

	
	
	
}
