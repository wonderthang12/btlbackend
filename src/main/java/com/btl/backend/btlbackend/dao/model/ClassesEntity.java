package com.btl.backend.btlbackend.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//Lop
@Entity
@Table(name = "classes")
@Where(clause = "deleted=0")
@Setter
@Getter
public class ClassesEntity extends BaseEntity {

    @Id
    @GeneratedValue(generator = "classes_generator")
    @SequenceGenerator(
            name = "classes_generator",
            sequenceName = "classes_sq",
            initialValue = 1
    )
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,
            fetch = FetchType.LAZY, mappedBy = "classes")
    @JsonIgnore
    @NotFound(action = NotFoundAction.IGNORE)
    private Set<FacultyEntity> faculties = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,
            fetch = FetchType.LAZY, mappedBy = "classes")
    @JsonIgnore
    @NotFound(action = NotFoundAction.IGNORE)
    private Set<StudentEntity> students = new HashSet<>();

    //Ma lop
    @Column(name = "classes_code")
    private String classesCode;

}
