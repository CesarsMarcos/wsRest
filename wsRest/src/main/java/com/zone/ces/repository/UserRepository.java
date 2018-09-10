package com.zone.ces.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.zone.ces.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{
	

	
}
