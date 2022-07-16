package com.stajproject.staj.service;

import com.stajproject.staj.exeption.NotFoundException;
import com.stajproject.staj.model.State;
import com.stajproject.staj.repo.StateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class StateService {
    private final StateRepo stateRepo;
    @Autowired
    public StateService(StateRepo stateRepo) {
        this.stateRepo = stateRepo;
    }
    public List<State> findAllState(){
        return stateRepo.findAll();
    }

    public State updateState(State state){
        return stateRepo.save(state);
    }

    public State findStateById(Long id) throws Throwable {
        return stateRepo.findStateById(id)
                .orElseThrow(() -> new NotFoundException("State by id " + id + " not found"));
    }
    @Transactional
    public void deleteState(Long id){
        stateRepo.deleteStateById(id);
    }

    @Transactional
    public State addState(State state) {
        return stateRepo.saveAndFlush(state);
    }
}
