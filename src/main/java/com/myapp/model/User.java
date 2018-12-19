package com.myapp.model;

import com.myapp.customAnnotation.EqualFields;
import com.myapp.customAnnotation.PasswordConstraint;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.Objects;

@EqualFields(baseField = "password", matchField = "confirmedPassword", message = "Password doesn't match")
public class User extends BaseEntity {
    @NotBlank(message = "Please, enter your name")
    private String name;

    @Email(message = "Enter correct email")
    private String email;

    @PasswordConstraint
    private String password;
    private String confirmedPassword;
    private Role role;
    private String address;
    private String phone;
    private Date birthday;

    public User() {
    }

    public User(String name, String email, String password, Role role, String address, String phone, Date birthday) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.address = address;
        this.phone = phone;
        this.birthday = birthday;
    }

    public User(int id, String name, String email, String password, Role role, String address, String phone, Date birthday) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.address = address;
        this.phone = phone;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getRole(), user.getRole()) &&
                (Objects.equals(getAddress(), user.getAddress()) || (getAddress() == null && user.getAddress() == null)) &&
                (Objects.equals(getPhone(), user.getPhone()) || (getAddress() == null && user.getAddress() == null)) &&
                (Objects.equals(getBirthday(), user.getBirthday()) || (getAddress() == null && user.getAddress() == null));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), getEmail(), getPassword(), getConfirmedPassword(), getRole(), getAddress(), getPhone(), getBirthday());
    }
}
