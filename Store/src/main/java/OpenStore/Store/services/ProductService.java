package OpenStore.Store.services;

import OpenStore.Store.entities.Product;
import OpenStore.Store.repositories.ProductRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository productRepository;



    public Product createProduct( Product product){

        return productRepository.save(product);

    }



    public Product updateProduct( Long id ,  Product product){

        Product existingProduct = productRepository.findById(id).
                orElseThrow(()-> new RuntimeException(" Product Not Found "+id));



        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStockQuantity(product.getStockQuantity());

        return  productRepository.save(existingProduct);


    }




    public List<Product> getProduct(){

        return productRepository.findAll();

    }


    public Product getProductById(  Long id){

        return productRepository.findById(id).orElseThrow(()->  new RuntimeException("The Product Is Not Found With The ID"+id));

    }

    public void deletProduct( Long id){

         productRepository.deleteById(id);


    }
}
