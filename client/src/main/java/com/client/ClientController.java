package com.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.scheduling.annotation.Scheduled;


@RestController

@RequestMapping("/client")
@EnableAsync

public class ClientController {

    @Autowired
    private ClientService clientservice;

   @GetMapping("/ciao")
        public ResponseEntity<String>hello() {
            System.out.println("Printing hello after fixed delay: " + System.currentTimeMillis() / 1000);
            return new ResponseEntity<String>("Ciao dal client",HttpStatus.OK);


        } 
    //@Async
    //@Scheduled(fixedRate = 5000)
    @GetMapping("feign/servermessage")
        public void hellos() {
                System.out.println(clientservice.hellos());
        }
    @GetMapping("feign/temperature/{idsensore}")
      public ResponseEntity<List<Temperature>> getTemperatureById(@PathVariable("idsensore") Long idsensore) {
        List<Temperature> t=clientservice.getTemperatureById(idsensore);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }
    @GetMapping("feign/temperature/all")
    public ResponseEntity<List<Temperature>> getAllTemperatures() {
         List<Temperature> t=clientservice.getAllTemperatures();
         return new ResponseEntity<>(t, HttpStatus.OK);
    }
    @PostMapping("feign/temperature/add")
    public ResponseEntity<Temperature> addTemperature(Temperature t) {
        Random r=new Random();
        Timestamp ts=new Timestamp(System.currentTimeMillis());
        float min=15;
        float max=30;
        float mis=r.nextFloat()*(max-min)+min;
        t.setIdsensore(1);
        t.setMisura(mis);
        t.setStanza("cucina");
        t.setTimestamp(ts);
        ResponseEntity<Temperature> savedT=clientservice.createTemperature(t);
        return savedT;
    }
    @Async
    @Scheduled(fixedRate = 5000)
    @PutMapping("feign/temperature/update/")
   
    public void updateTemperature() {
   

        Random r=new Random();
        Temperature t =new Temperature();

        Timestamp ts=new Timestamp(System.currentTimeMillis());
        float min=15;
        float max=30;
        float mis=r.nextFloat()*(max-min)+min;
        t.setIdsensore(1);
        t.setMisura(mis);
        t.setStanza("cucina");
        t.setTimestamp(ts);
        clientservice.updateTemperature(t);
        System.out.println("Temperatura inviata:"+t.getMisura()+ "-idsensore:"+t.getIdsensore()+"-stanza:"+t.getStanza());
      
    }
    
    
   
    
    
}
