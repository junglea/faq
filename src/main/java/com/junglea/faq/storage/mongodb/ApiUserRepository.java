package com.junglea.faq.storage.mongodb;

import com.junglea.faq.model.ApiUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiUserRepository extends MongoRepository<ApiUser, String> {

}
