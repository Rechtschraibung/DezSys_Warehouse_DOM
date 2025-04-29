package warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warehouse.model.ProductData;
import warehouse.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductData addProduct(ProductData product) {
        return productRepository.save(product);
    }

    public List<ProductData> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<ProductData> findProductByID(String id) {
        return productRepository.findById(id);
    }

    public void deleteProduct(String id) {
        Optional<ProductData> product = productRepository.findById(id);
        product.ifPresent(productData -> productRepository.delete(productData));
    }
}
