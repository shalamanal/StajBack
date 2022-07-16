package com.stajproject.staj.service;

import com.stajproject.staj.exeption.NotFoundException;
import com.stajproject.staj.model.Machinery;
import com.stajproject.staj.repo.MachineryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class MachineryService {
    private final MachineryRepo machineryRepo;
    @Autowired
    public MachineryService(MachineryRepo machineryRepo) {
        this.machineryRepo = machineryRepo;
    }

    public List<Machinery> findAllMachinery(){
        return machineryRepo.findAll();
    }

    public Machinery updateMachinery(Machinery machinery){
        return machineryRepo.save(machinery);
    }

    public Machinery findMachineryById(Long id) throws Throwable {
        return machineryRepo.findMachineryById(id)
                .orElseThrow(() -> new NotFoundException("Machinery by id " + id + " not found"));
    }
    @Transactional
    public void deleteMachinery(Long id){
        machineryRepo.deleteMachineryById(id);
    }

    @Transactional
    public Machinery addMachinery(Machinery machinery){return machineryRepo.saveAndFlush(machinery);}
}
