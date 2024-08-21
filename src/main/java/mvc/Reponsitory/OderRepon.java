package mvc.Reponsitory;

import mvc.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OderRepon extends JpaRepository<OrderEntity,Integer> {
}
