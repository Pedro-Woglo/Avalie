package com.avalie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.avalie.models.Usuario;
import com.avalie.repository.UsuariosRepo;

@Controller
public class LoginController {
	
	@Autowired
	private UsuariosRepo repo;

	@GetMapping("/login")
	public String index(){
		return "login/index";
	}
	
	@GetMapping(value = "/dashboard")
	public RedirectView getDashboard() {
		String uri = "https://rafaeleducax.shinyapps.io/primeiro_dash/?_ga=2.96400533.881204248.1649694354-419896262.1649525404";
	       RedirectView redirectView = new RedirectView();
	       redirectView.setUrl(uri);
	 
	       return redirectView;
	}
	
	@PostMapping("/logar")
	public String logar(Model model, Usuario usuario) {
		
		Usuario user = this.repo.login(usuario.getEmail(), usuario.getSenha());
		if(user != null) {
			return "redirect:/dashboard";
		}else {
			model.addAttribute("status", "Email e/ou senha inválidos!");
		}
		return "login/index";
	}
}

