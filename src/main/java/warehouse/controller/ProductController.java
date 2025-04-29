package warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import warehouse.model.ProductData;
import warehouse.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductData> addProduct(@RequestBody ProductData product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @GetMapping
    public List<ProductData> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductData> getProductById(@PathVariable String id) {
        Optional<ProductData> product = productService.getProductByID(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable String id) {
        if (productService.getProductByID(id).isPresent()) {
            productService.deleteProduct(id);
            return ResponseEntity.ok("Produkt gelöscht.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
