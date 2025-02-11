//package com.ns.nearby_solutions.tool_rental;
//
//import com.ns.nearby_solutions.user.User;
//import com.ns.nearby_solutions.user.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/tool-customer")
//public class ToolCustomerController {
//
//    @Autowired
//    private ToolRentalListingRepository toolRentalListingRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
////    @GetMapping
////    public ToolUserFullDTO getToolAndUserData(
////            @RequestParam("toolId") Long toolId,
////            @RequestParam("customerId") Integer customerId
////    ) {
////        Optional<User> user  =  userRepository.findById(customerId);
////        System.out.println("customer---------" + user);
////        Optional<ToolRentalListing> toolRentalListing  = toolRentalListingRepository.findByToolId(toolId);
////        System.out.println("---------" + toolRentalListing);
////        // Return the combined DTO
////        return new ToolUserFullDTO(toolId, customerId, toolRentalListing, user);
////    }
//}
