package com.dourki.patientsmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping(path = "/403")
    public String notAuthorized(){
        return "403";
    }
}
