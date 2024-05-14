package com.project.controller;
import lombok.AllArgsConstructor;
import com.project.entity.Temperature;
import com.project.services.TemperatureService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.sql.Timestamp;




@RestController
@AllArgsConstructor
@RequestMapping("/api/temperature")


public class TemperatureController {
    @Autowired
    private TemperatureService temperatureService;

    


    @GetMapping("/ciao")
    public ResponseEntity<String> hellos(){
        String m=temperatureService.messaggio();
        return new ResponseEntity<String>(m,HttpStatus.OK);
    }
    
    @PostMapping("/add")
      public ResponseEntity<Temperature>createTemperature(@RequestBody Temperature t){
        Temperature savedT=temperatureService.createTemperature(t);
        return new ResponseEntity<>(savedT,HttpStatus.CREATED);
        }


    


  
  
  // build get temperature by id REST API
    // http://localhost:8080/api/temperature/1
    @GetMapping("{idsensore}")
    public ResponseEntity<List<Temperature>> getTemperatureById(@PathVariable("idsensore") Long idsensore){
        List<Temperature> t = temperatureService.getTemperatureById(idsensore);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }
     // Build Get All UREST API
    // http://localhost:8080/api/temperature/all
    @GetMapping("/all")
    public ResponseEntity<List<Temperature>> getAllTemperatures(){
        List<Temperature> ts = temperatureService.getAllTemperatures();
        return new ResponseEntity<>(ts, HttpStatus.OK);
    }
     @PutMapping("/update")
    // http://localhost:8080/api/temperature/update
    public Temperature updateTemperature(@RequestBody Temperature t){
        Temperature updatedT = temperatureService.updateTemperature(t);
        return updatedT;
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTemperature(@PathVariable("id") Long id){
        temperatureService.deleteTemperature(id);
        return new ResponseEntity<>("Temperature successfully deleted!", HttpStatus.OK);
    }
    @GetMapping("/test")
    public String testMethod(){return "sto lavorando";}
    
    @GetMapping("/media/{idsensore}")
    public float findAvgByIdsensore(@PathVariable("idsensore")Long idsensore){
    return temperatureService.findAvgByIdsensore(idsensore);
    }
    @GetMapping("/data")
    public ResponseEntity <List<Temperature>> getTemperatureByDate(
                                                     @RequestParam("idsensore") Long idsensore,
                                                     @RequestParam("startTime") Timestamp startTime,
                                                     @RequestParam("endTime") Timestamp endTime) {
        List<Temperature> t = temperatureService.getTemperatureByDate(idsensore,startTime,endTime);  

        return new ResponseEntity<>(t, HttpStatus.OK);
    }
}



