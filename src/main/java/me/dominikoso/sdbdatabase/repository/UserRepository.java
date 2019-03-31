package me.dominikoso.sdbdatabase.repository;

import me.dominikoso.sdbdatabase.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

}
