package com.example.SepatuCartOrder.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductLevel1Dto {
    String productLevel1Id;
    String productName;
    String brandName;
    String productGender;
    String productType;
    int price;
    String imageUrl;
}
