package com.example.Train_Springboot_project.Repository;

import com.example.Train_Springboot_project.Entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Trainrepo extends JpaRepository<Train,Long> {
}
