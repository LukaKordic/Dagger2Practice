package com.lukakordic.dagger2example.data.models;

import io.realm.RealmObject;

public class User extends RealmObject {

    private long id;
    private String name;
    private String address;
    private String createdAt;
    private String updatedAt;

    public User() {
    }

    public User(String name, String address) {

        this.name = name;
        this.address = address;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
