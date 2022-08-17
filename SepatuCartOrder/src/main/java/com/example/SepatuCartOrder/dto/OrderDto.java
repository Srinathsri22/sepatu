package com.example.SepatuCartOrder.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OrderDto {

    String productLevel2Id;
    String userId;
    int quantity;
    String productLevel1Id;
    ProductLevel1Dto productLevel1Dto;
    ProductLevel2Dto productLevel2Dto;

    public void setProductLevel1Dto(ProductLevel1Dto productLevel1Dto) {
        this.productLevel1Dto = productLevel1Dto;
    }

    public void setProductLevel2Dto(ProductLevel2Dto productLevel2Dto) {
        this.productLevel2Dto = productLevel2Dto;
    }
}
