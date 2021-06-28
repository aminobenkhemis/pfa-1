package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.user;

public interface DemoRepository extends JpaRepository<user,Integer>{
public user findByUsername(String username);
public user findByUsernameAndPassword(String username,String Password);
public user findByRole(String role);
public user findByIde(Integer ide);
}
