package me.dominikoso.sdbdatabase.controller;

import me.dominikoso.sdbdatabase.config.SecurityConfiguration;
import me.dominikoso.sdbdatabase.dto.UsersDto;
import me.dominikoso.sdbdatabase.model.Users;
import me.dominikoso.sdbdatabase.repository.UsersRepository;
import me.dominikoso.sdbdatabase.tools.NullAwareBeanUtilsBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/user")
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(method = RequestMethod.GET)
    public List<Users> getAllUsers() { return usersRepository.findAll(); }

    @RequestMapping(method = RequestMethod.POST)
    public Users saveUser(@RequestBody UsersDto userDto) {
        Users toSave = new Users();
        BeanUtils.copyProperties(userDto, toSave);
        toSave.setPassword(passwordEncoder.encode(toSave.getPassword()));
        return usersRepository.save(toSave);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateUser(@RequestBody UsersDto userDto) {
        Users toUpdate = usersRepository.findById(userDto.getId()).orElse(null);
        if (toUpdate == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't update not existing Entity");
        }else {
            if(userDto.getPassword() != null){
                userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
            }
            NullAwareBeanUtilsBean.myCopyProperties(userDto, toUpdate);
            return ResponseEntity.status(HttpStatus.OK).body(usersRepository.save(toUpdate));
        }
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable Long id) {
        if (usersRepository.findById(id).orElse(null) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't remove not existing Entity");
        }else{
            usersRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Successfully removed entity with id " + id);
        }
    }

}
