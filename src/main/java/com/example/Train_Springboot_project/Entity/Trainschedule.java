package com.example.Train_Springboot_project.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class Trainschedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "train_id")
    @JsonManagedReference
    private Train train;

    @ManyToOne
    @JoinColumn(name = "source_station_id")
    private Station source;

    @ManyToOne
    @JoinColumn(name = "destination_station_id")
    private Station destination;

    private String arrivaltime;
    private String departuretimetime;


    public Trainschedule(){

    }

    public Trainschedule(Long id, Train train, Station source, Station destination, String arrivaltime, String departuretimetime) {
        this.id = id;
        this.train = train;
        this.source = source;
        this.destination = destination;
        this.arrivaltime = arrivaltime;
        this.departuretimetime = departuretimetime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Station getSource() {
        return source;
    }

    public void setSource(Station source) {
        this.source = source;
    }

    public Station getDestination() {
        return destination;
    }

    public void setDestination(Station destination) {
        this.destination = destination;
    }

    public String getArrivaltime() {
        return arrivaltime;
    }

    public void setArrivaltime(String arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    public String getDeparturetimetime() {
        return departuretimetime;
    }

    public void setDeparturetimetime(String departuretimetime) {
        this.departuretimetime = departuretimetime;
    }
}
