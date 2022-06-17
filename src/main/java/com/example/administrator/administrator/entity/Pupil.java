package com.example.administrator.administrator.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Pupil")
public class Pupil {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "age")
    private int age;

    @Column(name = "phonenumber")
    private int phonenumber;

    @ManyToOne
    @JoinColumn(name = "curse_id")
    private Curse curse;



    //TODO utiliza lombok para la creación automática de getters, setters y constructores

}
