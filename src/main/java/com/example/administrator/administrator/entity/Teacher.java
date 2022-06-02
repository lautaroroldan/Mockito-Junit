package com.example.administrator.administrator.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Teacher")
public class Teacher {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column (name = "name")
    private String name;

    @Column (name = "lastname")
    private String lastname;

    @Column (name = "age")
    private String age;

    @Column (name = "registrationnumber")
    private String registrationnumber;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "teacher_course",
            joinColumns = {@JoinColumn(name = "teacher_id")},
            inverseJoinColumns = {@JoinColumn(name = "curse_id")}
    )
    private List<Curse> curses;


}
