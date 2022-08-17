package com.example.SepatuCartOrder.controller;


import com.example.SepatuCartOrder.dto.CartDto;

//import com.example.sepatuCart.dto.CartDto;
//import com.example.sepatuCart.service.CartService;
import com.example.SepatuCartOrder.dto.ProductDto;
import com.example.SepatuCartOrder.entity.Cart;
import com.example.SepatuCartOrder.service.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping(value = "/addCart")
    public Cart addCart(@RequestBody CartDto cartDto){
        Cart cart = new Cart();

        try {

            BeanUtils.copyProperties(cartDto, cart);
            cartService.addCart(cart);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return cart;
    }

    @DeleteMapping(value = "/removeCart/{productLevel2Id}")
    public CartDto removeCart(@PathVariable("productLevel2Id") String productLevel2Id){

        try {
            cartService.removeCart(productLevel2Id);
            return new CartDto();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return new CartDto();

    }

    @PutMapping(value = "/updateCartQuantity/{productLevel2Id}/{quantity}")
    public Cart updateCartQuantity(@PathVariable("productLevel2Id") String productLevel2Id, @PathVariable("quantity") int quantity){

        try {
            Cart cart = cartService.updateCartQuantity(productLevel2Id, quantity);
            return cart;

        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    @GetMapping(value = "/readCart/{userId}")
    public List<CartDto> readCart(@PathVariable("userId")String userId){
        try{
            List<CartDto> cart = cartService.readCart(userId);
            return cart;
        }
        catch (Exception e){
            System.out.println(e);
        }
         return null;
    }

    @GetMapping(value = "/getUserCart{userId}")
    public List<Cart> findByUserId(@PathVariable("userId") String userId){
        try{
            List<Cart> cartList = cartService.findByUserId(userId);
            return cartList;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

}
