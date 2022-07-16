package com.stajproject.staj.controller;

import com.stajproject.staj.model.State;
import com.stajproject.staj.service.StateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/state")
public class StateController {
    private final StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<State>> getAllState(){
        List<State> states = stateService.findAllState();
        return new ResponseEntity<>(states, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<State> getStateById(@PathVariable("id") Long id) throws Throwable {
        State state = stateService.findStateById(id);
        return new ResponseEntity<>(state, HttpStatus.OK);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<State> addState(@RequestBody State state){
        State newState = stateService.addState(state);
        return new ResponseEntity<>(newState, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<State> updateState(@RequestBody State state){
        State updateState = stateService.updateState(state);
        return new ResponseEntity<>(updateState, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<?> deleteState(@PathVariable("id") Long id){
        stateService.deleteState(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
