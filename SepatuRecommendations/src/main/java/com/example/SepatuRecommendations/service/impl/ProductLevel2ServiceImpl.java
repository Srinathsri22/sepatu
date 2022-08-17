package com.example.SepatuRecommendations.service.impl;

import com.example.SepatuRecommendations.dto.ProductLevel2Dto;
import com.example.SepatuRecommendations.entity.ProductLevel1;
import com.example.SepatuRecommendations.entity.ProductLevel2;
import com.example.SepatuRecommendations.repository.ProductLevel1Repository;
import com.example.SepatuRecommendations.repository.ProductLevel2Repository;
import com.example.SepatuRecommendations.service.ProductLevel2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductLevel2ServiceImpl implements ProductLevel2Service {

    @Autowired
    ProductLevel2Repository productLevel2Repository;

    @Override
    public Optional<ProductLevel2> findById(String productLevel2Id) {
        return productLevel2Repository.findById(productLevel2Id);
    }

    @Override
    public ProductLevel2 save(ProductLevel2 productLevel2) {
        return productLevel2Repository.save(productLevel2);
    }

//    @Override
//    public List<ProductLevel2Dto> findAll() {
//        return null;
//    }

        @Override
    public List<ProductLevel2> findAll() {
        Iterable<ProductLevel2> iterable =  productLevel2Repository.findAll();
        List<ProductLevel2> productLevel2s = new ArrayList<>();
        iterable.forEach(productLevel2s::add);
        return productLevel2s;
    }

    @Override
    public List<ProductLevel2> findByProductLevel1Id(String productLevel1Id) {
        return productLevel2Repository.findByProductLevel1ProductLevel1Id(productLevel1Id);

    }
}