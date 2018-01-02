package exemplo.tacos.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import exemplo.tacos.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
	
	List<Order> findByDeliveryZip(String deliveryZip);

}
