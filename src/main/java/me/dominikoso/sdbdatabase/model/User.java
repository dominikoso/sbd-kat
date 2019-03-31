package me.dominikoso.sdbdatabase.model;

import com.fasterxml.jackson.databind.util.BeanUtil;
import me.dominikoso.sdbdatabase.dto.UserDto;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    //region Variables

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer personelNumber;
    private String login;
    private String password;
    private String workerName;
    private String workerSurname;
    private String department;

    //endregion Variables

    //region Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPersonelNumber() {
        return personelNumber;
    }

    public void setPersonelNumber(Integer personelNumber) {
        this.personelNumber = personelNumber;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getWorkerSurname() {
        return workerSurname;
    }

    public void setWorkerSurname(String workerSurname) {
        this.workerSurname = workerSurname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    //endregion

}
