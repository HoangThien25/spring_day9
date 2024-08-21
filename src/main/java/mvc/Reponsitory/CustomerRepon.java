package mvc.Reponsitory;

import mvc.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepon extends JpaRepository<Customer,Integer> {
}
