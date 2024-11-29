package com.example.secureapplication.controller;
import com.example.secureapplication.service.ApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }
    @GetMapping("/hi")
    public String hi(){
        return applicationService.hi();
    }

    @GetMapping("/read")
    public String read(){
        return applicationService.read();
    }

    @GetMapping("/send")
    public String send(){
        return applicationService.send();
    }
    @GetMapping("/delete")
    public String delete(){
        return applicationService.delete();
    }
}
