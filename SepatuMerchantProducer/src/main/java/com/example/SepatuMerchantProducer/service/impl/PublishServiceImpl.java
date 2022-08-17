package com.example.SepatuMerchantProducer.service.impl;

import com.example.SepatuMerchantProducer.dto.ProductL1Dto;
import com.example.SepatuMerchantProducer.dto.ProductLevel1Dto;
import com.example.SepatuMerchantProducer.dto.ProductLevel2Dto;
import com.example.SepatuMerchantProducer.entity.ProductLevel1;
import com.example.SepatuMerchantProducer.entity.ProductLevel2;
import com.example.SepatuMerchantProducer.repository.ProductLevel1Repository;
import com.example.SepatuMerchantProducer.repository.ProductLevel2Repository;
import com.example.SepatuMerchantProducer.service.PublishService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PublishServiceImpl implements PublishService {

    @Autowired
    ProductLevel1Repository productLevel1Repository;

    @Autowired
    ProductLevel2Repository productLevel2Repository;


    @Override
    public boolean addNewProduct(ProductLevel1 product) throws Exception {
        try {
            productLevel1Repository.save(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ProductLevel1 findByProductLevel1ProductLevel1Id(String productLevel1Id) {
        try{
            ProductLevel1 productLevel1 = new ProductLevel1();
            productLevel1= productLevel1Repository.findByProductLevel1ProductLevel1Id(productLevel1Id);
            return productLevel1;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public boolean addSubProduct(ProductLevel2Dto product) throws Exception {
        try {
            ProductLevel2 productLevel2 = new ProductLevel2();
            BeanUtils.copyProperties(product, productLevel2);
            Optional<ProductLevel1> productLevel1 = productLevel1Repository.findById(product.getProductLevel1Id());
            if (productLevel1.isPresent())
                productLevel2.setProductLevel1(productLevel1.get());
            productLevel2Repository.save(productLevel2);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ProductLevel2 findByProductLevel2Id(String productLevel2Id) {
        try{
            ProductLevel2 productLevel2 = new ProductLevel2();
            productLevel2= productLevel2Repository.findByProductLevel2Id(productLevel2Id);
            return productLevel2;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }


    @Override
    public boolean addQuantity(String productLevel2Id, int quantity) throws Exception {
        try {
            productLevel2Repository.addQuantity(productLevel2Id, quantity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeById(String productLevel1Id) throws Exception {
        try {
            productLevel1Repository.deleteById(productLevel1Id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeSubProduct(String productLevel2Id) throws Exception {
        try {
            productLevel2Repository.deleteById(productLevel2Id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addDiscount(String productLevel2Id, int discount) throws Exception {
        try {
            productLevel2Repository.addDiscount(productLevel2Id, discount);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
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


    @Override
    public List<ProductL1Dto> findAll(String merchantId) {
        return null;
    }

    @Override
    public List<ProductLevel2> findByMerchantId(String merchantId){
        List<ProductLevel2> level2List = productLevel2Repository.findByMerchantId(merchantId);
        System.out.println(level2List);
        return level2List;
    }

    @Override
    public List<ProductL1Dto> viewAllProducts(String merchantId) {
        Map<String,List<ProductLevel2>> mp = new HashMap<>();
        List<ProductLevel2> level2List = findByMerchantId(merchantId);
        System.out.println(level2List);
        for(ProductLevel2 p : level2List){
            mp.putIfAbsent(String.valueOf(p.getProductLevel1()),new ArrayList<>());
            mp.get(String.valueOf(p.getProductLevel1())).add(p);

            System.out.println("efef"+p.getProductLevel1());
        }
        List<ProductL1Dto> returnValue = new ArrayList<>();
        for (String pL1ID : mp.keySet()){
            ProductL1Dto productL1Dto = new ProductL1Dto();
            List<ProductLevel2> product2 = new ArrayList<>();
            product2 = mp.get(pL1ID);
            productL1Dto.setListOfProductLevel2(product2);

        }

            System.out.println(mp);
//        System.out.println("findbymerchant"+level2List);
        return null;
    }
}


