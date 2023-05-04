package com.t3.manytomany.entity;

import java.util.HashSet;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
@Getter @Setter @NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    private long id;

    private String firstName;
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "students_groups_relation", joinColumns = @JoinColumn(name="student_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="group_id", referencedColumnName = "id"))
    private Set<Group> groups = new HashSet<>();


    @Override
    public String toString() {
        return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
    
    
}
