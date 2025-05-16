package ru.CheSeVe.lutiy_project.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    // и в юзере информация о матчах, в которых он участвовал
    private int id;
    private String userName;
    private String password;
    private short mmr;
    private long steamId;
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setMmr(short mmr) {
        this.mmr = mmr;
    }

    public short getMmr() {
        return mmr;
    }
    public void setSteamId(long steamId) {
        this.steamId = steamId;
    }

    public long getSteamId() {
        return steamId;
    }
}
