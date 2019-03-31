package me.dominikoso.sdbdatabase.repository;

import me.dominikoso.sdbdatabase.model.AddressData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressDataRepository extends CrudRepository<AddressData, Long> {

    List<AddressData> findAll();

}
