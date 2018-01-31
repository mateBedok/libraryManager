package com.threelittlepigs.codecool.libraryManager.Entities.Users;

import com.threelittlepigs.codecool.libraryManager.Utils.EntityUtility;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance
@DiscriminatorColumn(name= "USER_TYPE")
@Table(name="Users")
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dateOfBirth;

    private String phoneNumber;

    public User(String userName, String password, String firstName, String lastName, String email, Date dateOfBirth, String address, String phoneNumber) {
        this.userName = userName;
        this.password = BCrypt.hashpw(password,BCrypt.gensalt());
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
        EntityUtility.mergeEntity(this);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        EntityUtility.mergeEntity(this);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        EntityUtility.mergeEntity(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        EntityUtility.mergeEntity(this);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        EntityUtility.mergeEntity(this);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        EntityUtility.mergeEntity(this);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        EntityUtility.mergeEntity(this);
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        EntityUtility.mergeEntity(this);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        EntityUtility.mergeEntity(this);
    }
}