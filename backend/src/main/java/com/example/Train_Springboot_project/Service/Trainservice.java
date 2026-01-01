package com.example.Train_Springboot_project.Service;


import com.example.Train_Springboot_project.Entity.Train;
import com.example.Train_Springboot_project.Repository.Trainrepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Trainservice {

    private Trainrepo trainrepo;

    public Trainservice(Trainrepo trainrepo) {
        this.trainrepo = trainrepo;
    }


    public List<Train> getAlltrains() {
        return trainrepo.findAll();
    }

    public Train addtrain(Train train) {
        return trainrepo.save(train);

    }
}
