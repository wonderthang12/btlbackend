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

@Entity
@Table(name = "student_list")
@Where(clause = "deleted=0")
@Setter
@Getter
public class StudentListEntity extends BaseEntity {

    @Id
    @GeneratedValue(generator = "student_list_generator")
    @SequenceGenerator(
            name = "student_list_generator",
            sequenceName = "student_list_sq",
            initialValue = 1
    )
    private Long id;

    @Column(name = "identification_number")
    private String identificationNumber;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,
            fetch = FetchType.LAZY, mappedBy = "studentList")
    @JsonIgnore
    @NotFound(action = NotFoundAction.IGNORE)
    private Set<StudentEntity> students = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "student_list_poetry",
            joinColumns = {@JoinColumn(name = "student_list_id")},
            inverseJoinColumns = {@JoinColumn(name = "poetry_id")})
    private Set<PoetryEntity> poetries = new HashSet<>();
}
