package com.onea.talkietalkie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class IndexController {
    @RequestMapping("/")
    String index(Model model, HttpServletRequest request, HttpServletResponse response, Principal principal, HttpSession session) {
        model.addAttribute("textVariable", "Hello World");
        return "index";
    }

}