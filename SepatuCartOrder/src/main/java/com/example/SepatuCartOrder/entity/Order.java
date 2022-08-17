package com.example.SepatuCartOrder.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@ToString
@Document
public class Order {
    String productLevel2Id;
    String productLevel1Id;
    String userId;
    int quantity;
}
