package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "BUILDING")
public class Building {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "building",cascade = CascadeType.REMOVE)
    private Set<Room> room;

    @OneToMany(mappedBy="building",cascade = CascadeType.REMOVE)
    private Set<Heater> heaterR;

    @OneToMany(mappedBy="building",cascade = CascadeType.REMOVE)
    private Set<Window> windowR;




    public Building() {
    }

    public Building(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Set<Room> getRoom() {
        return room;
    }

    public void setRoom(Set<Room> room) {
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Heater> getHeaterR() {
        return heaterR;
    }

    public void setHeaterR(Set<Heater> heaterR) {
        this.heaterR = heaterR;
    }

    public Set<Window> getWindowR() {
        return windowR;
    }

    public void setWindowR(Set<Window> windowR) {
        this.windowR = windowR;
    }
}
