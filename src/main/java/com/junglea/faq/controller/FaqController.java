package com.junglea.faq.controller;

import com.junglea.faq.model.Faq;
import com.junglea.faq.storage.mongodb.FaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        return faqRepository.findAll();
    }

    /**
     * Create a new FAQ
     * @param faq in json format
     * @return Faq object
     */
    @PostMapping("/faqs")
    public Faq createFaq(@Valid @RequestBody Faq faq) {
        // TODO check of unicity and validity
        return faqRepository.save(faq);
    }

    /**
     * Remove a FAQ given it ID
     *
     */
    @DeleteMapping(value = "/faqs/{id}")
    public void deleteFaq(@PathVariable("id") String id) {
        faqRepository.deleteById(id);
    }
}
