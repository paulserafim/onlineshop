package com.online.shop.onlineshop.model.user;

public interface User {
    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setEmail(String email);
    void setCounty(String county);
    void setCountry(String country);
    void setCity(String city);
    void setStreet(String street);
    void setHouseNumber(String houseNumber);
    void setEncryptedPass(String encryptedPass);
    void setAge(double age);
    void setId(Long id);
    String getFirstName();
    String getLastName();
    String getEmail();
    String getCounty();
    String getCountry();
    String getCity();
    String getStreet();
    String getHouseNumber();
    String getEncryptedPass();
    double getAge();
    Long getId();

}
