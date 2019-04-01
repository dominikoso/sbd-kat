package me.dominikoso.sdbdatabase.dto;

import me.dominikoso.sdbdatabase.model.Users;

public class OwnerDto {

    //region Variables
    private Long Id;

    private String name;
    private String phone;
    private String mobilePhone;
    private String dateOfModification;
    private Users user;

    //endregion

    //region Getters and Setters

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getDateOfModification() {
        return dateOfModification;
    }

    public void setDateOfModification(String dateOfModification) {
        this.dateOfModification = dateOfModification;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }


    //endregion

}
