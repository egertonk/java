package com.ns.nearby_solutions.checkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    // Add items to the cart
    @PostMapping
    public Cart addToCart(@RequestBody Cart cart) {
        return cartRepository.save(cart);
    }

    // Retrieve carts for a specific user
    @GetMapping("/{userId}")
    public List<Cart> getCartByUser(@PathVariable Long userId) {
        return cartRepository.findByCustomer_Id(userId);
    }

    // Route to get all Cart
    @GetMapping
    public List<Cart> getAllCartItems() {
        return cartRepository.findAll();
    }
}
