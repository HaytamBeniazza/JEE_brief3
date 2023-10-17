package model;

import lombok.*;

import java.time.LocalDate;

@Data
public abstract class User {
    @NonNull
    protected String firstName;
    @NonNull
    protected String lastName;
    @NonNull
    protected LocalDate birthDay;
    @NonNull
    protected String phone;
    @NonNull
    protected String address;

    public User(){}

    public User(String firstName, String lastName, LocalDate birthDay, String phone, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.address = address;
    }


}
