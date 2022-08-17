package com.example.SepatuMerchantProducer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Table
@Entity
public class ProductLevel2 {

    @Id
    String productLevel2Id;

    String productColor;
    int size;
    int rating;
    int quantity;
    String merchantId;
    int discount;
    Date date;
    String description;

    @ManyToOne
    @JoinColumn(columnDefinition = "product_level1_product_level1id", referencedColumnName = "productLevel1id")
    ProductLevel1 productLevel1;


}
