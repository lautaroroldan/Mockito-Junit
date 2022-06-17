package com.example.administrator.administrator.service.impl;

import com.example.administrator.administrator.converter.PupilMapper;
import com.example.administrator.administrator.entity.Curse;
import com.example.administrator.administrator.entity.Pupil;
import com.example.administrator.administrator.model.ModelCurse;
import com.example.administrator.administrator.model.ModelPupil;
import com.example.administrator.administrator.repository.PupilJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PupilServiceImplTest {

    @Mock
    PupilJpaRepository pupilJpaRepository;

    @InjectMocks
    PupilServiceImpl pupilService;

    PupilMapper INSTANCE = Mappers.getMapper(PupilMapper.class);

    Pupil pupil;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void getAllPupils() {
        when(pupilJpaRepository.findAll()).thenReturn(Stream
                .of(new Pupil(2,"hola","como",22,2443,new Curse()),new Pupil(3,"soy","uma mrda",24,432424,new Curse())).collect(Collectors.toList()));
        Assertions.assertEquals(2,pupilService.getAllPupils().size());
    }

    @Test
    void addPupil(){
        ModelPupil modelPupil = new ModelPupil(2,"mrd","sisoy",2,3242,new ModelCurse());
        when(pupilJpaRepository.save(INSTANCE.toEntity(modelPupil))).thenReturn(INSTANCE.toEntity(modelPupil));
        assertEquals(modelPupil,pupilService.addPupil(modelPupil));
    }
}