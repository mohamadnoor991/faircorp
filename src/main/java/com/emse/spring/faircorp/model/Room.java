package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Room {
    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false)
    int floor;

    @Column(nullable = false)
    String name;

    Double current_temperature ;
   Double target_temperature ;

    @OneToMany(mappedBy="room")
   private Set<Heater> heaterR;

    @OneToMany(mappedBy="room")
    private Set<Window> windowR;




public Room(){}

public Room(String name,int floor){
    this.name = name;
    this.floor = floor;


}

    public Long getId() {
        return id;
    }

    public int getFloor() {
        return floor;
    }

    public String getName() {
        return name;
    }

    public Double getCurrent_temperature() {
        return current_temperature;
    }

    public Double getTarget_temperature() {
        return target_temperature;
    }

    public Set<Heater> getHeaterR() {
        return heaterR;
    }

    public Set<Window> getWindowR() {
        return windowR;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrent_temperature(Double current_temperature) {
        this.current_temperature = current_temperature;
    }

    public void setTarget_temperature(Double target_temperature) {
        this.target_temperature = target_temperature;
    }

    public void setHeaterR(Set<Heater> heaterR) {
        this.heaterR = heaterR;
    }

    public void setWindowR(Set<Window> windowR) {
        this.windowR = windowR;
    }
}
