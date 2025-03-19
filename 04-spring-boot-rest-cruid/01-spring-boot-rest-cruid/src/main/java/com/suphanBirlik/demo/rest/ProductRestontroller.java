package com.suphanBirlik.demo.rest;


import com.suphanBirlik.demo.entity.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestontroller {

    private List<Product> theProduct;

    // define @PostConstruct to load line a product ... only once;
    @PostConstruct
    public void loadData(){
        theProduct = new ArrayList<>();

        theProduct.add(new Product("Mercedes", "cls63"));
        theProduct.add(new Product("Audi", "Rs6MTM"));
        theProduct.add(new Product("Hyundai", "i20N-line"));

    }

    // define endpoint for "/products" - return a list of products
    @GetMapping("/products")
    public List<Product> getProduct(){

        return theProduct;
    }

    // define endpoint or "/products/{productId}" - return product at index
    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable int productId){

        //just index into the list ... keep it simple for now

        //check the studentId again list size
        if((productId >= theProduct.size()) || (productId < 0)){
            throw new ProductNotFoundExeption("Product Id Not Found, All user numbers is -- " + theProduct.size());
        }
        return theProduct.get(productId);
    }

    // Add an exeption handler using @ExeptionHandler
    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> handleException(ProductNotFoundExeption exc) {
        ProductErrorResponse error = new ProductErrorResponse(
                exc.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
