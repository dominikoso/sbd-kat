package me.dominikoso.sdbdatabase.dto;

public class CompanyTypeDto {

    //region Variables

    private Long id;

    private String shortName;
    private String fullName;

    //endregion

    //region Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    //endregion
}
