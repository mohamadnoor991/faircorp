package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "ROOM")
public class Room {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer floor;

    @Column(nullable = false)
    private String name;

    @Column
    private  Double current_temperature ;
    @Column
    private Double target_temperature ;

    @OneToMany(mappedBy="room",cascade = CascadeType.REMOVE)
   private List<Heater> heaterR;

    @OneToMany(mappedBy="room",cascade = CascadeType.REMOVE)
    private List<Window> windowR;

    @ManyToOne(optional = false)
    private Building building;
//    @ManyToOne(optional = false)
//    private Heater heater;


public Room(){}

public Room(String name,int floor, Building building){
    this.name = name;
    this.floor = floor;
    this.building=building;
//    this.heater=heater;

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

    public List<Heater> getHeaterR() {
        return heaterR;
    }

    public List<Window> getWindowR() {
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

    public void setHeaterR(List<Heater> heaterR) {
        this.heaterR = heaterR;
    }

    public void setWindowR(List<Window> windowR) {
        this.windowR = windowR;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }
}
