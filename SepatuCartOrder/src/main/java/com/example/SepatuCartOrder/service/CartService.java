package com.example.SepatuCartOrder.service;

//import com.example.sepatuCartOrder.dto.CartDto;

import com.example.SepatuCartOrder.dto.CartDto;
import com.example.SepatuCartOrder.dto.ProductDto;
import com.example.SepatuCartOrder.dto.ProductLevel2Dto;
import com.example.SepatuCartOrder.entity.Cart;

import java.util.List;
import java.util.Optional;


public interface CartService {

    public Cart addCart(Cart cart);
    public void removeCart(String productLevel2Id);
    public Cart updateCartQuantity(String productLevel2Id, int quantity);
    public List<CartDto> readCart(String userId);
    public List<Cart> findByUserId(String userId);
}
