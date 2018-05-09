package com.junglea.faq.controller;


import com.junglea.faq.authentication.FakeSession;
import com.junglea.faq.model.ApiUser;
import com.junglea.faq.storage.mongodb.ApiUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private ApiUserRepository apiUserRepository;

    /**
     * Authenticate user with its login and password
     * @param login
     * @param password
     * @return sessionId
     */
    @GetMapping("/authenticate")
    public String getFaqs(
            @RequestParam(value = "login", required = false, defaultValue = "") String login,
            @RequestParam(value = "password", required = false, defaultValue = "") String password){

        Optional<ApiUser> user = apiUserRepository.findById(login);
        // we found user and passwords matches
        if (user.isPresent() && new BCryptPasswordEncoder().matches(password, user.get().getPassword())){
            // Generate a random sessionID
            String sessionId = UUID.randomUUID().toString();
            // Store user in session
            FakeSession.getInstance().setUserSession(sessionId, user.get());
            return sessionId;
        }
        // log.debug("Incorrect login or password")
        return "Bad login or password";
    }

}
