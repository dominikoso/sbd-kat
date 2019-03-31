package me.dominikoso.sdbdatabase.controller;

import me.dominikoso.sdbdatabase.dto.UserDto;
import me.dominikoso.sdbdatabase.model.User;
import me.dominikoso.sdbdatabase.repository.UserRepository;
import me.dominikoso.sdbdatabase.tools.NullAwareBeanUtilsBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers() { return userRepository.findAll(); }

    @RequestMapping(method = RequestMethod.POST)
    public User saveUser(@RequestBody UserDto userDto) {
        User toSave = new User();
        BeanUtils.copyProperties(userDto, toSave);
        return userRepository.save(toSave);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateUser(@RequestBody UserDto userDto) {
        User toUpdate = userRepository.findById(userDto.getId()).orElse(null);
        if (toUpdate == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't update not existing Entity");
        }else {
            NullAwareBeanUtilsBean.myCopyProperties(userDto, toUpdate);
            return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(toUpdate));
        }
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable Long id) {
        if (userRepository.findById(id).orElse(null) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't remove not existing Entity");
        }else{
            userRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Successfully removed entity with id " + id);
        }
    }

}
