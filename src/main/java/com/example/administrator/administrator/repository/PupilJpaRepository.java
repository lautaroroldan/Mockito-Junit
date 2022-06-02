package com.example.administrator.administrator.repository;

import com.example.administrator.administrator.entity.Pupil;
import com.example.administrator.administrator.model.ModelPupil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("pupilJpaRepository")
public interface PupilJpaRepository extends JpaRepository<Pupil, Serializable> {

}
