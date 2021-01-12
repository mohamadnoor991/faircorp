package com.emse.spring.faircorp.dto;


//import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.model.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/Room")
@Transactional
public class RoomController {


    private final RoomDao roomDao;
private final HeaterDao heaterDao;
    private final WindowDao windowDao;
    private final BuildingDao buildingDao;


    public RoomController(RoomDao roomDao, HeaterDao heaterDao, WindowDao windowDao, BuildingDao buildingDao) {
        this.roomDao = roomDao;
        this.heaterDao = heaterDao;
        this.windowDao = windowDao;
        this.buildingDao = buildingDao;
    }

    @GetMapping
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());  // (6)
    }
    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long roomId) {
        return roomDao.findById(roomId).map(RoomDto::new).orElse(null); // (7)
    }
// for adding room

//    @PostMapping
//    public RoomDto create(@RequestBody RoomDto rmto) {
//        Building building=buildingDao.getOne(rmto.getBuildingId());
//        roomDao.save(new Room(rmto.getRoomName(),rmto.getFloor(),building));
//        return new RoomDto(roomDao.save(new Room(rmto.getRoomName(),rmto.getFloor(),building)));
//    }
@PostMapping
public RoomDto create(@RequestBody RoomDto rmto) {
//    Room room ;
    Building building = buildingDao.getOne(rmto.getBuildingId());
//    HeaterStatus heater=heaterDto.getHeaterStatus();
    roomDao.save(new Room(rmto.getRoomName(),rmto.getFloor(),building));
    return new RoomDto(roomDao.save(new Room(rmto.getRoomName(),rmto.getFloor(),building)));
            }

//switch
@PutMapping(path = "/{roomId}/switchWindow")
public RoomDto switchStatusW(@PathVariable Long id) {
    Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);

//    Window window = windowDao.findById(id).orElseThrow(IllegalArgumentException::new);
//    window.setWindow_status(window.getWindow_status() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN);
    for(Window window : room.getWindowR()) {
        window.setWindow_status(window.getWindow_status() == WindowStatus.OPEN ? WindowStatus.CLOSED : WindowStatus.OPEN);
    }

    return new RoomDto(room);
}

    @PutMapping(path = "/{roomId}/switchHeater")
    public RoomDto switchStatusH(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);

        Heater heater = heaterDao.findById(id).orElseThrow(IllegalArgumentException::new);
        heater.setHeaterStatus(heater.getHeaterStatus()  == HeaterStatus.ON ? HeaterStatus.OFF: HeaterStatus.ON);
        return new RoomDto(room);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        roomDao.deleteById(id);
    }
}
