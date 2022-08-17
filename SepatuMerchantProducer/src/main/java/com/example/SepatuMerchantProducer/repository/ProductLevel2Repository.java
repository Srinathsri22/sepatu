package com.example.SepatuMerchantProducer.repository;

import com.example.SepatuMerchantProducer.dto.ProductLevel2Dto;
import com.example.SepatuMerchantProducer.entity.ProductLevel1;
import com.example.SepatuMerchantProducer.entity.ProductLevel2;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductLevel2Repository extends CrudRepository<ProductLevel2, String> {

    public ProductLevel2 findByProductLevel2Id(String productLevel2Id);
    public List<ProductLevel2> findByMerchantId(String merchantId);
//    public ProductLevel1 findByProductLevel1Id(String productLevel1Id);

    @Transactional
    @Modifying
    @Query(value = "update ProductLevel2 u set u.quantity = :quantity where u.productLevel2Id = :productLevel2Id", nativeQuery = true)
    void addQuantity(@Param("productLevel2Id") String productLevel2Id,@Param("quantity") int quantity);
    //    boolean addQuantity(@param ... String productLevel2Id, int quantity);

    @Transactional
    @Modifying
    @Query(value = "update ProductLevel2 u set u.quantity = :quantity where u.productLevel2Id = :productLevel2Id", nativeQuery = true)
    void reduceQuantity(@Param("productLevel2Id") String productLevel2Id,@Param("quantity") int quantity);

    @Transactional
    @Modifying
    @Query(value = "update ProductLevel2 u set u.discount = :percentage where u.productLevel2Id = :productLevel2Id", nativeQuery = true)
    void addDiscount(@Param("productLevel2Id") String productLevel2Id,@Param("percentage") int discount);

    @Transactional
    @Modifying
    @Query(value = "update ProductLevel2 u set u.rating = :rating where u.productLevel2Id = :productLevel2Id", nativeQuery = true)
    void addRating(@Param("productLevel2Id") String productLevel2Id,@Param("rating") int rating);

}
