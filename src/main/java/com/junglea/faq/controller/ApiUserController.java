package com.junglea.faq.controller;

import com.junglea.faq.model.ApiUser;
import com.junglea.faq.storage.mongodb.ApiUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Only for test purpose
 */

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ApiUserController {

    @Autowired
    private ApiUserRepository apiUserRepository;

    /**
     * Create a new user
     * @param user in json formats
     * @return API User object
     */
    @PostMapping("/users")
    public @Valid ApiUser createUser(@Valid @RequestBody ApiUser user) {
        return apiUserRepository.save(user);
    }
    /**
     * List of Users
     * @return List of ApiUSer object
     */
    @GetMapping("/users")
    public List<ApiUser> getUsers(){
        return apiUserRepository.findAll();
    }

}
