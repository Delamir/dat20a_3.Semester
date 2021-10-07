package edu.kea.paintings.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "paintings")
@Entity
public class Painting {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Long id;

    @Column
    private String artist;

    @Column
    private double prices;

    @Column
    private String title;

    @Column
    private String genre;

    @Column
    private int year;
}