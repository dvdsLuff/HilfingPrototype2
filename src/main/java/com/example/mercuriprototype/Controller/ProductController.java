package com.example.mercuriprototype.Controller;


import com.example.mercuriprototype.ProductMapper;
import com.example.mercuriprototype.Service.ProductService;
import com.example.mercuriprototype.domain.Product;
import com.example.mercuriprototype.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class ProductController {
    ArrayList<Product> products;
    ProductMapper productMapper = new ProductMapper();
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String index(Model model) throws SQLException {
        products = productMapper.getAll();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute Product product) throws Throwable {



        productService.create(product);
        productMapper.createProduct(product);


        return "redirect:/index";
    }

    @GetMapping("/delete")
    public String delete(Model model) throws SQLException {
        products = productMapper.getAll();
        model.addAttribute("products", products);
        return "delete";
    }

    @PostMapping("/delete")
    public String postDelete(@RequestParam int id) throws Exception {

        productService.delete(id);
        productMapper.deleteProduct(id);
        return "index";
    }


    @GetMapping("/update")
    public String update(Model model) throws SQLException {
        products = productMapper.getAll();
        model.addAttribute("products", products);

        return "update";
    }


    @PostMapping("/update")
    public String postUpdate(@ModelAttribute Product product) throws Exception {
//      productService.update(product);
        productService.create(product);
        productMapper.updateProduct(product);



        return "index";

    }
}

