package hu.kiralyok.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Kingdom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private int area;
    private int population;
    @OneToMany(mappedBy = "kingdom")
    @JsonIgnore
    private List<King> kings;

    public Kingdom(){
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKings(List<King> kings) {
        this.kings = kings;
    }

    @Override
    public String toString() {
        return "Kingdom{" +
                "area=" + area +
                ", population=" + population +
                '}';
    }

    public List<King> getKings() {
        return kings;
    }

    public String getName() {
        return name;
    }
}
