package com.example.SepatuCartOrder.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartDto {

    String userId;
    ProductLevel1Dto productLevel1Dto;
    ProductLevel2Dto productLevel2Dto;
    String productLevel2Id;
    int quantity;
//    String productLevel1Id;
    String productLevel1Id;
    public void setProductLevel1Dto(ProductLevel1Dto productLevel1Dto) {
        this.productLevel1Dto = productLevel1Dto;
    }

    public void setProductLevel2Dto(ProductLevel2Dto productLevel2Dto) {
        this.productLevel2Dto = productLevel2Dto;
    }
}
