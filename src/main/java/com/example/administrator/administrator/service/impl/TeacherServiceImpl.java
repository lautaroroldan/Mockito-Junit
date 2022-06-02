package com.example.administrator.administrator.service.impl;


import com.example.administrator.administrator.converter.TeacherMapper;
import com.example.administrator.administrator.entity.Teacher;
import com.example.administrator.administrator.model.ModelTeacher;
import com.example.administrator.administrator.repository.TeacherJpaRepository;
import com.example.administrator.administrator.service.TeacherService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("TeacherServiceImpl")
public class TeacherServiceImpl implements TeacherService {

    private final static Log LOG = LogFactory.getLog(TeacherServiceImpl.class);

    @Autowired
    @Qualifier("TeacherJpaRepository")
    TeacherJpaRepository teacherJpaRepository;

    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    @Override
    public ModelTeacher addTeacher(ModelTeacher modelTeacher) {
        // lo convierto para poder agregarlo en el repository
        teacherJpaRepository.save(TeacherMapper.INSTANCE.toTeacherEntity(modelTeacher));
        return modelTeacher;
    }

    @Override
    public String deleteTeacher(long id) {
        teacherJpaRepository.deleteById(id);
        return "Se elimino correctamente";
    }

    @Override
    public ModelTeacher findById(long id) {
        Optional<Teacher> opt = teacherJpaRepository.findById(id);
        if (opt.isPresent()){
            LOG.info("El Teacher con el id :"+ id+" es "+ opt.get().toString());
            return TeacherMapper.INSTANCE.toModelTeacher(opt.get());
        }else {
            LOG.error("No se encontro Teacher con ese id");
            return new ModelTeacher();
        }

    }

    @Override
    public List<ModelTeacher> getAllTeachers() {
        List<Teacher> teachers = teacherJpaRepository.findAll();
        List<ModelTeacher> modelTeachers = new ArrayList<>();
        for (Teacher teacher : teachers){
            modelTeachers.add(TeacherMapper.INSTANCE.toModelTeacher(teacher));
        }
        return modelTeachers;
    }


}
