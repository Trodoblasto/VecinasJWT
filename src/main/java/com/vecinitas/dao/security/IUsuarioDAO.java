package com.vecinitas.dao.security;
import org.springframework.data.repository.CrudRepository;

import com.vecinitas.entities.security.*;

public interface IUsuarioDAO extends CrudRepository<User, Integer>{
	public User findByUsername(String username);	
}
