package com.example.postgres.connect.crud.controller;

import com.example.postgres.connect.crud.exception.ResourceNotFoundException;
import com.example.postgres.connect.crud.model.Product;
import com.example.postgres.connect.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product_management")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Integer productId)
            throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        // lỗi sai thứ nhất là đường dẫn thừa khoảng trắng, dẫn đến nó ko đúng url
        // thứ 2 là model bị sai kiểu dữ liệu
        // thứ 3 là Mọi kiểu dữ liệu trong model đều phải là đối tượng. Ví dụ như dùng "Long" khong phải 'long', "Integer" chứ ko phải 'int'
        return productRepository.save(product);
    }

//    @PutMapping("/products/{id}")
//    public Product updateProduct(@RequestBody Product productDetails) {
//        if(productRepository.findById(productDetails.getIdProduct()) == null){
//            // Tí nữa xử lý vứt exception trong này
////
//        }
//        return productRepository.save(productDetails);
//    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Integer productId,
                                                 @RequestBody Product productDetails) throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + productId));

        product.setNameProduct(productDetails.getNameProduct());
        final Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }


    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable(name = "id") Integer productId){
        productRepository.deleteById(productId);
    }
}
