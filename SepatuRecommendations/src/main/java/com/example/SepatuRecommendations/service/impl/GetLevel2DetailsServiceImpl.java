package com.example.SepatuRecommendations.service.impl;

import com.example.SepatuRecommendations.entity.ProductLevel2;
import com.example.SepatuRecommendations.repository.ProductLevel2Repository;
import com.example.SepatuRecommendations.service.GetLevel2DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetLevel2DetailsServiceImpl implements GetLevel2DetailsService {

    @Autowired
    ProductLevel2Repository productLevel2Repository;

    @Override
    public List<Optional<ProductLevel2>> description(String productLevel1Id) {
        return null;
    }
    //    public List<Optional<ProductLevel2>> description (String productLevel1Id){
//        return productLevel2Repository.findByProductLevel1ProductLevel1Id(productLevel1Id);
//    }
}
