package edu.kea.paintings.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="artists")
@Entity
public class Artist {

    @Id
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String primaryStyle;

    @Column(length = 100)
    private String nationality;

    @Column
    private Gender gender;

}
