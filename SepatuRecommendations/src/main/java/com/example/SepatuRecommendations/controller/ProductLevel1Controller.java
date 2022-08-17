package com.example.SepatuRecommendations.controller;

import com.example.SepatuRecommendations.dto.ProductLevel1Dto;
import com.example.SepatuRecommendations.dto.ProductLevel2Dto;
import com.example.SepatuRecommendations.entity.ProductLevel1;
import com.example.SepatuRecommendations.service.ProductLevel1Service;
import com.example.SepatuRecommendations.service.ProductLevel2Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/level1")
public class ProductLevel1Controller {
    @Autowired
    ProductLevel1Service productLevel1Service;

    @GetMapping(value = "/{id}")
    public Optional<ProductLevel1Dto> findById(@PathVariable("id") String productLevel1id) {
        Optional<ProductLevel1> optionalCompany = productLevel1Service.findById(productLevel1id);
        ProductLevel1Dto companyDto = null;
        if (optionalCompany.isPresent()) {
            companyDto = new ProductLevel1Dto();
            BeanUtils.copyProperties(optionalCompany.get(), companyDto);
        }
        return Optional.ofNullable(companyDto);
    }


    @PostMapping
    public ProductLevel1Dto save(@RequestBody ProductLevel1Dto productLevel1Dto) {
        ProductLevel1 product = new ProductLevel1();
        BeanUtils.copyProperties(productLevel1Dto, product);
        ProductLevel1 returnProduct = productLevel1Service.save(product);
        ProductLevel1Dto returnDto = new ProductLevel1Dto();
        BeanUtils.copyProperties(returnProduct, returnDto);
        return returnDto;
    }
}
