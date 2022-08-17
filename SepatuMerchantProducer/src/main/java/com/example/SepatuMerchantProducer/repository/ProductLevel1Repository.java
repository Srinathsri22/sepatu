package com.example.SepatuMerchantProducer.repository;

import com.example.SepatuMerchantProducer.dto.ProductLevel1Dto;
import com.example.SepatuMerchantProducer.entity.ProductLevel1;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductLevel1Repository extends CrudRepository<ProductLevel1, String > {
//    public Optional<ProductLevel1> findById(Integer id);

    @Query(value = "SELECT * FROM product_level1 p WHERE p.product_level1id = :productLevel1Id", nativeQuery = true)
        public ProductLevel1 findByProductLevel1ProductLevel1Id(@Param("productLevel1Id") String productLevel1Id);
}
