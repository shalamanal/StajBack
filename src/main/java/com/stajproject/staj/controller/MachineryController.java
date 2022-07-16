package com.stajproject.staj.controller;

import com.stajproject.staj.model.Machinery;
import com.stajproject.staj.service.MachineryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/machinery")
public class MachineryController {
    private final MachineryService machineryService;

    public MachineryController(MachineryService machineryService) {
        this.machineryService = machineryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Machinery>> getAllMachinery(){
        List<Machinery> machinery = machineryService.findAllMachinery();
        return new ResponseEntity<>(machinery, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Machinery> getMachineryById(@PathVariable("id") Long id) throws Throwable {
        Machinery machinery = machineryService.findMachineryById(id);
        return new ResponseEntity<>(machinery, HttpStatus.OK);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<Machinery> addMachinery(@RequestBody Machinery machinery){
        Machinery newMachinery = machineryService.addMachinery(machinery);
        return new ResponseEntity<>(newMachinery, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<Machinery> updateMachinery(@RequestBody Machinery machinery){
        Machinery updateMachinery = machineryService.updateMachinery(machinery);
        return new ResponseEntity<>(updateMachinery, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<?> deleteMachinery(@PathVariable("id") Long id){
        machineryService.deleteMachinery(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
