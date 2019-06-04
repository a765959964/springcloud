package com.zf.model;

/**
 * @author: 张帆
 * @create: 2019-06-03 9:28
 * @Description:
 **/
public class User {


    private Integer id;

    private String name;

    private String address;

    public User(String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public User() {
        super();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
