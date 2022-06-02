package com.example.administrator.administrator.repository;

import com.example.administrator.administrator.entity.Teacher;
import com.example.administrator.administrator.model.ModelTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository ("TeacherJpaRepository")
public interface TeacherJpaRepository extends JpaRepository<Teacher, Serializable> {
}
