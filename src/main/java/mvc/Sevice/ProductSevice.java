package mvc.Sevice;

import mvc.model.ProductEntity;
import mvc.Reponsitory.ProductRepon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;

import java.util.List;
public class ProductSevice {
    @Autowired
    private ProductRepon productRepository;

    private JpaTransactionManager transactionManager;
    public ProductSevice(JpaTransactionManager transactionManager){
        this.transactionManager=transactionManager;
    }

    public ProductSevice() {
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductEntity getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }
}
