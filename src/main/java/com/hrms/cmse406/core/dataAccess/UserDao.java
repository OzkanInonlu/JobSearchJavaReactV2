package com.hrms.cmse406.core.dataAccess;

import com.hrms.cmse406.core.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

    //User getByEmail(String email);

    void delete(User user);

	User findByEmail(String email);
	
	User findById(int id);
}