package ronron.spring.boot.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import ronron.spring.boot.model.entities.Animals;
import ronron.spring.boot.model.entities.Users;
import ronron.spring.boot.model.enuns.Situation;

public interface AnimalsRepository extends PagingAndSortingRepository<Animals, Integer>{

	//busca animais por filtros
	@Query("SELECT a FROM Animals a WHERE a.type = :type AND a.gender = :gender AND a.collors = :collors")
	public Iterable<Animals> search(@Param("type") String type, @Param("gender") String gender, @Param("collors") String collors );

	//busca animais resolvidos ou não
	@Query("SELECT a FROM Animals a WHERE a.solved = :solved")
	public Iterable<Animals> searchLost(@Param("solved") boolean solved);

	//buscar animais encontrados
	@Query("SELECT a FROM Animals a WHERE a.situation = :situation and a.solved = false")
	public Iterable<Animals> searchBySituation(@Param("situation") Situation situation);

	//busca animais por usuarios
	Iterable<Animals> findByUser(Users user);
}





