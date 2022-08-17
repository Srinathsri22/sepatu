package com.example.SepatuRecommendations.service.impl;

import com.example.SepatuRecommendations.dto.ProductL1Dto;
import com.example.SepatuRecommendations.dto.ProductLevel1Dto;
import com.example.SepatuRecommendations.dto.ProductLevel2Dto;
import com.example.SepatuRecommendations.dto.RecommendDto;
import com.example.SepatuRecommendations.entity.ProductLevel1;
import com.example.SepatuRecommendations.entity.ProductLevel2;
import com.example.SepatuRecommendations.repository.ProductLevel1Repository;
import com.example.SepatuRecommendations.repository.ProductLevel2Repository;
import com.example.SepatuRecommendations.service.RecommendationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    ProductLevel2Repository productLevel2Repository;

    @Autowired
    ProductLevel1Repository productLevel1Repository;


    List<RecommendDto> recommendDtos;

    // Select * from ProductLevel2 where discount>50 --  hot sales
    //Select * from ProductLevel2 where date >= DATEADD(day,-7, GETDATE())
    // Select * from ProductLevel1 where type="sports"
    // Select * from ProductLevel1 where type="casuals"

    @Override
    public RecommendDto recommendHotDealsFunction(RecommendDto recommendDto) {
        List<ProductLevel1> level1List = productLevel1Repository.findAll();
        List<ProductL1Dto> level1DtoList =  new ArrayList<>();

        for(ProductLevel1 p: level1List){
            ProductL1Dto tempProductL1Dto = new ProductL1Dto();
            BeanUtils.copyProperties(p,tempProductL1Dto);
            String id  = p.getProductLevel1Id();
            List<ProductLevel2> level2List = productLevel2Repository.findByProductLevel1ProductLevel1Id(id);
            tempProductL1Dto.setListOfProductLevel2(level2List);
            level1DtoList.add(tempProductL1Dto);
        }
        recommendDto.setRecommedations(level1DtoList);
        System.out.println(recommendDto);
        return recommendDto;
    }

    @Override
    public void recommendNewArrivals() {

    }

    @Override
    public void recommendCasual() {

    }

    @Override
    public void recommendSports() {

    }

    public List<RecommendDto> recommendationListing(){
        recommendDtos =  new ArrayList<>();
        RecommendDto recommendDtoHD = new RecommendDto();
        recommendDtoHD.setCategory("HOT DEALS");
        recommendHotDealsFunction(recommendDtoHD);
        recommendDtos.add(recommendDtoHD);
        recommendDtoHD = new RecommendDto();
        recommendDtoHD.setCategory("New Arrivals");
        recommendHotDealsFunction(recommendDtoHD);
        recommendDtos.add(recommendDtoHD);
        recommendDtoHD = new RecommendDto();
        recommendDtoHD.setCategory("Formals on sale");
        recommendHotDealsFunction(recommendDtoHD);
        recommendDtos.add(recommendDtoHD);
        recommendDtoHD = new RecommendDto();
        recommendDtoHD.setCategory("Formals on sale");
        recommendHotDealsFunction(recommendDtoHD);
        recommendDtos.add(recommendDtoHD);
        return recommendDtos;

    }


}
