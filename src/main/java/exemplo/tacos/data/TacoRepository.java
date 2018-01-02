package exemplo.tacos.data;

import org.springframework.data.repository.CrudRepository;

import exemplo.tacos.domain.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {

}
