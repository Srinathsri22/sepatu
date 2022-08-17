package com.example.SepatuMerchantProducer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table
public class ProductLevel1 {

    @Id
            @Column(name = "prod")
    String productLevel1Id;


    @Column(name = "product_name")
    String productName;

    @Column(name = "product_name")
    String brandName;
    String productGender;
    String productType;
    int price;
    @Column(columnDefinition = "text")
    String imageUrl;

    @OneToMany
    @JoinColumn(columnDefinition = "product_level1_product_level1id", referencedColumnName = "productLevel1id")
    List<ProductLevel2> productLevel2List;
}
