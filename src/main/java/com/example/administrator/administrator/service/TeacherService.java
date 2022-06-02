package com.example.administrator.administrator.service;


import com.example.administrator.administrator.entity.Teacher;
import com.example.administrator.administrator.model.ModelTeacher;

import java.util.List;

public interface TeacherService {

      ModelTeacher addTeacher(ModelTeacher modelTeacher);
      String deleteTeacher(long id);
      ModelTeacher findById(long id);
      List<ModelTeacher> getAllTeachers();

}
