package com.sts.Dao;
import org.springframework.data.repository.CrudRepository;


import org.springframework.stereotype.Repository;

import com.sts.Entity.Book;

@Repository
public interface UserRepository extends CrudRepository<Book,Integer>{

}
