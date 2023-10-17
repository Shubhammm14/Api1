package com.sts.dao;

import org.springframework.data.repository.CrudRepository;


import org.springframework.stereotype.Repository;

import com.sts.entity.User;



@Repository
public interface UserRepository extends CrudRepository<User,Integer>{
	User findByUsername(String username);

	User findFirstByUsername(String username);
}
