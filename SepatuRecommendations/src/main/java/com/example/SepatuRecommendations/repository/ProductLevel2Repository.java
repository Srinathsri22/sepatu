package com.example.SepatuRecommendations.repository;

import com.example.SepatuRecommendations.dto.ProductLevel2Dto;
import com.example.SepatuRecommendations.entity.ProductLevel1;
import com.example.SepatuRecommendations.entity.ProductLevel2;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductLevel2Repository extends CrudRepository<ProductLevel2, String> {

//    List<ProductLevel2> findByProductLevel1ProductLevel1Id (String productLevel1Id);

    List<ProductLevel2> findByProductLevel1ProductLevel1Id(String productLevel1Id);

    public List<ProductLevel2> findAll();



}
