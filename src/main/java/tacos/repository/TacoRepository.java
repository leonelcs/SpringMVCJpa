package tacos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tacos.domain.Taco;

@Repository
public interface TacoRepository extends CrudRepository<Taco, Long>{

}
