package com.example.SepatuMerchantProducer.controller;

import com.example.SepatuMerchantProducer.dto.ProductL1Dto;
import com.example.SepatuMerchantProducer.dto.ProductLevel1Dto;
import com.example.SepatuMerchantProducer.entity.ProductLevel1;
import com.example.SepatuMerchantProducer.repository.ProductLevel1Repository;
import com.example.SepatuMerchantProducer.service.PublishService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/productLevel1")
@CrossOrigin(value = "*")
public class ProductLevel1Controller {



    @Autowired
    PublishService publishService;

    @Autowired
    ProductLevel1Repository productLevel1Repository;


    @PostMapping(value = "/addProduct")
    public ProductLevel1 addNewProduct(@RequestBody ProductLevel1 productLevel1){
        try{
            publishService.addNewProduct(productLevel1);

        }catch(Exception e){
            e.printStackTrace();
        }
        return productLevel1;
    }

//    @GetMapping(value = "/findByProductLevel1ID/{productLevel1Id}")
//    public ProductLevel1 findByProductLevel1Id(@PathVariable("productLevel1Id") String productLevel1Id){
//        ProductLevel1 productLevel1 = publishService.findByProductLevel1Id(productLevel1Id);
//        return productLevel1;
//    }

    @GetMapping(value = "/findByProductLevel1ProductLevel1Id/{productLevel1Id}")
    public ProductLevel1Dto findByProductLevel1ProductLevel1Id(@PathVariable("productLevel1Id") String productLevel1Id){
        ProductLevel1 productLevel1 = publishService.findByProductLevel1ProductLevel1Id(productLevel1Id);
        ProductLevel1Dto productLevel1Dto = new ProductLevel1Dto();
        BeanUtils.copyProperties(productLevel1,productLevel1Dto);
        System.out.println(productLevel1.getProductLevel1Id());
        productLevel1Dto.setProductLevel1Id(productLevel1.getProductLevel1Id());
        System.out.println(productLevel1Dto.getProductLevel1Id());
        return productLevel1Dto;
    }


    @DeleteMapping(value = "/removeById/{productLevel1Id}")
    public void removeById(@PathVariable("productLevel1Id") String productLevel1Id){
        try{
            publishService.removeById(productLevel1Id);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @PostMapping(value = "/updateprice/{productLevel1Id}/{price}")
    public boolean updatePrice(@PathVariable("productLevel1Id")String productLevel1Id, @PathVariable("quantity") int price){
        return true;
    }

    @GetMapping(value="/find/{merchantId}")
    public List<ProductL1Dto> findAll(@PathVariable("merchantId") String merchantId) {
        try{

            return publishService.findAll(merchantId);

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
