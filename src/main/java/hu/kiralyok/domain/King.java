package hu.kiralyok.domain;

import javax.persistence.*;

@Entity
public class King {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int birthdate;
    private int death;
    @ManyToOne
    private Kingdom kingdom;

    public King() {
    }

    @Override
    public String toString() {
        return "Kings{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthdate +
                ", death=" + death +
                ", country=" + kingdom +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Kingdom getKingdom() {
        return kingdom;
    }

    public void setKingdom(Kingdom kingdom) {
        this.kingdom = kingdom;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(int birthdate) {
        this.birthdate = birthdate;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public Kingdom getCountry() {
        return kingdom;
    }

    public void setCountry(Kingdom kingdom) {
        this.kingdom = kingdom;
    }

    public void setId(long id) {
    }
}
