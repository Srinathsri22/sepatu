package com.example.SepatuMerchantProducer.service;

import com.example.SepatuMerchantProducer.dto.ProductL1Dto;
import com.example.SepatuMerchantProducer.dto.ProductLevel1Dto;
import com.example.SepatuMerchantProducer.dto.ProductLevel2Dto;
import com.example.SepatuMerchantProducer.entity.ProductLevel1;
import com.example.SepatuMerchantProducer.entity.ProductLevel2;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface PublishService {

    boolean addNewProduct(ProductLevel1 product) throws Exception;
    boolean addSubProduct(ProductLevel2Dto product) throws Exception;
    boolean addQuantity(String productLevel2Id, int quantity) throws Exception;
    boolean removeById(String id) throws Exception;
    boolean removeSubProduct(String productLevel2Id) throws Exception;
    boolean addDiscount(String productLevel2Id, int discount) throws Exception;
    ProductLevel1 findByProductLevel1ProductLevel1Id(String id);
    ProductLevel2 findByProductLevel2Id(String productLevel2Id);
    public List<ProductL1Dto> viewAllProducts(@PathVariable("merchantId") String merchantId);
    public List<ProductLevel2> findByMerchantId(String merchantId);
    public List<ProductL1Dto> findAll(@PathVariable("merchantId") String merchantId);

}
