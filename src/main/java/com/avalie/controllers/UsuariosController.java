package com.avalie.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuariosController {

	@GetMapping("/usuarios")
	public String Usuarios() {
		return "usuarios/tables";
	}
}
