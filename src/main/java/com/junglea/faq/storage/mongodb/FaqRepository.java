package com.junglea.faq.storage.mongodb;

import com.junglea.faq.model.Faq;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The MongoRepository interface defines methods for all the CRUD operations on the Document
 * like findAll(), findOne(), save(), delete() etc.
 */

@Repository
public interface FaqRepository extends MongoRepository<Faq, String> {

    /**
     * Search FAQ with terms
     *
     * @param question optional term to search in question field
     * @param answer optional term to search in response field
     * @return
     */
    @Query(value = "{ 'question': {$regex : ?0, $options: 'i'}, 'answer': {$regex : ?1, $options: 'i'} }")
    List<Faq> findBy(String question, String answer);

}
