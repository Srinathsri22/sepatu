package com.example.SepatuMerchantProducer.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
@Setter

public class ProductLevel2Dto {

    String productLevel2Id;
    String productLevel1Id;
    String productColor;
    int size;
    int rating;
    int quantity;
    String merchantId;
    int discount;
    Date date;
    String description;

    public void setProductLevel2Id(String productLevel2Id) {
        this.productLevel2Id = productLevel2Id;
    }

    public void setProductLevel1Id(String productLevel1Id) {
        this.productLevel1Id = productLevel1Id;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
