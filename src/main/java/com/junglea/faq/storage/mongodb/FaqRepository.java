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

}
