package com.t3.manytomany.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "groups")
@Getter @Setter @NoArgsConstructor
public class Group {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
    fetch = FetchType.EAGER,
    mappedBy = "groups"
    )
    private Set<Student> students = new HashSet<>();
}
