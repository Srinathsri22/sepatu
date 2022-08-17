package com.example.SepatuRecommendations.controller;

import com.example.SepatuRecommendations.dto.ProductLevel2Dto;
import com.example.SepatuRecommendations.entity.ProductLevel1;
import com.example.SepatuRecommendations.entity.ProductLevel2;
import com.example.SepatuRecommendations.service.ProductLevel1Service;
import com.example.SepatuRecommendations.service.ProductLevel2Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/level2")
public class ProductLevel2Controller {
    @Autowired
    ProductLevel2Service productLevel2Service;
    @Autowired
    ProductLevel1Service productLevel1Service;

    @GetMapping(value = "/{id}")
    public Optional<ProductLevel2Dto> findById(@PathVariable("id") String productLevel1id) {
        Optional<ProductLevel2> optionalProduct = productLevel2Service.findById(productLevel1id);
        ProductLevel2Dto productLevel2Dto = null;
        if (optionalProduct.isPresent()) {
            productLevel2Dto = new ProductLevel2Dto();
            BeanUtils.copyProperties(optionalProduct.get(), productLevel2Dto);
            productLevel2Dto.setProductLevel1Id(optionalProduct.get().getProductLevel1().getProductLevel1Id());
        }
        return Optional.ofNullable(productLevel2Dto);
    }


    @PostMapping
    public ProductLevel2Dto save(@RequestBody ProductLevel2Dto productLevel2Dto) {
        ProductLevel2 product = new ProductLevel2();
        BeanUtils.copyProperties(productLevel2Dto, product);

        Optional<ProductLevel1> optionalProductLevel1 = productLevel1Service.findById(productLevel2Dto.getProductLevel1Id());
        product.setProductLevel1(optionalProductLevel1.get());

        ProductLevel2 returnProduct = productLevel2Service.save(product);
        ProductLevel2Dto returnDto = new ProductLevel2Dto();
        BeanUtils.copyProperties(returnProduct, returnDto);

        returnDto.setProductLevel1Id(returnProduct.getProductLevel1().getProductLevel1Id());

        return returnDto;
    }
}
