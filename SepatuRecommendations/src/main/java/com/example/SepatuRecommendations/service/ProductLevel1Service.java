package com.example.SepatuRecommendations.service;

import com.example.SepatuRecommendations.entity.ProductLevel1;
import com.example.SepatuRecommendations.entity.ProductLevel2;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ProductLevel1Service {

    public Optional<ProductLevel1> findById(String productLevel1Id);

    public ProductLevel1 save(ProductLevel1 productLevel1);

    public List<ProductLevel1> findAll();

}
