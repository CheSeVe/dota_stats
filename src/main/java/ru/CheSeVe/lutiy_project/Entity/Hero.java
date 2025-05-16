package ru.CheSeVe.lutiy_project.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "heroes")
public class Hero {
    private String heroName;

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }
    public String getHeroName() {
        return heroName;
    }
}
