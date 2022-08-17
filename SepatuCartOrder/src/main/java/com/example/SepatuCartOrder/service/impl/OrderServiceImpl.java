package com.example.SepatuCartOrder.service.impl;

//import com.example.sepatuCart.service.OrderService;

import com.example.SepatuCartOrder.dto.OrderDto;
import com.example.SepatuCartOrder.dto.ProductLevel1Dto;
import com.example.SepatuCartOrder.dto.ProductLevel2Dto;
import com.example.SepatuCartOrder.entity.Order;
import com.example.SepatuCartOrder.repository.OrderRepository;
import com.example.SepatuCartOrder.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order addOrder(Order order) {
        try {
            orderRepository.save(order);
        } catch (Exception e) {
            System.out.println(e);
        }
    return order;
    }

    public List<OrderDto> viewOrder(String userId){
        try{
            List<OrderDto> orderDtoList = new ArrayList<>();
            List<Order> orderList = orderRepository.findByUserId(userId);
            System.out.println(orderList);

            for(int i=0;i<orderList.size();i++){
                OrderDto orderDto = new OrderDto();
                BeanUtils.copyProperties(orderList.get(i), orderDto);

                RestTemplate restTemplate2 = new RestTemplate();
                String resourceUrl2 = "http://localhost:8082/productLevel2/findByProductLevel2Id/"+orderList.get(i).getProductLevel2Id();
                ResponseEntity<ProductLevel2Dto> responseEntity2 = restTemplate2.getForEntity(resourceUrl2,ProductLevel2Dto.class);


                RestTemplate restTemplate1 = new RestTemplate();
                String resourceUrl1 = "http://localhost:8082/productLevel1/findByProductLevel1ProductLevel1Id/"+responseEntity2.getBody().getProductLevel1Id();
                ResponseEntity<ProductLevel1Dto> responseEntity1 = restTemplate1.getForEntity(resourceUrl1, ProductLevel1Dto.class);

                orderDto.setProductLevel1Dto(responseEntity1.getBody());
                orderDto.setProductLevel2Dto(responseEntity2.getBody());
                System.out.println(orderDto);
                orderDtoList.add(orderDto);
                System.out.println("final" + orderDtoList);

            }
            return orderDtoList;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
}
