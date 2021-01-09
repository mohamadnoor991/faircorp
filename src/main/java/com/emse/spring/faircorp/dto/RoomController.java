package com.emse.spring.faircorp.dto;


import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/Room")
@Transactional
public class RoomController {

///api/rooms (GET) send room list
///api/rooms (POST) add a room
///api/rooms/{room_id} (GET) read a room
///api/rooms/{room_id} (DELETE) delete a room and all its windows and its heaters
///api/rooms/{room_id}/switchWindow switch the room windows (OPEN to CLOSED or inverse)
///api/rooms/{room_id}/switchHeaters switch the room heaters (ON to OFF or inverse)


    private final RoomDao roomDao;
    private final HeaterDao heaterDaO;
    private final WindowDao windowDao;


    public RoomController(RoomDao roomDao, HeaterDao heaterDaO, WindowDao windowDao) {
        this.roomDao = roomDao;
        this.heaterDaO = heaterDaO;
        this.windowDao = windowDao;
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
@PostMapping
public RoomDto create(@RequestBody RoomDto rmto) {
        Window window= (Window) rmto.getWindows();//M8-1-2021
    Heater heater= (Heater) rmto.getHeaterset();
    Room room = null;
    // On creation id is not defined
    if (rmto.getRoomId() == null) {
        room = roomDao.save(new Room( rmto.getRoomName(), rmto.getFloor()));
    }
    else {
        room = roomDao.getOne(rmto.getRoomId());
        room = roomDao.getOne((long) rmto.getFloor());
    }
    return new RoomDto(room);
}

//switch
@PutMapping(path = "/{roomId}/switchWindow")
public RoomDto switchStatusW(@PathVariable Long id) {
    Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);

    Window window = windowDao.findById(id).orElseThrow(IllegalArgumentException::new);
    window.setWindow_status(window.getWindow_status() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN);
    return new RoomDto(room);
}

//    @PutMapping(path = "/{roomId}/switchHeater")
//    public RoomDto switchStatusH(@PathVariable Long id) {
//        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);
//
//        Heater heater = heaterDao.findById(id).orElseThrow(IllegalArgumentException::new);
//        heater.setHeaterStatus(heater.getWindow_status() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN);
//        return new RoomDto(room);
//    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        roomDao.deleteById(id);
    }
}
