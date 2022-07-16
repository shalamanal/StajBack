package com.stajproject.staj.controller;

import com.stajproject.staj.model.Service;
import com.stajproject.staj.service.ServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/service")
public class ServiceController {
    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Service>> getAllServices(){
        List<Service> services = serviceService.findAllService();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable("id") Long id) throws Throwable {
        Service service = serviceService.findServiceById(id);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }
    @PostMapping("/add")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<Service> addService(@RequestBody Service service){
        Service addService = serviceService.addService(service);
        return new ResponseEntity<>(addService, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<Service> updateService(@RequestBody Service service){
        Service updateService = serviceService.updateService(service);
        return new ResponseEntity<>(updateService, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<?> deleteService(@PathVariable("id") Long id){
        serviceService.deleteService(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
