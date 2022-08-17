package com.example.SepatuRecommendations.controller;

import com.example.SepatuRecommendations.dto.ProductLevel2Dto;
import com.example.SepatuRecommendations.entity.ProductLevel2;
import com.example.SepatuRecommendations.service.impl.GetLevel2DetailsServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pdp")
public class GetLevel2DetailsController {

    @Autowired
    GetLevel2DetailsServiceImpl recommendService;


//    @GetMapping(value = "/{id}")
//    public List<Optional<ProductLevel2Dto>> description(@PathVariable("id") String productLevel1Id) {
//        List<Optional<ProductLevel2>> product = recommendService.description(productLevel1Id);
//        List<Optional<ProductLevel2Dto>> productDtoList= new ArrayList<>();
//        for(Optional<ProductLevel2> e: product) {
//            ProductLevel2Dto productDto = new ProductLevel2Dto();
//            if (e.isPresent()) {
//                BeanUtils.copyProperties(e.get(),productDto);
//                productDto.setProductLevel1Id(e.get().getProductLevel1().getProductLevel1Id());
//            }
//            productDtoList.add(Optional.of(productDto));
//        }
//        return productDtoList;
//    }

    @GetMapping(value = "/{id}")
    public List<Optional<ProductLevel2Dto>> description(@PathVariable("id") String productLevel1Id) {
        List<Optional<ProductLevel2>> product = recommendService.description(productLevel1Id);
        List<Optional<ProductLevel2Dto>> productDtoList= new ArrayList<>();
        for(Optional<ProductLevel2> e: product) {
            ProductLevel2Dto productDto = new ProductLevel2Dto();
            if (e.isPresent()) {
                BeanUtils.copyProperties(e.get(),productDto);
                productDto.setProductLevel1Id(e.get().getProductLevel1().getProductLevel1Id());
            }
            productDtoList.add(Optional.of(productDto));
        }
        return productDtoList;
    }
}
