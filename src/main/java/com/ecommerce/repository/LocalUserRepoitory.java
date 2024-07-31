package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entities.LocalUser;

public interface LocalUserRepoitory extends JpaRepository<LocalUser,Long> {

}
