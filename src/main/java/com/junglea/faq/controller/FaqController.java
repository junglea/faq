package com.junglea.faq.controller;

import com.junglea.faq.model.Faq;
import com.junglea.faq.storage.mongodb.FaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

/**
 * Define FAQ API
 *
 */

/*
 TODO:
 choose if we want a splitted search (question, answer, tags) or a all in one search
 choose if we want a AND or a OR research
  */

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class FaqController {

    @Autowired
    FaqRepository faqRepository;

    /**
     * List of FAQs
     * Search with AND
     * @param question optional search term
     * @param answer optional search term
     * @return List of FAQ
     */
    @GetMapping("/faqs")
    public List<Faq> getFaqs(
            @RequestParam(value = "question", required = false, defaultValue = "") String question,
            @RequestParam(value = "answer", required = false, defaultValue = "") String answer){
        return faqRepository.findBy(question, answer);
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

    /**
     * Find a FAQ given it ID
     * @param id
     * @return
     */
    @GetMapping(value = "/faqs/{id}")
    public ResponseEntity<Faq> getFaqById(@PathVariable("id") String id) {
        Optional<Faq> faq = faqRepository.findById(id);
        if (faq == null || !faq.isPresent()) {
            return new ResponseEntity<>(NOT_FOUND);
        } else {
            return new ResponseEntity<Faq>(faq.get(), OK);
        }
    }

}
