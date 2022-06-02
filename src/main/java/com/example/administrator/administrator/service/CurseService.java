package com.example.administrator.administrator.service;

import com.example.administrator.administrator.entity.Curse;
import com.example.administrator.administrator.entity.Teacher;
import com.example.administrator.administrator.model.ModelCurse;
import com.example.administrator.administrator.model.ModelPupil;
import com.example.administrator.administrator.model.ModelTeacher;

import java.util.List;

public interface CurseService {

     ModelCurse addCurse(ModelCurse modelCurse);
     String deleteCurse(long id);
     ModelCurse findById(long id);
     List<ModelCurse> getAllCurses();
}
