package com.example.Train_Springboot_project.Controller;


import com.example.Train_Springboot_project.Entity.Train;
import com.example.Train_Springboot_project.Entity.Trainschedule;
import com.example.Train_Springboot_project.Service.Trainsearchservice;
import com.example.Train_Springboot_project.Service.Trainservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@CrossOrigin(origins = "*")
public class Trainsearchcontroller {

    private Trainsearchservice trainsearchservice;

    public Trainsearchcontroller(Trainsearchservice trainsearchservice) {
        this.trainsearchservice = trainsearchservice;
    }

    @GetMapping("/by-code")
    public List<Trainschedule> findtrainbystationcode(@RequestParam String sourcecode, @RequestParam String destinationcode ){
        return trainsearchservice.findtrainbystationcode(sourcecode.toUpperCase(),destinationcode.toUpperCase());
    }

    @GetMapping("/by-name")
    public List<Trainschedule> findtrainbyStationname(@RequestParam String sourcename, @RequestParam String destinationname ){
        return trainsearchservice.findtrainbystationname(sourcename.toUpperCase(),destinationname.toUpperCase());
    }
}
