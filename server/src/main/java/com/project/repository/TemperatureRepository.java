package com.project.repository;

import com.project.entity.Temperature;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TemperatureRepository extends JpaRepository<Temperature,Long> {

    @Query(value="SELECT AVG(misura) FROM temperature WHERE idsensore= :idsensore",nativeQuery=true)
    float findAvgByIdsensore(@Param("idsensore") Long idsensore);
    
    @Query(value="SELECT * FROM temperature WHERE idsensore= :idsensore",nativeQuery=true)
    List<Temperature> getTemperatureById(@Param("idsensore") Long idsensore);

    @Query(value = "SELECT * FROM temperature WHERE idsensore= :idsensore AND timestamp BETWEEN :startTime AND :endTime", nativeQuery = true)
    List<Temperature> getTemperatureByDate(@Param("idsensore") Long idsensore,@Param("startTime")Timestamp startTime, @Param("endTime")Timestamp endTime);
   
 

   

    
}
