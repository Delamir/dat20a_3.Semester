package edu.kea.paintings.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "galleries")
@Entity
public class Gallery {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Long id;

    @Column
    private String owner;

    @Column
    private String name;

    @Column
    private String location;

    @Column
    private int squareFeet;

}
