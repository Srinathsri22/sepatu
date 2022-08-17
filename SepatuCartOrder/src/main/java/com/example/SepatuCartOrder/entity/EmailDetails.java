package com.example.SepatuCartOrder.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmailDetails {
    private String recipient = "sepatumailorder@gmail.com";
    private String msgBody = "Thankyou for making the order";
    private String subject="Sepatu - Your recent purchase";
}
