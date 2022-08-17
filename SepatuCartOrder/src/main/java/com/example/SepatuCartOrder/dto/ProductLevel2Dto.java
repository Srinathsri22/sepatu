package com.example.SepatuCartOrder.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@ToString
public class ProductLevel2Dto {

    String productLevel1Id;
    String productLevel2Id;
    String productColor;
    int size;
    int rating;
    int quantity;
    String merchantId;
    int discount;
    Date createdDate; //epoch - > long date;
    String description;


}
