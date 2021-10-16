package edu.kea.paintings.models;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

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

    @JsonIgnore
    @OneToMany(mappedBy = "gallery", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Artist> artists;

}
