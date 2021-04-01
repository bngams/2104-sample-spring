package fr.aelion.gfi.spring.demo.sample.repositories;

import fr.aelion.gfi.spring.demo.sample.models.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// <--> @Component
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    // Query Method
    List<User> findByName(String name);

    User findFirstByName(String name);

    // @Query => JPQL or Native Query
    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE name LIKE %?1%")
    User findByNameLike(String name);
}

