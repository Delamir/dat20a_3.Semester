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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "paintings_artists",
            joinColumns = {
                    @JoinColumn(name = "paintings_id", referencedColumnName = "id",
                            nullable = true, updatable = true)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "artists_id", referencedColumnName = "id",
                            nullable = true, updatable = true)
            }
    )
    private List<Artist> artists;
}