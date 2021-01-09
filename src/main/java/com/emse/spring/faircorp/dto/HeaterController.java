package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/Heater")
@Transactional
public class HeaterController {

//    /api/heaters (GET) send heaters list
///api/heaters (POST) add a heater
///api/heaters/{heater_id} (GET) read a heater
///api/heaters/{heater_id} (DELETE) delete a heater

    private final RoomDao roomDao;
    private final HeaterDao heaterDao;
    private final WindowDao windowDao;

    public HeaterController(RoomDao roomDao, HeaterDao heaterDaO, WindowDao windowDao) {
        this.roomDao = roomDao;
        this.heaterDao = heaterDaO;
        this.windowDao = windowDao;

    }
    @GetMapping
    public List<HeaterDto> findAll() {
        return heaterDao.findAll().stream().map(HeaterDto::new).collect(Collectors.toList());  // (6)
    }
    @GetMapping(path = "/{id}")
    public HeaterDto findById(@PathVariable Long id) {
        return heaterDao.findById(id).map(HeaterDto::new).orElse(null); // (7)
    }

    //add heater
    @PostMapping
    public HeaterDto create(@RequestBody HeaterDto dto) {
        // WindowDto must always contain the window room
        Room room = roomDao.getOne(dto.getRoom().getId());///////////////
        Heater heater = null;
        // On creation id is not defined
        if (dto.getId() == null) {
            heater = heaterDao.save(new Heater( dto.getId(), dto.getName(), dto.getPower(),room, dto.getHeaterStatus()));
        }
        else {
            heater = heaterDao.getOne(dto.getId());
            heater.setHeaterStatus(dto.getHeaterStatus());
        }
        return new HeaterDto(heater);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        heaterDao.deleteById(id);
    }

}
