package me.dominikoso.sdbdatabase.controller;

import me.dominikoso.sdbdatabase.dto.OwnerDto;
import me.dominikoso.sdbdatabase.model.Owner;
import me.dominikoso.sdbdatabase.repository.OwnerRepository;
import me.dominikoso.sdbdatabase.tools.NullAwareBeanUtilsBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/owner")
public class OwnerController {
    @Autowired
    OwnerRepository ownerRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Owner> getAllOwners() { return ownerRepository.findAll(); }

    @RequestMapping(method = RequestMethod.POST)
    public Owner saveOwner(@RequestBody OwnerDto ownerDto) {
        Owner toSave = new Owner();
        BeanUtils.copyProperties(ownerDto, toSave);
        return ownerRepository.save(toSave);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateOwner(@RequestBody OwnerDto ownerDto) {
        Owner toUpdate = ownerRepository.findById(ownerDto.getId()).orElse(null);
        if (toUpdate == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't update not existing Entity");
        }else {
            NullAwareBeanUtilsBean.myCopyProperties(ownerDto, toUpdate);
            return ResponseEntity.status(HttpStatus.OK).body(ownerRepository.save(toUpdate));
        }
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteOwner(@PathVariable Long id) {
        if (ownerRepository.findById(id).orElse(null) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't remove not existing Entity");
        }else{
            ownerRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Successfully removed entity with id " + id);
        }
    }
}
