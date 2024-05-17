package com.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Service
@FeignClient(name = "SensorsApplication", url = "http://server-docker:8080")
public interface ClientService {
    //String hello();
    
  @GetMapping("/api/temperature/ciao")
    public ResponseEntity<String>hellos();

  @GetMapping("/api/temperature/{idsensore}")
    public List<Temperature> getTemperatureById(Long idsensore);

  @GetMapping("/api/temperature/all")
    public List<Temperature> getAllTemperatures();

  @PostMapping("/api/temperature/add")
     public ResponseEntity<Temperature> createTemperature(Temperature t);

  @PutMapping("/api/temperature/update")
     public Temperature updateTemperature(Temperature t);

  

}
