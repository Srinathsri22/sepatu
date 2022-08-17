package com.example.SepatuRecommendations.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table
public class ProductLevel1 {
    @Id
    String productLevel1Id;
    String productName;
    String brandName;
    String productGender;
    String productType;
    String imageUrl;
    int price;
}
