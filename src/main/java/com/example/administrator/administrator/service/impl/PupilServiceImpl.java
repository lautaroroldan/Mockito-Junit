package com.example.administrator.administrator.service.impl;

import com.example.administrator.administrator.converter.PupilMapper;
import com.example.administrator.administrator.entity.Pupil;
import com.example.administrator.administrator.model.ModelPupil;
import com.example.administrator.administrator.repository.PupilJpaRepository;
import com.example.administrator.administrator.service.PupilService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("PupilServiceImpl")
public class PupilServiceImpl implements PupilService {

    private final static Log LOG = LogFactory.getLog(PupilServiceImpl.class);

    @Autowired
    @Qualifier("pupilJpaRepository")
    PupilJpaRepository pupilJpaRepository;

    PupilMapper INSTANCE = Mappers.getMapper(PupilMapper.class);

    @Override
    public ModelPupil addPupil(ModelPupil modelPupil) {
        pupilJpaRepository.save(PupilMapper.INSTANCE.toEntity(modelPupil));
        return modelPupil;
    }

    @Override
    public String deletePupil(long id) {
        pupilJpaRepository.deleteById(id);
        return "Se elimino correctamente";
    }

    @Override
    public ModelPupil findById(long id) {
        Optional<Pupil> opt = pupilJpaRepository.findById(id);
        if(opt.isPresent()){
            return PupilMapper.INSTANCE.toModelPupil(opt.get());
        }
        LOG.error("No se encontro el Pupil buscado y se retorna un obj vacio");
        return new ModelPupil();
    }

    @Override
    public List<ModelPupil> getAllPupils() {
        List<Pupil> pupils = pupilJpaRepository.findAll();
        List<ModelPupil> modelPupilList = new ArrayList<>();
        for (Pupil pupil : pupils){
            modelPupilList.add(PupilMapper.INSTANCE.toModelPupil(pupil));
        }
        return modelPupilList;
    }


}
