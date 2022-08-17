package com.example.SepatuOrderEmail.entity;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Data
@NoArgsConstructor

public class EmailDetails {
    private String recipient = "sepatumailorder@gmail.com";
    private String msgBody = "Thankyou for making the order..";
    private String subject = "Sepatu - Your recent purchase..";
}
