package com.revature.rms.campus.controllers;

import com.revature.rms.campus.entities.Building;
import com.revature.rms.campus.entities.Room;
import com.revature.rms.campus.services.BuildingService;
import com.revature.rms.campus.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Room> getAllBuildings() { return roomService.findAll(); }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Room saveBuilding(@RequestBody Room room) {return roomService.save(room); }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Room getBuildingById(@PathVariable String id) { return roomService.findById(id).get(); }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Room update(@RequestBody Room room) { return roomService.update(room); }

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteBuildingById(@PathVariable String id) { roomService.delete(id);}
}
