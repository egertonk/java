package com.ns.nearby_solutions.checkout;

import com.ns.nearby_solutions.orders.Order;
import com.ns.nearby_solutions.rental.ToolService;
import com.ns.nearby_solutions.skill.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ToolService toolService;

    @Autowired
    private SkillService skillService;

    // Add tool or service to the cart
    public Cart addToCart(Long userId, Long itemId, String itemType) {
//        Cart cart = cartRepository.findByCustomerId(userId).orElse(new Cart());
//
//        if ("tool".equalsIgnoreCase(itemType)) {
//            Tool tool = toolService.getToolById(itemId);
//            cart.getTools().add(tool);
//        } else if ("service".equalsIgnoreCase(itemType)) {
//            Skill skill = skillService.getSkillById(itemId);
//            cart.getServices().add(skill);
//        }
//
//        return cartRepository.save(cart);
        return null;
    }

    // Get cart by user
//    public Cart getCartByUserId(Long userId) {
//        return cartRepository.findByCustomerId(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("Cart not found for user id: " + userId));
//    }

    // Checkout the cart (finalizing the order)
    public Order checkout(Long userId) {
//        Cart cart = getCartByUserId(userId);
//
//        // Logic to create orders based on items in the cart
//        for (Tool tool : cart.getTools()) {
//            Order order = new Order();
//            order.setTool(tool);
//            // Add other order details
//            // Save the order...
//        }
//
//        for (Skill service : cart.getServices()) {
//            Order order = new Order();
//            order.setSkill(service);
//            // Add other order details
//            // Save the order...
//        }
//
//        // Clear the cart after checkout
//        cart.getTools().clear();
//        cart.getServices().clear();
//        cartRepository.save(cart);

        return null; // Return appropriate response
    }
}
