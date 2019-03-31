package me.dominikoso.sdbdatabase.repository;

import me.dominikoso.sdbdatabase.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    List<Owner> findAll();

}
