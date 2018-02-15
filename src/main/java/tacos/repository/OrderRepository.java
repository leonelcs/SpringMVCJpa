package tacos.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tacos.domain.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{
	
	List<Order> findByZip(String deliveryZip);

}
