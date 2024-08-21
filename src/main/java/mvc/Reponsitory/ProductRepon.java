package mvc.Reponsitory;

import mvc.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepon extends JpaRepository<ProductEntity,Integer> {


}
