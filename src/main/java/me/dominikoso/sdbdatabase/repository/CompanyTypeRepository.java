package me.dominikoso.sdbdatabase.repository;

import me.dominikoso.sdbdatabase.model.CompanyType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyTypeRepository extends CrudRepository<CompanyType, Long> {
    List<CompanyType> findAll();
}
