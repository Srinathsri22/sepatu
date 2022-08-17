package com.example.SepatuCartOrder.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@ToString
@Document
public class Cart {
    String userId;
    String productLevel2Id;
    String productLevel1Id;
    int quantity;
}
