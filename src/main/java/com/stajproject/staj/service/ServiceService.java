package com.stajproject.staj.service;

import com.stajproject.staj.exeption.NotFoundException;
import com.stajproject.staj.model.Service;
import com.stajproject.staj.repo.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
@org.springframework.stereotype.Service
public class ServiceService {
    private final ServiceRepo serviceRepo;
    @Autowired
    public ServiceService(ServiceRepo serviceRepo) {
        this.serviceRepo = serviceRepo;
    }
    public List<Service> findAllService(){
        return serviceRepo.findAll();
    }

    public Service updateService(Service service){
        return serviceRepo.save(service);
    }

    public Service findServiceById(Long id) throws Throwable {
        return serviceRepo.findServiceById(id)
                .orElseThrow(() -> new NotFoundException("Service by id " + id + " not found"));
    }
    @Transactional
    public void deleteService(Long id){
        serviceRepo.deleteServiceById(id);
    }
    @Transactional
    public Service addService(Service service){ return serviceRepo.saveAndFlush(service);}
}
