package springBoot.data;

import org.springframework.data.repository.CrudRepository;

/**
 * @author brobinson
 */
public interface MyRepository extends CrudRepository<MyModel, Long> {
}
