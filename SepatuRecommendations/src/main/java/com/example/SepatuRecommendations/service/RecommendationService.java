package com.example.SepatuRecommendations.service;

import com.example.SepatuRecommendations.dto.RecommendDto;

import java.util.List;

public interface RecommendationService {
    RecommendDto recommendHotDealsFunction(RecommendDto recommendDto);
    void recommendNewArrivals();
    void recommendCasual();
    void recommendSports();
    List<RecommendDto> recommendationListing();


    // Select * from ProductLevel2 where discount>50 --  hot sales
    //Select * from ProductLevel2 where date >= DATEADD(day,-7, GETDATE())
    // Select * from ProductLevel1 where type="sports"
    // Select * from ProductLevel1 where type="casuals"

}
