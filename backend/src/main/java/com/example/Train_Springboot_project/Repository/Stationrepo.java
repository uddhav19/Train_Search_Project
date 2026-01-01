package com.example.Train_Springboot_project.Repository;

import com.example.Train_Springboot_project.Entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Stationrepo extends JpaRepository<Station, Long> {
}
