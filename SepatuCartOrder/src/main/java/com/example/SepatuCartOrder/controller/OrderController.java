package com.example.SepatuCartOrder.controller;
import com.example.SepatuCartOrder.dto.CartDto;
import com.example.SepatuCartOrder.dto.OrderDto;
import com.example.SepatuCartOrder.entity.Cart;
import com.example.SepatuCartOrder.entity.EmailDetails;
import com.example.SepatuCartOrder.entity.Order;
import com.example.SepatuCartOrder.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    JavaMailSender javaMailSender;

//    @Autowired
//    RestTemplate restTemplate;

    @PostMapping(value = "/addOrder")
    public Order addOrder(@RequestBody OrderDto orderDto){
        Order order = new Order();

        try {
            BeanUtils.copyProperties(orderDto, order);
            orderService.addOrder(order);
            sendMail();
            return order;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    public void sendMail(){
        try{
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            EmailDetails emailDetails = new EmailDetails();
            mailMessage.setTo(emailDetails.getRecipient());
            mailMessage.setSubject(emailDetails.getSubject());
            mailMessage.setText(emailDetails.getMsgBody());
            javaMailSender.send(mailMessage);
            System.out.println("done");
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    @GetMapping(value = "/viewOrder/{userId}")
    public List<OrderDto> viewOrder(@PathVariable("userId")String userId){

        try{
            List<OrderDto> order =  orderService.viewOrder(userId);
            return order;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }



}
