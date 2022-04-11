package com.avalie.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.avalie.models.Usuario;

public interface UsuariosRepo extends CrudRepository<Usuario, Integer>{
	
	@Query(value = "SELECT * FROM usuario WHERE email = :email AND senha = :senha", nativeQuery = true)
	public Usuario login(String email, String senha);
}
