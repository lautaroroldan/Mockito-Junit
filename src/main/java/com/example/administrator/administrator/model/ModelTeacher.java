package com.example.administrator.administrator.model;

import com.example.administrator.administrator.entity.Curse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ModelTeacher {

    private long id;
    private String name;
    private String lastName;
    private String age;
    private String registrationNumber;
    private List<Curse> curses;


}
