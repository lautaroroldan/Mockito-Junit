package com.example.administrator.administrator.converter;

import com.example.administrator.administrator.entity.Curse;
import com.example.administrator.administrator.model.ModelCurse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface CurseMapper {
    CurseMapper INSTANCE = Mappers.getMapper(CurseMapper.class);

    Curse toEntity(ModelCurse modelCurse);

    ModelCurse toModelCurse(Curse curse);


//    default List<ModelCurse> toModelCurseList(List<Curse> curses){
//        if(curses== null){
//            return new ArrayList<>();
//        }
//        return curses.stream().map(this::toModelCurse).collect(Collectors.toList());
//    }



}
