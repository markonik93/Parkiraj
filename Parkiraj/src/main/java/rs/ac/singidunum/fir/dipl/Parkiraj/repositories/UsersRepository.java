package rs.ac.singidunum.fir.dipl.Parkiraj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rs.ac.singidunum.fir.dipl.Parkiraj.entities.User;

public interface UsersRepository extends JpaRepository<User, Integer>{
	
	User findByUsernameAndPassword(String username, String password);
	@Query("select u from user u where u.username=:username and u.password=:password")
    User check(@Param("username") String username, @Param("password") String password);

}
