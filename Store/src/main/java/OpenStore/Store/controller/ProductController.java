package OpenStore.Store.controller;

import OpenStore.Store.entities.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product){

        return null;

    }


    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable  Long id ,@Valid @RequestBody Product product){

        return null;
    }




    @GetMapping
    public List<Product> getProduct(){

        return null;

    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable  Long id){

        return null;

    }

    @DeleteMapping("/{id}")
    public void deletProduct(@PathVariable  Long id){


    }



}
