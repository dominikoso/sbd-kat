package me.dominikoso.sdbdatabase.repository;

import me.dominikoso.sdbdatabase.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository<Users, Long> {

    List<Users> findAll();
    Users findByLogin(String login);

}
