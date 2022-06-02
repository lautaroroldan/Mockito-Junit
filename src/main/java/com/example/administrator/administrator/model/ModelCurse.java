package com.example.administrator.administrator.model;
import com.example.administrator.administrator.entity.Pupil;
import com.example.administrator.administrator.entity.Teacher;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ModelCurse {

    private long id;
    private String name;
    private String division;
    private List<ModelPupil> pupilList;
    private List<ModelTeacher> teacherList;


}
