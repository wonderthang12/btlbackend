package com.btl.backend.btlbackend.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

//Mon hoc
@Entity
@Table(name = "subject")
@Where(clause = "deleted=0")
@Setter
@Getter
public class SubjectEntity extends BaseEntity {

    @Id
    @GeneratedValue(generator = "subject_generator")
    @SequenceGenerator(
            name = "subject_generator",
            sequenceName = "subject_sq",
            initialValue = 1
    )
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "method_of_examination")
    private String methodOfExamination;

    @Column(name = "time_of_examination")
    private ZonedDateTime timeOfExamination;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "subject_learning_day",
            joinColumns = {@JoinColumn(name = "subject_id")},
            inverseJoinColumns = {@JoinColumn(name = "learning_day_id")})
    private Set<LearningDayEntity> learningDays = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "subject_schedule",
            joinColumns = {@JoinColumn(name = "subject_id")},
            inverseJoinColumns = {@JoinColumn(name = "schedule_id")})
    private Set<ScheduleEntity> schedules = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,
            fetch = FetchType.LAZY, mappedBy = "subject")
    @JsonIgnore
    @NotFound(action = NotFoundAction.IGNORE)
    private Set<PoetryEntity> poetries = new HashSet<>();

    @Column(name = "subject_code")
    private String subjectCode;
}
