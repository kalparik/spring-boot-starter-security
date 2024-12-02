package com.example.secureapplication.controller;

import com.example.secureapplication.service.ApplicationService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class MethodSecurityController {
    private final ApplicationService applicationService;

    public MethodSecurityController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }
    @GetMapping("/hi")
    public String hi() {
        return applicationService.hi();
    }
    @GetMapping("/welcome")
    @PreAuthorize("#username==authentication.principal.username")
    public String welcome(@RequestParam("username") String username){
        return applicationService.welcome() + " " + username;
    }
    @GetMapping("/read")
    @Secured("ROLE_READ")
    public String read(){
        return applicationService.read();
    }

    @GetMapping("/send")
    @PreAuthorize("hasAnyRole('SEND', 'DELETE')")
    public String send(){
        return applicationService.send();
    }

    @GetMapping("/delete")
    @RolesAllowed("ROLE_DELETE")
    public String delete(){
        return applicationService.delete();
    }
}
