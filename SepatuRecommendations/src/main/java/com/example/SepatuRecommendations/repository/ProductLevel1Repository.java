package com.example.SepatuRecommendations.repository;

import com.example.SepatuRecommendations.entity.ProductLevel1;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductLevel1Repository extends CrudRepository<ProductLevel1, String> {
    //public List<ProductLevel1> findAllProductLevel1();
    public List<ProductLevel1> findAll();

    //productLevel2Repository.findByProductLevel1ProductLevel1Id(productLevel1Id);

}
