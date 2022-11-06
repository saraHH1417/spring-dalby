package com.sara.springmvcdemomaven.Validation;


import javax.validation.constraints.*;

public class Customer {
    @NotNull(message = "is required")
    @Size(min = 1, message = "should be at least 1 character")
    private String firstName;
    @NotNull(message = "is required")
    @Size(min = 1, message = "should be at least 1 character")
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater than or equal to zero")
    @Max(value = 10, message = "must be less than or equal to 10")
    private Integer freePasses;

    @Pattern(regexp ="^[a-zA-Z0-9]{5}" , message = "only 5 characters/digits")
    private String postalCode;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }
}
