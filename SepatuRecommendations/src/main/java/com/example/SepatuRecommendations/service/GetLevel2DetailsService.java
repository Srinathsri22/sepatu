package com.example.SepatuRecommendations.service;

import com.example.SepatuRecommendations.entity.ProductLevel2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GetLevel2DetailsService {

//    Pro Re;
    public List<Optional<ProductLevel2>> description (String productLevel1Id);
}
