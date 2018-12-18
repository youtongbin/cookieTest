package com.neuedu.pojo;

import java.util.Objects;

public class User {
    private int id;
    private String username;
    private String password;
    private String tele;

    public User() {
    }

    public User(String username, String password, String tele) {
        this.username = username;
        this.password = password;
        this.tele = tele;
    }

    public User(int id, String username, String password, String tele) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.tele = tele;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(tele, user.tele);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, tele);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tele='" + tele + '\'' +
                '}';
    }
}
