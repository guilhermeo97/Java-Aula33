package com.t3.manytomany.entity;

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
    
}
