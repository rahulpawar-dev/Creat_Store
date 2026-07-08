package OpenStore.Store.controller;

import OpenStore.Store.entities.Product;
import OpenStore.Store.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/products")
//@RequiredArgsConstructor



public class ProductController {

 private  final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

 @PostMapping
    public Product createProduct(@Valid @RequestBody Product product){

        return productService.createProduct(product);

    }


    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable  Long id ,@Valid @RequestBody Product product){

        return productService.updateProduct(id , product);
    }




    @GetMapping
    public List<Product> getProduct(){

        return  productService.getProduct();

    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable  Long id){

        return productService.getProductById(id);

    }

    @DeleteMapping("/{id}")
    public void deletProduct(@PathVariable  Long id){
        productService.deletProduct(id);


    }



}
