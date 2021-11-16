package hu.kiralyok.domain;

public class Kingdom {
    private int area;
    private int population;

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

    @Override
    public String toString() {
        return "Kingdom{" +
                "area=" + area +
                ", population=" + population +
                '}';
    }
}
