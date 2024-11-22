package com.example.bdhotel.controller;

import com.example.bdhotel.dal.DataAccessLayer;
import com.example.bdhotel.models.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/unautorized")
@Slf4j
public class MainController {
        private final DataAccessLayer dataAccessLayer;

        public MainController(DataAccessLayer dataAccessLayer){
            this.dataAccessLayer = dataAccessLayer;
        }


    @PostMapping("/create/employee")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        dataAccessLayer.createClient(employee);
        return ResponseEntity.ok("Employee created");
    }
}
