package com.example.administrator.administrator.model;

import com.example.administrator.administrator.entity.Curse;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ModelPupil  {

    private long id;
    private String name;
    private String lastName;
    private int age;
    private int phoneNumber;
    private ModelCurse curse;

}
