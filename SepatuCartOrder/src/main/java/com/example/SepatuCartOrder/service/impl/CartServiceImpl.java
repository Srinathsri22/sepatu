package com.example.SepatuCartOrder.service.impl;
import com.example.SepatuCartOrder.dto.CartDto;
import com.example.SepatuCartOrder.dto.ProductDto;
import com.example.SepatuCartOrder.dto.ProductLevel1Dto;
import com.example.SepatuCartOrder.dto.ProductLevel2Dto;
import com.example.SepatuCartOrder.entity.Cart;
import com.example.SepatuCartOrder.repository.CartRepository;
import com.example.SepatuCartOrder.service.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
class CartServiceImpl implements CartService {

     @Autowired
     CartRepository cartRepository;

     @Autowired
    MongoTemplate mongoTemplate;


     public Cart addCart(Cart cart){

         Cart cart1 = cartRepository.save(cart);
         System.out.println(cart1);
        return cart1;
    }

    public void removeCart(String productLevel2Id){
         cartRepository.deleteByProductLevel2Id(productLevel2Id);

    }

    public Optional<Cart> findByProductLevel2Id(String productLevel2Id){
        Optional<Cart> cart =  cartRepository.findByProductLevel2Id(productLevel2Id);
        return cart;
    }

    public List<CartDto> readCart(String userId){
        List<CartDto> cartDtoList = new ArrayList<>();
//        System.out.println(cartRepository.findByUserId(userId));
         List<Cart> cartList = cartRepository.findByUserId(userId);
//        System.out.println(cartList);
         for(int i=0;i<cartList.size(); i++)
         {
             CartDto cartDto = new CartDto();
             BeanUtils.copyProperties(cartList.get(i), cartDto);

             //connect to SepatuMerchant
            cartList.get(i).setQuantity(cartList.size());

             RestTemplate restTemplate2 = new RestTemplate();
             String resourceUrl2 = "http://localhost:8082/productLevel2/findByProductLevel2Id/"+cartList.get(i).getProductLevel2Id();
             ResponseEntity<ProductLevel2Dto> responseEntity2 = restTemplate2.getForEntity(resourceUrl2, ProductLevel2Dto.class);
//             System.out.println(responseEntity2.getBody().getProductLevel1Id());


             RestTemplate restTemplate1 = new RestTemplate();
             String resourceUrl1 = "http://localhost:8082/productLevel1/findByProductLevel1ProductLevel1Id/"+responseEntity2.getBody().getProductLevel1Id();
             ResponseEntity<ProductLevel1Dto> responseEntity1= restTemplate1.getForEntity(resourceUrl1,ProductLevel1Dto.class);

             cartDto.setProductLevel1Dto(responseEntity1.getBody());
             cartDto.setProductLevel2Dto(responseEntity2.getBody());
             cartDtoList.add(cartDto);
//             System.out.println(cartDto);
         }
         return cartDtoList;
    }

    public Cart updateCartQuantity(String productLevel2Id, int quantity){
        Optional<Cart> cart = cartRepository.findByProductLevel2Id(productLevel2Id);
        cart.get().setQuantity(quantity);
        Cart cart1 = new Cart();
        BeanUtils.copyProperties(cart.get(), cart1);
        cartRepository.deleteByProductLevel2Id(productLevel2Id);
        cartRepository.save(cart1);
        return cart1;
    }

    public List<Cart> findByUserId(String userId){
         try{
             List<Cart> cartList = cartRepository.findByUserId(userId);
             return cartList;
         }
         catch (Exception e){
             System.out.println(e);
         }
         return null;
    }
}
