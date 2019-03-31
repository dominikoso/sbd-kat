package me.dominikoso.sdbdatabase.dto;

public class UserDto {

    //region Variables

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
