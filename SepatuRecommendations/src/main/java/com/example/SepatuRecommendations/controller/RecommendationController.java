package com.example.SepatuRecommendations.controller;

import com.example.SepatuRecommendations.dto.ProductLevel1Dto;
import com.example.SepatuRecommendations.dto.RecommendDto;
import com.example.SepatuRecommendations.entity.ProductLevel1;
import com.example.SepatuRecommendations.service.RecommendationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/recommendation")
@CrossOrigin(value = "*")
public class RecommendationController {

    @Autowired
    RecommendationService recommendationService;

    @GetMapping()
    public List<RecommendDto> recomendationListing() {

        return recommendationService.recommendationListing();
    }


}
