package com.example.secureapplication.service;

import com.example.secureapplication.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }
    public String hi(){
        return applicationRepository.hi();
    }
    public String welcome() {
        return applicationRepository.welcome();
    }
    public String send(){
        return applicationRepository.send();
    }
    public String read(){
        return applicationRepository.read();
    }
    public String delete(){
        return applicationRepository.delete();
    }
}
