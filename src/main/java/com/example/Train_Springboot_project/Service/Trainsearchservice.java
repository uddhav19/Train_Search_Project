package com.example.Train_Springboot_project.Service;

import com.example.Train_Springboot_project.Entity.Trainschedule;
import com.example.Train_Springboot_project.Repository.Trainschedulerepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Trainsearchservice {

    private Trainschedulerepo trainschedulerepo;


    public Trainsearchservice(Trainschedulerepo trainschedulerepo){
        this.trainschedulerepo=trainschedulerepo;
    }

    public List<Trainschedule> findtrainbystationcode(String sourcecode, String destinationcode) {

        return trainschedulerepo.findBySource_StationcodeAndDestination_Stationcode(sourcecode,destinationcode);
    }

    public List<Trainschedule> findtrainbystationname(String sourcename, String destinationname) {
        return trainschedulerepo.
        findBySource_StationnameAndDestination_Stationname(sourcename,destinationname);

    }
}
