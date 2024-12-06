package com.example.bdhotel.controller;

import com.example.bdhotel.dal.DataAccessLayer;
import com.example.bdhotel.models.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/unauthorized")
@Slf4j
public class MainController {

    private final DataAccessLayer dataAccessLayer;

    @Autowired
    public MainController(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }



      @GetMapping("/hello")
      public String hello(){
            return "hello";
        }
// пост


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
    //patch

    @PatchMapping("/patch/client/{id}")
    public ResponseEntity<Client> patchClientById(@PathVariable("id") long id, @RequestBody Client client){
        Client updatedClient = dataAccessLayer.patchClientById(id, client);
        if (client == null) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(client);
        }
    }
    @PatchMapping("/patch/booking/{id}")
    public ResponseEntity<Booking> patchBookingById(@PathVariable("id") long id, @RequestBody Booking booking){
        Booking updatedBooking = dataAccessLayer.patchBookingById(id, booking);
        if (booking == null) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(booking);
        }
    }
    @PatchMapping("/patch/employee/{id}")
    public ResponseEntity<Employee> patchEmployeeById(@PathVariable("id") long id, @RequestBody Employee employee){
        Employee updatedEmployee = dataAccessLayer.patchEmployeeById(id, employee);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(employee);
        }
    }
    @PatchMapping("/patch/rooms/{id}")
    public ResponseEntity<Rooms> patchRoomsById(@PathVariable("id") long id, @RequestBody Rooms rooms){
        Rooms updatedRooms = dataAccessLayer.patchRoomsById(id, rooms);
        if (rooms == null) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(rooms);
        }
    }

    @PatchMapping("/patch/roomsType/{id}")
    public ResponseEntity<RoomsType> patchRoomsTypeById(@PathVariable("id") long id, @RequestBody RoomsType roomsType){
        RoomsType updatedRoomsType = dataAccessLayer.patchRoomsTypeById(id, roomsType);
        if (roomsType == null) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(roomsType);
        }
    }
    @PatchMapping("/patch/servise/{id}")
    public ResponseEntity<Servise> patchServiseById(@PathVariable("id") long id, @RequestBody Servise servise){
        Servise updatedServise = dataAccessLayer.patchServiseTypeById(id, servise);
        if (servise == null) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(servise);
        }
    }



    }

