package com.example.SepatuRecommendations.service.impl;

import com.example.SepatuRecommendations.entity.ProductLevel1;
import com.example.SepatuRecommendations.entity.ProductLevel2;
import com.example.SepatuRecommendations.repository.ProductLevel1Repository;
import com.example.SepatuRecommendations.service.ProductLevel1Service;
import com.example.SepatuRecommendations.service.ProductLevel2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductLevel1ServiceImpl implements ProductLevel1Service {

    @Autowired
    ProductLevel1Repository productLevel1Repository;

    @Override
    public Optional<ProductLevel1> findById(String productLevel1Id) {
        return productLevel1Repository.findById(productLevel1Id);
    }

    @Override
    public ProductLevel1 save(ProductLevel1 productLevel1) {
        return productLevel1Repository.save(productLevel1);
    }

    @Override
    public List<ProductLevel1> findAll() {
        Iterable<ProductLevel1> iterable =  productLevel1Repository.findAll();
        List<ProductLevel1> productLevel1s = new ArrayList<>();
        iterable.forEach(productLevel1s::add);
        return productLevel1s;
    }


}
