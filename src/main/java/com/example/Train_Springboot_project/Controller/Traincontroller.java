package com.example.Train_Springboot_project.Controller;

import com.example.Train_Springboot_project.Entity.Train;
import com.example.Train_Springboot_project.Service.Trainservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/train")
@CrossOrigin(origins = "*")
public class Traincontroller {

    private Trainservice trainservice;

    public Traincontroller(Trainservice trainservice) {
        this.trainservice = trainservice;
    }


    @GetMapping
    public List<Train> getAlltrains(){
        return trainservice.getAlltrains();
    }


    @PostMapping
    public Train addTrain(@RequestBody Train train){
        return  trainservice.addtrain(train);
    }
}
