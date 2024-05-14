package com.project.services;

import lombok.AllArgsConstructor;
import com.project.entity.Temperature;
import com.project.repository.TemperatureRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor

public class TemperatureServiceImpl implements TemperatureService {
   
    public TemperatureRepository temperatureRepository;
    @Override
     public Temperature createTemperature(Temperature t) { 
        LocalDateTime current_date_time = LocalDateTime.now();
        t.setTimestamp(t.getTimestamp().valueOf(current_date_time));
 
        return temperatureRepository.save(t);
    }
      @Override
     public String messaggio() { 
  
        return "ok dal server";
    }

    @Override
    public List<Temperature> getTemperatureById(Long idsensore) {
        return temperatureRepository.getTemperatureById(idsensore);
    
    }

    @Override
    public List<Temperature> getAllTemperatures() {
      
        return temperatureRepository.findAll();
    }

    @Override
    public Temperature updateTemperature(Temperature t) {
      
       
        Temperature exTemperature=t;
        exTemperature.setIdsensore(t.getIdsensore());
        exTemperature.setStanza(t.getStanza());
        exTemperature.setMisura(t.getMisura());
        exTemperature.setTimestamp(t.getTimestamp());
        temperatureRepository.save(exTemperature);
        return exTemperature;  

   
    }

    @Override
    public void deleteTemperature(Long id) {
    
          temperatureRepository.deleteById(id);
    }

    @Override
    public float findAvgByIdsensore(Long idsensore){
        return temperatureRepository.findAvgByIdsensore(idsensore);
    }
   @Override
   public List<Temperature>getTemperatureByDate(Long idsensore,Timestamp startTime,Timestamp endTime){
    return temperatureRepository.getTemperatureByDate(idsensore, startTime, endTime);
   }
  

    
    
}
