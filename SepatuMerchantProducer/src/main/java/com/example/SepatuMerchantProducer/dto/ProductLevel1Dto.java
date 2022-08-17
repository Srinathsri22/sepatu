package com.example.SepatuMerchantProducer.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter

public class ProductLevel1Dto {

    String productLevel1Id;
    String productName;
    String brandName;
    String productGender;
    String productType;
    String imageUrl;
    int price;
}
