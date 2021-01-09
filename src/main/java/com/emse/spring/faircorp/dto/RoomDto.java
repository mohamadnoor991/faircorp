package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;

import java.util.List;

public class RoomDto {
    private String roomName;
    private Long roomId;
    private Double current_temperature;
    private  Double target_temperature;
    private  int floor;
    private List<Heater> heaterset;
    private  List <Window> windows;

    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.roomName = room.getName();
        this.roomId = room.getId();
        this.current_temperature = room.getCurrent_temperature();
        this.target_temperature = room.getTarget_temperature();
        this.floor = room.getFloor();
        this.heaterset= (List<Heater>) room.getHeaterR();/// ? check for that
        this.windows= (List<Window>) room.getWindowR();///?check for that

    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Double getCurrentTemperature() {
        return current_temperature;
    }

    public void setCurrentTemperature(Double currentTemperature) {
        this.current_temperature = currentTemperature;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Double getTarget_temperature() {
        return target_temperature;
    }

    public void setTarget_temperature(Double target_temperature) {
        this.target_temperature = target_temperature;
    }

    public List<Heater> getHeaterset() {
        return heaterset;
    }

    public void setHeaterset(List<Heater> heaterset) {
        this.heaterset = heaterset;
    }

    public List<Window> getWindows() {
        return windows;
    }

    public void setWindows(List<Window> windows) {
        this.windows = windows;
    }
}
