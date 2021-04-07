package com.mphasis.rproject.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mphasis.rproject.entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, String>
{
	@Query("select u from User u where u.userName=:userName and password=:password")
	public User validateLogin(@Param("userName")String userName, @Param("password") String password);
	
}
