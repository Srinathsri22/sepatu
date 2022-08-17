package com.example.SepatuRecommendations.dto;


import com.example.SepatuRecommendations.entity.ProductLevel1;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
}
