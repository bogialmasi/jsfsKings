package hu.kiralyok.domain;

import javax.persistence.*;

@Entity
public class King {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private int birthDate;
    private int death;
    @ManyToOne
    private Kingdom kingdom;

    public King() {
    }

    @Override
    public String toString() {
        return "Kings{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", death=" + death +
                ", country=" + kingdom +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
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
