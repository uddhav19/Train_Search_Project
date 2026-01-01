package com.example.Train_Springboot_project.Repository;

import com.example.Train_Springboot_project.Entity.Trainschedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Trainschedulerepo extends JpaRepository<Trainschedule,Long> {
    List<Trainschedule> findBySource_StationcodeAndDestination_Stationcode(String sourceCode, String destinationCode);


    List<Trainschedule> findBySource_StationnameAndDestination_Stationname(String sourcename, String destinationname);

}
