package com.example.mercuriprototype.Controller;


import com.example.mercuriprototype.ProductMapper;
import com.example.mercuriprototype.Service.ProductService;
import com.example.mercuriprototype.domain.Product;
import com.example.mercuriprototype.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    ProductMapper productMapper = new ProductMapper();
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @GetMapping("/index")
    public String index() {
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
    public String delete() {
        return "delete";
    }

    @PostMapping("/delete")
    public String postDelete(@RequestParam int id) throws Exception {

        productService.delete(id);
        productMapper.deleteProduct(id);
        return "index";
    }


    @GetMapping("/update")
    public String update() {
        return "update";
    }


    @PostMapping("/update")
    public String postUpdate(@ModelAttribute Product product) throws Exception {
      productService.update(product);



        return "index";

    }
}

