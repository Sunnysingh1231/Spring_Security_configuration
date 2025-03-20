package com.configuration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.configuration.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByuserName(String userName);

}
