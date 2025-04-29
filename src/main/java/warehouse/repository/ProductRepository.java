package warehouse.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import warehouse.model.ProductData;

@Repository
public interface ProductRepository extends MongoRepository<ProductData, String> {
}