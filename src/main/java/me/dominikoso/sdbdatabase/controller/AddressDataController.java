package me.dominikoso.sdbdatabase.controller;

import me.dominikoso.sdbdatabase.dto.AddressDataDto;
import me.dominikoso.sdbdatabase.model.AddressData;
import me.dominikoso.sdbdatabase.repository.AddressDataRepository;
import me.dominikoso.sdbdatabase.tools.NullAwareBeanUtilsBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressDataController {


    @Autowired
    AddressDataRepository addressDataRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<AddressData> getAllAddressDatas() { return addressDataRepository.findAll(); }

    @RequestMapping(method = RequestMethod.POST)
    public AddressData saveAddressData(@RequestBody AddressDataDto AddressDataDto) {
        AddressData toSave = new AddressData();
        BeanUtils.copyProperties(AddressDataDto, toSave);
        return addressDataRepository.save(toSave);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateAddressData(@RequestBody AddressDataDto AddressDataDto) {
        AddressData toUpdate = addressDataRepository.findById(AddressDataDto.getId()).orElse(null);
        if (toUpdate == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't update not existing Entity");
        }else {
            NullAwareBeanUtilsBean.myCopyProperties(AddressDataDto, toUpdate);
            return ResponseEntity.status(HttpStatus.OK).body(addressDataRepository.save(toUpdate));
        }
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAddressData(@PathVariable Long id) {
        if (addressDataRepository.findById(id).orElse(null) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't remove not existing Entity");
        }else{
            addressDataRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Successfully removed entity with id " + id);
        }
    }
    
}
