package com.example.SepatuRecommendations.service;

import com.example.SepatuRecommendations.dto.ProductLevel2Dto;
import com.example.SepatuRecommendations.entity.ProductLevel1;
import com.example.SepatuRecommendations.entity.ProductLevel2;

import java.util.List;
import java.util.Optional;

public interface ProductLevel2Service {

    public Optional<ProductLevel2> findById(String productLevel2Id);

    public  ProductLevel2 save(ProductLevel2 productLevel2);
    //public List<ProductLevel2Dto> findAll();
    public List<ProductLevel2> findAll();
    List<ProductLevel2> findByProductLevel1Id (String productLevel1Id);
}
