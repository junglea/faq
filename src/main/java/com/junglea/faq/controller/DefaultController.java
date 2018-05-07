package com.junglea.faq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return  "TODO:<br>" +
                "- Personalize home response depends of user<br>" +
                " May be display API documentation<br>" +
                "- Personalise responses on error<br>" +
                " May be redirect to home<br>";
    }
}
