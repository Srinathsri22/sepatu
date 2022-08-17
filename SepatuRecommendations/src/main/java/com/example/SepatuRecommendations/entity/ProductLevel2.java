package com.example.SepatuRecommendations.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@ToString
@Entity
@Table
public class ProductLevel2 {

    @Id
    String productLevel2Id;
    //String productLevel1Id;
    String productColor;
    int size;
    int rating;
    String merchantId;
    int discount;
    Date date;
    @Column(columnDefinition = "TEXT")
    String description;

    @ManyToOne
    @JoinColumn(columnDefinition = "product_level1_id", referencedColumnName = "productLevel1Id")
    ProductLevel1 productLevel1;
}
