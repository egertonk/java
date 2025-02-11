//package com.ns.nearby_solutions.rental;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
//@RequestMapping("/api/tools")
//public class ToolController {
//    @Autowired
//    private ToolRepository toolRepository;
//
//    @PostMapping
//    public Tool addTool(@RequestBody Tool tool) {
//        return toolRepository.save(tool);
//    }
//
//    @GetMapping
//    public List<Tool> getAllTools() {
//        return toolRepository.findAll();
//    }
//}