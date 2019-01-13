package com.bdogg.herotracker.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Hero {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "hero_power",
            joinColumns = @JoinColumn(name = "hero_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "power_id", referencedColumnName = "id")
    )
    private List<Power> powers = new ArrayList<>();

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Power> getPowers() {
        return powers;
    }

    public void setPowers(List<Power> powers) {
        this.powers = powers;
    }

    public void addPower(Power power) {
        this.powers.add(power);
    }
}
