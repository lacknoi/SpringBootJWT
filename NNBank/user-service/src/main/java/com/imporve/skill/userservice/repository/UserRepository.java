package com.imporve.skill.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imporve.skill.userservice.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUserName(String userName);
}
