package com.example.SepatuCartOrder.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class ProductDto {
    String productLevel1Id;
    String productName;
    String brandName;
    String productGender;
    String productType;
    int price;
    String imageUrl;
    ProductLevel2Dto productLevel2Dto;

    public void setProductLevel2Dto(ProductLevel2Dto productLevel2Dto) {
        this.productLevel2Dto = productLevel2Dto;
    }
}
