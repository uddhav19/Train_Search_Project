package com.example.Train_Springboot_project.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trainname;
    private String trainnumber;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Trainschedule> trainscheduleList;

    public Train(){
    }

    public Train(Long id, String trainname, String trainnumber, List<Trainschedule> trainscheduleList) {
        this.id = id;
        this.trainname = trainname;
        this.trainnumber = trainnumber;
        this.trainscheduleList = trainscheduleList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrainname() {
        return trainname;
    }

    public void setTrainname(String trainname) {
        this.trainname = trainname;
    }

    public String getTrainnumber() {
        return trainnumber;
    }

    public void setTrainnumber(String trainnumber) {
        this.trainnumber = trainnumber;
    }

    public List<Trainschedule> getTrainscheduleList() {
        return trainscheduleList;
    }

    public void setTrainscheduleList(List<Trainschedule> trainscheduleList) {
        this.trainscheduleList = trainscheduleList;
    }
}
