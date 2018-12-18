package com.myapp.model;

import java.util.Date;
import java.util.Objects;

public class User extends BaseEntity{
    private String name;
    private String email;
    private String password;
    private int roleId;
    private String address;
    private String phone;
    private Date birthday;

    public User() {
    }

    public User(String name, String email, String password, int roleId, String address, String phone, Date birthday) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.address = address;
        this.phone = phone;
        this.birthday = birthday;
    }

    public User(int id, String name, String email, String password, int roleId, String address, String phone, Date birthday) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                getRoleId() == user.getRoleId() &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getAddress(), user.getAddress()) &&
                Objects.equals(getPhone(), user.getPhone()) &&
                Objects.equals(getBirthday(), user.getBirthday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getName(), getEmail(), getPassword(), getRoleId(), getAddress(), getPhone(), getBirthday());
    }
}
