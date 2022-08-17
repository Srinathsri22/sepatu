package com.example.SepatuMerchantProducer.controller;


import com.example.SepatuMerchantProducer.dto.ProductL1Dto;
import com.example.SepatuMerchantProducer.dto.ProductLevel1Dto;
import com.example.SepatuMerchantProducer.dto.ProductLevel2Dto;
import com.example.SepatuMerchantProducer.entity.ProductLevel2;
import com.example.SepatuMerchantProducer.repository.ProductLevel1Repository;
import com.example.SepatuMerchantProducer.repository.ProductLevel2Repository;
import com.example.SepatuMerchantProducer.service.PublishService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/productLevel2")
@CrossOrigin(value = "*")
public class ProductLevel2Controller {

    @Autowired
    PublishService publishService;

    @Autowired
    ProductLevel2Repository productLevel2Repository;

    @Autowired
    ProductLevel1Repository productLevel1Repository;

    @PostMapping(value = "/addSubProduct")
    public ProductLevel2Dto save(@RequestBody ProductLevel2Dto productLevel2Dto) {
        try {
            publishService.addSubProduct(productLevel2Dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productLevel2Dto;
    }

    @GetMapping(value = "/findByProductLevel2Id/{productLevel2Id}")
    public ProductLevel2Dto findByProductLevel2Id(@PathVariable("productLevel2Id") String productLevel2Id){
        ProductLevel2 productLevel2 = publishService.findByProductLevel2Id(productLevel2Id);
        ProductLevel2Dto productLevel2Dto = new ProductLevel2Dto();
        BeanUtils.copyProperties(productLevel2, productLevel2Dto);
        productLevel2Dto.setProductLevel1Id(productLevel2.getProductLevel1().getProductLevel1Id());
        System.out.println(productLevel2Dto);
        return productLevel2Dto;
    }



    @PostMapping(value = "/inventory/{productLevel2Id}/{quantity}")
    public boolean updateInventory(@PathVariable("productLevel2Id") String productLevel2Id, @PathVariable("quantity") int quantity) {
        try {
            publishService.addQuantity(productLevel2Id, quantity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    @PostMapping(value = "/discount/{productLevel2Id}/{price}")
    public boolean updateDiscount(@PathVariable("productLevel2Id") String productLevel2Id, @PathVariable("price") int discount) {
        try{
            publishService.addDiscount(productLevel2Id, discount);
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }
    @GetMapping(value = "/viewAllProducts/{merchantId}")
    public List<ProductL1Dto> viewAllProducts(@PathVariable("merchantId") String merchantId)
    {
        return publishService.viewAllProducts(merchantId);
    }

//    public RecommendDto recommendHotDealsFunction(RecommendDto recommendDto) {
//        List<ProductLevel1> level1List = productLevel1Repository.findAll();
//        List<ProductL1Dto> level1DtoList =  new ArrayList<>();
//
//        for(ProductLevel1 p: level1List){
//            ProductL1Dto tempProductL1Dto = new ProductL1Dto();
//            BeanUtils.copyProperties(p,tempProductL1Dto);
//            String id  = p.getProductLevel1Id();
//            List<ProductLevel2> level2List = productLevel2Repository.findByProductLevel1ProductLevel1Id(id);
//            tempProductL1Dto.setListOfProductLevel2(level2List);
//            level1DtoList.add(tempProductL1Dto);
//        }
//        recommendDto.setRecommedations(level1DtoList);
//        System.out.println(recommendDto);
//        return recommendDto;



//    @PostMapping(value = "/rating/{productLevel2Id}/{rating}")
//    public boolean updateRating(@PathVariable("productLevel2Id") String productLevel2Id, @PathVariable("rating") int rating) {
//        try{
//            publishService.updateRating(productLevel2Id, rating);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return true;
//    }
}
