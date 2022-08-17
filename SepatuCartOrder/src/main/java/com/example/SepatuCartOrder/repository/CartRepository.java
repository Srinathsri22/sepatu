package com.example.SepatuCartOrder.repository;

import com.example.SepatuCartOrder.dto.CartDto;
//import com.example.sepatuCart.dto.CartDto;
import com.example.SepatuCartOrder.entity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {

    void deleteByProductLevel2Id(String productLevelId2);
    Optional<Cart> findByProductLevel2Id(String findByProductLevel2Id);
    List<Cart> findByUserId(String userId);
}
