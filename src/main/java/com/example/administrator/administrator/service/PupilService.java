package com.example.administrator.administrator.service;


import com.example.administrator.administrator.entity.Pupil;
import com.example.administrator.administrator.entity.Teacher;
import com.example.administrator.administrator.model.ModelPupil;
import com.example.administrator.administrator.model.ModelTeacher;

import java.util.List;

public interface PupilService {

    //TODO las interfaces siempre son publicas.
    ModelPupil addPupil(ModelPupil modelPupil);
    String deletePupil(long id);
    ModelPupil findById(long id);
    List<ModelPupil> getAllPupils();

}
