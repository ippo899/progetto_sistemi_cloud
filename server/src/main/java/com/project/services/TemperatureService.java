package com.project.services;

import com.project.entity.Temperature;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public interface TemperatureService {
    Temperature createTemperature(Temperature t);

    String messaggio();
    List<Temperature> getTemperatureById(Long idsensore);
    List<Temperature> getAllTemperatures();
    Temperature updateTemperature(Temperature t);
    void deleteTemperature(Long id);
    float findAvgByIdsensore(Long idsensore);
    List<Temperature>getTemperatureByDate(Long idsensore,Timestamp startTime,Timestamp endTime);
     
}
