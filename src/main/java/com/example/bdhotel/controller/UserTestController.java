package com.example.bdhotel.controller;


import com.example.bdhotel.dal.DataAccessLayer;
import com.example.bdhotel.models.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
@RestController
@RequestMapping("/secured")
public class UserTestController {

    private final DataAccessLayer dataAccessLayer;

    public UserTestController(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }

    @GetMapping("/user")
    public String userAccess(Principal principal) {
        if (principal != null) {
            return principal.getName();
        }
        return null;
    }

    @PostMapping("/create/employee")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        dataAccessLayer.createEmploy(employee);
        return ResponseEntity.ok("Employee created");
    }
    @PostMapping("/create/client")
    public ResponseEntity<String> createClient(@RequestBody Client client) {
        dataAccessLayer.createClient(client);
        return ResponseEntity.ok("Client created");
    }




    @PostMapping("/create/rooms")
    public ResponseEntity<String> createRooms(@RequestBody Rooms rooms){
        dataAccessLayer.createRooms(rooms);
        return ResponseEntity.ok("Rooms created");
    }

    @PostMapping("/create/booking")
    public ResponseEntity<String> createBooking(@RequestBody Booking booking){
        dataAccessLayer.createBooking(booking);
        return ResponseEntity.ok("booking created");
    }
    @PostMapping("/create/roomsType")
    public ResponseEntity<String> createRomsType(@RequestBody RoomsType roomsType ){
        dataAccessLayer.createRoomsType(roomsType);
        return ResponseEntity.ok("rooms type created");
    }
    @PostMapping("/create/servise")
    public ResponseEntity<String> createServise(@RequestBody Servise servise ){
        dataAccessLayer.createServise(servise);
        return ResponseEntity.ok("servise type created");
    }
}