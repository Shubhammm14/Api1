package com.example.project7.repo;

import com.example.project7.jwtmodel.User;
import org.springframework.data.repository.CrudRepository;


import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends CrudRepository<User,Integer>{
    User findByName(String name);

    //User findFirstByUsername(String username);
}
