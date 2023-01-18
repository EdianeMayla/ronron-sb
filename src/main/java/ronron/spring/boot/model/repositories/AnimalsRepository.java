package ronron.spring.boot.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import ronron.spring.boot.model.entities.Animals;

public interface AnimalsRepository extends PagingAndSortingRepository<Animals, Integer>{

	@Query("SELECT a FROM Animals a WHERE a.type = :type AND a.gender = :gender AND a.collors = :collors")
	public Iterable<Animals> search(@Param("type") String type, @Param("gender") String gender, @Param("collors") String collors );
	
}





