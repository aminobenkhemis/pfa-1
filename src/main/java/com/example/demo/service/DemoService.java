package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.user;
import com.example.demo.repository.DemoRepository;

@Service
public class DemoService {
	@Autowired
	private DemoRepository repo;
public user saveuser(user user) {
	return repo.save(user);
}
public user fetchuserByUsername(String username) {
	return repo.findByUsername(username);
}
public user fetchuserByUsernameAndPassword(String username,String password) {
	return repo.findByUsernameAndPassword(username,password);
}
public List<user> fetchall() {
	return repo.findAll();
}
public void deleteUser(int id) {
	 repo.deleteById(id);
}
public user userid(int id) {
	return repo.findByIde(id);
}


}
