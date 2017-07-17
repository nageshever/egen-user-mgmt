package com.egen.egenusermgmt.entity;

import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.UUID;


/**
 * Created by lakinep on 7/16/17.
 */
@Entity
@Table(name = "USER")
public class User implements Serializable{

    public UUID getId() {
        return id;
    }

    @Id
    @GeneratedValue (generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id = UUID.randomUUID(); //primary key, UUID

    @NotNull (message = "First Name Cannot be Null")
    @Pattern (regexp = "^[A-Za-z]+$", message = "Only Alphabet is allowed Firstname")
    private String firstName;

    @Pattern (regexp = "^[A-Za-z]+$", message = "Only Alphabet is allowed Lastname")
    private String middleName; //optional

    @NotNull
    @Pattern (regexp = "^[A-Za-z]+$", message = "Only Alphabet is allowed Lastname")
    private String lastName;

    @NotNull
    @DecimalMin(value = "1", message = "Age must be greater than or equal to 1")
    private short age;

    @NotNull
    @Pattern(regexp = "[MF]")
    private String gender;

    @NotNull
    //@Digits(integer = 10, fraction = 0)
    @Pattern(regexp = "^[1-9][0-9]{9}", message = "Phone number must be a 10 digit number and start with non-zero")
    private String phone;

    @Pattern(regexp = "^[0-9]{5}", message = "Zip must be a 5 digit number")
    private String zip; //optional

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public User(String firstName, String middleName, String lastName, short age, String gender, String phone, String zip) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.zip = zip;
    }

    public User() {
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", phone=" + phone +
                ", zip=" + zip +
                '}';
    }
    public User(String firstName, String lastName, short age, String gender, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }
}
