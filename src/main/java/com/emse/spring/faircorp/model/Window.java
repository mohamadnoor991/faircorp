package com.emse.spring.faircorp.model;

import javax.persistence.*;

@Entity
@Table(name = "RWINDOW")
public class Window {
    // (1)
// (2)

    // (3)
    @Id
    @GeneratedValue

    private Long id;

    @Column(nullable = false)
    private String name;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private WindowStatus window_status;

    @ManyToOne(optional = false) //Notification to create window
    private Room room;


    public Window() {
    }

    public Window(String name, WindowStatus status, Room room) {
        this.window_status = status;
        this.name = name;
        this.room = room;
    }

    public Long getId() {
        return this.id;
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

    public WindowStatus getWindow_status() {
        return window_status;
    }

    public void setWindow_status(WindowStatus window_status) {
        this.window_status = window_status;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom_id(Room room_id) {
        this.room = room_id;
    }
}

