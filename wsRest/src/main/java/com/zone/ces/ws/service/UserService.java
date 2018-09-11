package com.zone.ces.ws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zone.ces.ws.model.User;
import com.zone.ces.ws.repository.UserRepository;


@Service
public class UserService  implements IUserService{

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUSer() {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<>();
		userRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id).get();
		return user;
	}

	@Override
	public boolean isUserExist(User user) {
		// TODO Auto-generated method stub
		List<User> list = userRepository.findByNombre(user.getNombre());
		if(list.size()>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.delete(getUserById(id));
		
	}

	@Override
	public void deleteUserAll() {
	userRepository.deleteAll();
		
	}
	

}
