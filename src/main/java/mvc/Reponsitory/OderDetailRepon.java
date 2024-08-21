package mvc.Reponsitory;

import mvc.model.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OderDetailRepon extends JpaRepository<OrderDetailEntity,Integer> {
}
