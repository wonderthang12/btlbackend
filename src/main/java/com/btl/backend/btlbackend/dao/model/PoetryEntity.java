package com.btl.backend.btlbackend.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

//Ca thi
@Entity
@Table(name = "poetry")
@Where(clause = "deleted=0")
@Setter
@Getter
public class PoetryEntity extends BaseEntity {

    @Id
    @GeneratedValue(generator = "poetry_generator")
    @SequenceGenerator(
            name = "poetry_generator",
            sequenceName = "poetry_sq",
            initialValue = 1
    )
    private Long id;

    @Column(name = "exam_date")
    private ZonedDateTime examDate;

    //Ca thi
    @Column(name = "time")
    private Integer time;

    @Column(name = "subject_name")
    private String subjectName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id", insertable = false, updatable = false)
    private SubjectEntity subject;

    @Column(name = "subject_id")
    private Long subjectId;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "poetry_student_list",
            joinColumns = {@JoinColumn(name = "poetry_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_list_id")})
    private Set<StudentListEntity> studentLists = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    private PoetryEntity room;

    @Column(name = "room_id")
    private Long roomId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "poetry")
    @JsonIgnore
    @NotFound(action = NotFoundAction.IGNORE)
    private Set<TeacherEntity> teachers = new HashSet<>();

    @Column(name = "poetry_code")
    private String poetryCode;
}
