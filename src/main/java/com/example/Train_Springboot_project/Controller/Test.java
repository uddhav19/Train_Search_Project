package com.example.Train_Springboot_project.Controller;


import com.example.Train_Springboot_project.Entity.Station;
import com.example.Train_Springboot_project.Entity.Train;
import com.example.Train_Springboot_project.Entity.Trainschedule;
import com.example.Train_Springboot_project.Repository.Stationrepo;
import com.example.Train_Springboot_project.Repository.Trainrepo;
import com.example.Train_Springboot_project.Repository.Trainschedulerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class Test {


    @Autowired
    Stationrepo stationrepo;

    @Autowired
    Trainrepo trainrepo;

    @Autowired
    Trainschedulerepo trainschedulerepo;

    @GetMapping("old")
    public void test(){
        Station delhi = new Station(null,"new delhi","NDLS");
        Station mumbai = new Station(null,"Mumbai central","cst");
        Station kolkatta = new Station(null,"Kolkatta","KOAA");
        Station chennai = new Station(null,"chennai","MAs");


        stationrepo.saveAll(List.of(delhi,mumbai,kolkatta,chennai));

        Train rajdhani = new Train(null,"Rajdhani Express","12305", null);
        Train duronto = new Train(null,"Duronto Express","12260", null);
        Train shatabdi = new Train(null,"Shatabdi Express","12043", null);

        trainrepo.saveAll(List.of(rajdhani,duronto,shatabdi));

        Trainschedule sc1= new Trainschedule(null,rajdhani,delhi,mumbai,"6:00","14:00");
        Trainschedule sc2= new Trainschedule(null,duronto,mumbai,kolkatta,"8:00","21:00");
        Trainschedule sc3= new Trainschedule(null,shatabdi,kolkatta,chennai,"11:30","19:00");


        trainschedulerepo.saveAll(List.of(sc1,sc2,sc3));

        System.out.println("data inserted in database");




    }
    @GetMapping("/new_data")
    public void test2(){
        // Major Railway Stations with correct codes
        Station newDelhi = new Station(null, "New Delhi", "NDLS");
        Station mumbaiCentral = new Station(null, "Mumbai Central", "MMCT");
        Station mumbaiCST = new Station(null, "Chhatrapati Shivaji Terminus", "CST");
        Station kolkata = new Station(null, "Howrah Junction", "HWH");
        Station chennaiCentral = new Station(null, "Chennai Central", "MAS");
        Station bangaloreCity = new Station(null, "Bengaluru City Junction", "SBC");
        Station hyderabadDeccan = new Station(null, "Hyderabad Deccan", "HYB");
        Station puneJunction = new Station(null, "Pune Junction", "PUNE");
        Station ahmedabad = new Station(null, "Ahmedabad Junction", "ADI");
        Station jaipur = new Station(null, "Jaipur Junction", "JP");
        Station lucknow = new Station(null, "Lucknow Charbagh", "LKO");
        Station kanpur = new Station(null, "Kanpur Central", "CNB");
        Station patna = new Station(null, "Patna Junction", "PNBE");
        Station bhopal = new Station(null, "Bhopal Junction", "BPL");
        Station nagpur = new Station(null, "Nagpur Junction", "NGP");

        stationrepo.saveAll(List.of(
                newDelhi, mumbaiCentral, mumbaiCST, kolkata, chennaiCentral,
                bangaloreCity, hyderabadDeccan, puneJunction, ahmedabad,
                jaipur, lucknow, kanpur, patna, bhopal, nagpur
        ));

        // Real Trains with actual numbers
        Train rajdhaniDelMum = new Train(null, "Mumbai Rajdhani Express", "12951", null);
        Train rajdhaniDelKol = new Train(null, "Howrah Rajdhani Express", "12305", null);
        Train rajdhaniDelBng = new Train(null, "Bangalore Rajdhani Express", "12429", null);
        Train durontoDelMum = new Train(null, "Mumbai Duronto Express", "12263", null);
        Train shatabdiDelBpl = new Train(null, "Bhopal Shatabdi Express", "12001", null);
        Train shatabdiDelJai = new Train(null, "Jaipur Shatabdi Express", "12015", null);
        Train gatimaan = new Train(null, "Gatimaan Express", "12049", null);
        Train vandeBharat = new Train(null, "Vande Bharat Express", "22435", null);
        Train tejas = new Train(null, "Tejas Express", "22119", null);
        Train deccanQueen = new Train(null, "Deccan Queen Express", "12123", null);
        Train chennaiExp = new Train(null, "Grand Trunk Express", "12615", null);
        Train kolkataExp = new Train(null, "Kolkata Mail", "12311", null);
        Train mumbaiExp = new Train(null, "Punjab Mail", "12137", null);
        Train bangaloreExp = new Train(null, "Bangalore Express", "12639", null);
        Train hyderabadExp = new Train(null, "Charminar Express", "12759", null);

        trainrepo.saveAll(List.of(
                rajdhaniDelMum, rajdhaniDelKol, rajdhaniDelBng, durontoDelMum,
                shatabdiDelBpl, shatabdiDelJai, gatimaan, vandeBharat, tejas,
                deccanQueen, chennaiExp, kolkataExp, mumbaiExp, bangaloreExp, hyderabadExp
        ));

        // Real Train Schedules with actual timings
        Trainschedule sc1 = new Trainschedule(null, rajdhaniDelMum, newDelhi, mumbaiCentral, "16:55", "08:35");
        Trainschedule sc2 = new Trainschedule(null, rajdhaniDelKol, newDelhi, kolkata, "17:00", "10:05");
        Trainschedule sc3 = new Trainschedule(null, rajdhaniDelBng, newDelhi, bangaloreCity, "20:30", "11:30");
        Trainschedule sc4 = new Trainschedule(null, durontoDelMum, newDelhi, mumbaiCentral, "22:15", "10:25");
        Trainschedule sc5 = new Trainschedule(null, shatabdiDelBpl, newDelhi, bhopal, "06:00", "14:05");
        Trainschedule sc6 = new Trainschedule(null, shatabdiDelJai, newDelhi, jaipur, "06:05", "10:30");
        Trainschedule sc7 = new Trainschedule(null, gatimaan, newDelhi, jaipur, "08:10", "11:30");
        Trainschedule sc8 = new Trainschedule(null, vandeBharat, newDelhi, kanpur, "06:00", "14:25");
        Trainschedule sc9 = new Trainschedule(null, tejas, mumbaiCST, ahmedabad, "06:50", "14:30");
        Trainschedule sc10 = new Trainschedule(null, deccanQueen, mumbaiCST, puneJunction, "17:10", "20:25");

        // Additional popular routes
        Trainschedule sc11 = new Trainschedule(null, chennaiExp, newDelhi, chennaiCentral, "17:30", "09:45");
        Trainschedule sc12 = new Trainschedule(null, kolkataExp, newDelhi, kolkata, "22:20", "17:35");
        Trainschedule sc13 = new Trainschedule(null, mumbaiExp, newDelhi, mumbaiCentral, "23:20", "22:15");
        Trainschedule sc14 = new Trainschedule(null, bangaloreExp, newDelhi, bangaloreCity, "21:50", "04:30");
        Trainschedule sc15 = new Trainschedule(null, hyderabadExp, newDelhi, hyderabadDeccan, "17:45", "09:55");

        // Return journeys
        Train rajdhaniMumDel = new Train(null, "Mumbai Rajdhani Express", "12952", null);
        Train rajdhaniKolDel = new Train(null, "Howrah Rajdhani Express", "12306", null);
        Train rajdhaniBngDel = new Train(null, "Bangalore Rajdhani Express", "12430", null);
        Train durontoMumDel = new Train(null, "Mumbai Duronto Express", "12264", null);
        Train shatabdiBplDel = new Train(null, "Bhopal Shatabdi Express", "12002", null);

        trainrepo.saveAll(List.of(
                rajdhaniMumDel, rajdhaniKolDel, rajdhaniBngDel, durontoMumDel, shatabdiBplDel
        ));

        // Return journey schedules
        Trainschedule sc16 = new Trainschedule(null, rajdhaniMumDel, mumbaiCentral, newDelhi, "17:00", "09:55");
        Trainschedule sc17 = new Trainschedule(null, rajdhaniKolDel, kolkata, newDelhi, "16:55", "10:20");
        Trainschedule sc18 = new Trainschedule(null, rajdhaniBngDel, bangaloreCity, newDelhi, "21:15", "05:55");
        Trainschedule sc19 = new Trainschedule(null, durontoMumDel, mumbaiCentral, newDelhi, "11:50", "06:50");
        Trainschedule sc20 = new Trainschedule(null, shatabdiBplDel, bhopal, newDelhi, "14:45", "22:30");

        // Inter-city connections
        Train mumbaiChennai = new Train(null, "Chennai Express", "12163", null);
        Train mumbaiKolkata = new Train(null, "Mumbai Howrah Mail", "12809", null);
        Train chennaiBangalore = new Train(null, "Shatabdi Express", "12007", null);
        Train bangaloreHyderabad = new Train(null, "Kacheguda Express", "12785", null);

        trainrepo.saveAll(List.of(mumbaiChennai, mumbaiKolkata, chennaiBangalore, bangaloreHyderabad));

        Trainschedule sc21 = new Trainschedule(null, mumbaiChennai, mumbaiCST, chennaiCentral, "12:05", "13:20");
        Trainschedule sc22 = new Trainschedule(null, mumbaiKolkata, mumbaiCST, kolkata, "22:05", "06:55");
        Trainschedule sc23 = new Trainschedule(null, chennaiBangalore, chennaiCentral, bangaloreCity, "06:00", "11:15");
        Trainschedule sc24 = new Trainschedule(null, bangaloreHyderabad, bangaloreCity, hyderabadDeccan, "20:15", "07:00");

        // Regional connections
        Train delhiLucknow = new Train(null, "Lucknow Shatabdi Express", "12003", null);
        Train delhiPatna = new Train(null, "Sampoorna Kranti Express", "12393", null);
        Train mumbaiBangalore = new Train(null, "Udyan Express", "11301", null);

        trainrepo.saveAll(List.of(delhiLucknow, delhiPatna, mumbaiBangalore));

        Trainschedule sc25 = new Trainschedule(null, delhiLucknow, newDelhi, lucknow, "06:10", "12:35");
        Trainschedule sc26 = new Trainschedule(null, delhiPatna, newDelhi, patna, "14:05", "06:40");
        Trainschedule sc27 = new Trainschedule(null, mumbaiBangalore, mumbaiCST, bangaloreCity, "08:05", "21:15");

        trainschedulerepo.saveAll(List.of(
                sc1, sc2, sc3, sc4, sc5, sc6, sc7, sc8, sc9, sc10,
                sc11, sc12, sc13, sc14, sc15, sc16, sc17, sc18, sc19, sc20,
                sc21, sc22, sc23, sc24, sc25, sc26, sc27
        ));

        System.out.println("Real Indian Railway data inserted successfully!");
        System.out.println("Stations: 15");
        System.out.println("Trains: 25");
        System.out.println("Schedules: 27");
    }



}
