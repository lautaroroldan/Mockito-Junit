package com.example.administrator.administrator.entity;

import com.example.administrator.administrator.model.ModelPupil;
import com.example.administrator.administrator.model.ModelTeacher;
import lombok.*;
import org.springframework.ui.Model;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "curse")
public class Curse {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "division")
    private String division;

    @ManyToMany(mappedBy = "curses")
    private List<Teacher> teacherList;

    @OneToMany(mappedBy = "curse")
    private List<Pupil> pupilList;


}


