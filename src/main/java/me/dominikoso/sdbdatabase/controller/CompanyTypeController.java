package me.dominikoso.sdbdatabase.controller;

import me.dominikoso.sdbdatabase.dto.CompanyTypeDto;
import me.dominikoso.sdbdatabase.model.CompanyType;
import me.dominikoso.sdbdatabase.repository.CompanyTypeRepository;
import me.dominikoso.sdbdatabase.tools.NullAwareBeanUtilsBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/companyType")
public class CompanyTypeController {

    @Autowired
    CompanyTypeRepository companyTypeRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<CompanyType> getAllCompanyTypes() { return companyTypeRepository.findAll(); }

    @RequestMapping(method = RequestMethod.POST)
    public CompanyType saveCompanyType(@RequestBody CompanyTypeDto CompanyTypeDto) {
        CompanyType toSave = new CompanyType();
        BeanUtils.copyProperties(CompanyTypeDto, toSave);
        return companyTypeRepository.save(toSave);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateCompanyType(@RequestBody CompanyTypeDto CompanyTypeDto) {
        CompanyType toUpdate = companyTypeRepository.findById(CompanyTypeDto.getId()).orElse(null);
        if (toUpdate == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't update not existing Entity");
        }else {
            NullAwareBeanUtilsBean.myCopyProperties(CompanyTypeDto, toUpdate);
            return ResponseEntity.status(HttpStatus.OK).body(companyTypeRepository.save(toUpdate));
        }
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCompanyType(@PathVariable Long id) {
        if (companyTypeRepository.findById(id).orElse(null) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't remove not existing Entity");
        }else{
            companyTypeRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Successfully removed entity with id " + id);
        }
    }
}
