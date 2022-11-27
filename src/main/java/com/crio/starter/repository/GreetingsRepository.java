// package com.crio.starter.repository;

// import com.crio.starter.data.GreetingsEntity;
// import org.springframework.data.mongodb.repository.MongoRepository;

// public interface GreetingsRepository extends MongoRepository<GreetingsEntity, String> {
//   GreetingsEntity findByExtId(String extId);
// }

package com.crio.starter.repository;

import java.util.List;

import com.crio.starter.data.GreetingsEntity;

import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GreetingsRepository extends MongoRepository<GreetingsEntity, String> { 
    
}
