package com.zone.ces.ws.service;

import java.util.List;

import com.zone.ces.ws.model.User;

public interface IUserService {
	
	List<User> getAllUSer();
	User getUserById(Long id);
	boolean isUserExist (User user);
	void addUser (User user);
	void updateUser(User user);
	void deleteUser(Long id);
	void deleteUserAll ();

}
