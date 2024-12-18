package com.thentrees.springsecuritydemo.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @RolesAllowed("ADMIN")
    @GetMapping("/vip")
    public String vipZone() {
        return "Welcome to VIP section";
    }

    @RolesAllowed({"USER", "ADMIN"})
    @GetMapping("/nomal")
    public String normalZone() {
        return "Welcome to normal section";
    }

    @GetMapping("/info")
    public Authentication showInfo() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
