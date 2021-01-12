package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RoomDto {
    private String roomName;
    private Long roomId;
    private Double current_temperature;
    private  Double target_temperature;
    private  int floor;
    private List<WindowDto> windows;
    private List<HeaterDto> heaters;
    private Long buildingId;


    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.roomName = room.getName();
        this.roomId = room.getId();
        this.current_temperature = room.getCurrent_temperature();
        this.target_temperature = room.getTarget_temperature();
        this.floor = room.getFloor();
        this.buildingId=room.getBuilding().getId();
        this.windows = room.getWindowR().stream().map(WindowDto::new).collect(Collectors.toList());
        this.heaters = room.getHeaterR().stream().map(HeaterDto::new).collect(Collectors.toList());;

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


    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public Double getCurrent_temperature() {
        return current_temperature;
    }

    public void setCurrent_temperature(Double current_temperature) {
        this.current_temperature = current_temperature;
    }

    public List<WindowDto> getWindows() {
        return windows;
    }

    public void setWindows(List<WindowDto> windows) {
        this.windows = windows;
    }

    public List<HeaterDto> getHeaters() {
        return heaters;
    }

    public void setHeaters(List<HeaterDto> heaters) {
        this.heaters = heaters;
    }
}
