package com.bdogg.herotracker.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Sighting {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String description;

    @Column
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
