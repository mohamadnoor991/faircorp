package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/Building")
@Transactional
public class BuildingController {

//    /api/buildings (GET) send building list
///api/buildings (POST) add a building
///api/buildings/{building_id} (GET) read a building
///api/buildings/{building_id} (DELETE) delete a building and all its rooms and all its windows and heaters

private final BuildingDao buildingDao;


    public BuildingController(BuildingDao buildingDao) {
        this.buildingDao = buildingDao;
    }

    @GetMapping
    public List<BuildingDto> findAll() {
        return buildingDao.findAll().stream().map(BuildingDto::new).collect(Collectors.toList());  // (6)
    }
    @GetMapping(path = "/{id}")
    public BuildingDto findById(@PathVariable Long id) {
        return buildingDao.findById(id).map(BuildingDto::new).orElse(null); // (7)
    }

    //add heater
    @PostMapping
    public BuildingDto create(@RequestBody BuildingDto bu) {

        Building building = null;
        // On creation id is not defined
        if (bu.getId() == null) {
            building = buildingDao.save(new Building( bu.getId(), bu.getName()));
        }
        else {
            building = buildingDao.getOne(bu.getId());

        }
        return new BuildingDto(building);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        buildingDao.deleteById(id);
    }
}
