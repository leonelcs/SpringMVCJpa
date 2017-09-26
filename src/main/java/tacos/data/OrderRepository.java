package tacos.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tacos.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
	
	List<Order> findByDeliveryZip(String deliveryZip);

}
