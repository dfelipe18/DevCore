package com.mintic.DevCore.controller;

import com.mintic.DevCore.interfaces.UserRepository;
import com.mintic.DevCore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.net.Authenticator;

@Controller
@RequestMapping("/access")
public class AccessController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/home")
    public String home(Authentication auth, HttpSession session) {
        String username = auth.getName();
        if (session.getAttribute("usuario") == null) {
            User user = userRepository.findByEmail(username);
            user.setPassword(null);
            session.setAttribute("usuario", user);
        }
        return "home";
    }
}
