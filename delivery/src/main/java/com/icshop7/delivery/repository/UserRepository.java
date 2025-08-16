package com.icshop7.delivery.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.icshop7.delivery.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	
	//many predefined Methods are available which will help us to
	//perform various crud Operations
	 @Query(value = "SELECT e FROM User e ORDER BY username")
	   public List<User> findAllSortedByName();
	 

//	 @Query(value = "SELECT * FROM person WHERE   name  LIKE BINARY CONCAT('%',:letter,'%')", nativeQuery = true)
//	    List<User> findByNameLike( @Param("letter") String letter);

	
}
//Spring =DI + IoC ( Object :: ---> Autowired Any Place in Application) + 
//Many Modules(ORM + WEb + core + JDBC + test etc)

// SpringBOOT=Spring + embedded Apache tomcate server + devtools +Actuators + 
                          //ready template support initializers + Auto configuration +
                          //Starter dependencies

