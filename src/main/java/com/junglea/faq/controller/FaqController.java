package com.junglea.faq.controller;

import com.junglea.faq.model.Faq;
import com.junglea.faq.storage.mongodb.FaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Define FAQ API
 *
 */

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class FaqController {

    @Autowired
    FaqRepository faqRepository;

    /**
     * List of FAQs
     * @return
     */
    @GetMapping("/faqs")
    public List<Faq> getAll(){
        System.out.println("Get All Questions");
        return faqRepository.findAll();
    }

}
