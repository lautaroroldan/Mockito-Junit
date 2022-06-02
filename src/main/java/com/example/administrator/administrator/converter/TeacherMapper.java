package com.example.administrator.administrator.converter;

import com.example.administrator.administrator.entity.Teacher;
import com.example.administrator.administrator.model.ModelTeacher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    Teacher toTeacherEntity(ModelTeacher modelTeacher);

    ModelTeacher toModelTeacher(Teacher teacher);

}
