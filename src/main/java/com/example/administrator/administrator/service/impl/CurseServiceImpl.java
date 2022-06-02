package com.example.administrator.administrator.service.impl;

import com.example.administrator.administrator.converter.CurseMapper;
import com.example.administrator.administrator.entity.Curse;
import com.example.administrator.administrator.model.ModelCurse;
import com.example.administrator.administrator.repository.CurseJpaRepository;
import com.example.administrator.administrator.service.CurseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("CurseServiceImpl")
public class CurseServiceImpl implements CurseService {

    @Autowired
    @Qualifier("CurseJpaRepository")
    CurseJpaRepository curseJpaRepository;


    CurseMapper INSTANCE = Mappers.getMapper(CurseMapper.class);

    private final static Log LOG = LogFactory.getLog(CurseServiceImpl.class);

    @Override
    public ModelCurse addCurse(ModelCurse modelCurse) {
        LOG.info("Estoy en el addCurse de Service Impl");
        curseJpaRepository.save(CurseMapper.INSTANCE.toEntity(modelCurse));
        return modelCurse;
    }

    @Override
    public String deleteCurse(long id) {
            curseJpaRepository.deleteById(id);
        return "Se elimino correctamente";
    }

    @Override
    public ModelCurse findById(long id) {
        Optional<Curse> opt = curseJpaRepository.findById(id);
        if (opt.isPresent()){
            return CurseMapper.INSTANCE.toModelCurse(opt.get());
        }else {
            LOG.error("No se encontro el Curse buscado y se retorna un obj vacio");
            return new ModelCurse();
        }
    }

    @Override
    public List<ModelCurse> getAllCurses() {
        List<Curse> curses = curseJpaRepository.findAll();
        List<ModelCurse> modelCurseList = new ArrayList<>();
        for (Curse curse : curses){
            modelCurseList.add(CurseMapper.INSTANCE.toModelCurse(curse));
        }
        return modelCurseList;
    }

}
