package com.avalie.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirecionamentoController {
    
    @GetMapping("/redirect")
    public String redirect(){
        return "redirecionamento/index";
    }
}
