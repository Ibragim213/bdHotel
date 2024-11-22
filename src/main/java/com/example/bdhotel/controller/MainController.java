package com.example.bdhotel.controller;

import com.example.bdhotel.dal.DataAccessLayer;
import com.example.bdhotel.models.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/unautorized")
@Slf4j
public class MainController {
        private final DataAccessLayer dataAccessLayer;
        @Autowired
        public MainController(DataAccessLayer dataAccessLayer){
            this.dataAccessLayer = dataAccessLayer;
        }

// пост
    @PostMapping("/create/employee")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        dataAccessLayer.createEmploy(employee);
        return ResponseEntity.ok("Employee created");
    }
    @PostMapping("/create/client")
    public ResponseEntity<String> createClient(@RequestBody Client client){
            dataAccessLayer.createClient(client);
return ResponseEntity.ok("Client created");
    }
    @PostMapping("/create/rooms")
    public ResponseEntity<String> createRooms(@RequestBody Rooms rooms){
        dataAccessLayer.createRooms(rooms);
        return ResponseEntity.ok("Rooms created");
    }
    @PostMapping("/create/roomServise")
    public ResponseEntity<String> createRoomsServise(@RequestBody RoomsServise roomsServise){
        dataAccessLayer.createRoomsServise(roomsServise);
        return ResponseEntity.ok("room servise created");
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

    //delete
    @DeleteMapping("/delete/client/{id}")
    public ResponseEntity<String> deleteClientById(@PathVariable("id") long id) {
        dataAccessLayer.deleteClientById(id);
        return ResponseEntity.ok("Client deleted");
    }
    @DeleteMapping("/delete/booking/{id}")
    public ResponseEntity<String> deleteBookingById(@PathVariable("id") long id) {
        dataAccessLayer.deleteBookingById(id);
        return ResponseEntity.ok("booking deleted");
    }
    @DeleteMapping("/delete/employee/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") long id) {
        dataAccessLayer.deleteEmployeeById(id);
        return ResponseEntity.ok("Employee deleted");
    }
    @DeleteMapping("/delete/rooms/{id}")
    public ResponseEntity<String> deleteRoomsById(@PathVariable("id") long id) {
        dataAccessLayer.deleteRoomsById(id);
        return ResponseEntity.ok("rooms deleted");
    }
    @DeleteMapping("/delete/roomsType/{id}")
    public ResponseEntity<String> deleteRoomsTypeById(@PathVariable("id") long id) {
        dataAccessLayer.deleteRoomsTypeById(id);
        return ResponseEntity.ok("Client deleted");
    }
    @DeleteMapping("/delete/roomServise/{id}")
    public ResponseEntity<String> deleteRoomServiseById(@PathVariable("id") long id) {
        dataAccessLayer.deleteRoomServise(id);
        return ResponseEntity.ok("Client deleted");
    }
    @DeleteMapping("/delete/servise/{id}")
    public ResponseEntity<String> deleteServiseById(@PathVariable("id") long id) {
        dataAccessLayer.deleteServiseById(id);
        return ResponseEntity.ok("Client deleted");
    }

    //get
    @GetMapping("/get/client/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") long id){
        Client client = dataAccessLayer.getClientById(id);
        if (client == null) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(client);
        }
    }
    @GetMapping("/get/booking/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable("id") long id){
        Booking booking = dataAccessLayer.getBookingById(id);
        if (booking == null) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(booking);
        }
    }
    @GetMapping("/get/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id){
        Employee employee = dataAccessLayer.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(employee);
        }
    }
    @GetMapping("/get/rooms/{id}")
    public ResponseEntity<Rooms> getRoomsById(@PathVariable("id") long id){
        Rooms rooms = dataAccessLayer.getRoomsById(id);
        if (rooms == null) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(rooms);
        }
    }
    @GetMapping("/get/roomsServise/{id}")
    public ResponseEntity<RoomsServise> getRoomsServiseById(@PathVariable("id") long id){
        RoomsServise roomsServise = dataAccessLayer.getRoomsServiseById(id);
        if (roomsServise == null) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(roomsServise);
        }
    }
    @GetMapping("/get/roomsType/{id}")
    public ResponseEntity<RoomsType> getRoomsTypeById(@PathVariable("id") long id){
        RoomsType roomsType = dataAccessLayer.getRoomsTypeById(id);
        if (roomsType == null) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(roomsType);
        }
    }
    @GetMapping("/get/servise/{id}")
    public ResponseEntity<Servise> getServiseById(@PathVariable("id") long id){
        Servise servise = dataAccessLayer.getServiseById(id);
        if (servise == null) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(servise);
        }
    }
}
