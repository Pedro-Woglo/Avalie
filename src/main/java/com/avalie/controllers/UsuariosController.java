package com.avalie.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.avalie.models.Usuario;
import com.avalie.repository.UsuariosRepo;

@Controller
public class UsuariosController {

	@Autowired
	private UsuariosRepo repo;

	@GetMapping("/usuarios")
	public String Usuarios(Model model) {
		List<Usuario> usuarios = (List<Usuario>)repo.findAll();
		model.addAttribute("usuarios", usuarios);
		return "usuarios/tables";
	}

	@PostMapping("/deleta")
	public String deletaUsuario(Usuario user){
		repo.deleteById(user.getId());
		return "redirect:/usuarios";
	}
}