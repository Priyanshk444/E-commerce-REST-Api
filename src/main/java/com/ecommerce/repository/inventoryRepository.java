package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entities.Inventory;

public interface inventoryRepository extends JpaRepository<Inventory, Integer> {

}
