package com.example.SepatuRecommendations.dto;

import com.example.SepatuRecommendations.entity.ProductLevel2;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@ToString
@Getter
@Setter
public class ProductL1Dto {
    String productLevel1Id;
    String productName;
    String brandName;
    String productGender;
    String productType;
    String imageUrl;
    int price;
    List<ProductLevel2> listOfProductLevel2;

    public void setListOfProductLevel2(List<ProductLevel2> listOfProductLevel2) {
        this.listOfProductLevel2 = listOfProductLevel2;
    }
}
