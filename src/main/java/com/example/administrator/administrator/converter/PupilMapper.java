package com.example.administrator.administrator.converter;

import com.example.administrator.administrator.entity.Curse;
import com.example.administrator.administrator.entity.Pupil;
import com.example.administrator.administrator.model.ModelCurse;
import com.example.administrator.administrator.model.ModelPupil;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface PupilMapper {
    PupilMapper INSTANCE = Mappers.getMapper(PupilMapper.class);

    Pupil toEntity(ModelPupil modelPupil);

    ModelPupil toModelPupil(Pupil pupil);

//    default List<ModelPupil> toModelPupilList(List<Pupil> pupils){
//        if(pupils== null){
//            return new ArrayList<>();
//        }
//        return pupils.stream().map(this::toModelPupil).collect(Collectors.toList());
//    }

}
