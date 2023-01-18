package ronron.spring.boot.model.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import ronron.spring.boot.model.entities.Users;

public interface UsersRepository extends PagingAndSortingRepository<Users, Integer>{
	
	@Query("SELECT a FROM Users a WHERE a.username = :username")
	public Users findByUsername(@Param("username") String username);
	
}
			
