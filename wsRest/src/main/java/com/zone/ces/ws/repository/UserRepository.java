package com.zone.ces.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.zone.ces.ws.model.User;
import java.util.List;
import java.lang.String;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{
		
	 List<User> findByNombre(String nombre);

}
