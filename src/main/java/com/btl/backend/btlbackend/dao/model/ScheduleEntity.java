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

//Lich hoc
@Entity
@Table(name = "schedule")
@Where(clause = "deleted=0")
@Setter
@Getter
public class ScheduleEntity extends BaseEntity {

    @Id
    @GeneratedValue(generator = "schedule_generator")
    @SequenceGenerator(
            name = "schedule_generator",
            sequenceName = "schedule_sq",
            initialValue = 1
    )
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private StudentEntity student;

    @Column(name = "student_id")
    private Long studentId;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "schedule_subject",
            joinColumns = {@JoinColumn(name = "schedule_id")},
            inverseJoinColumns = {@JoinColumn(name = "subject_id")})
    private Set<SubjectEntity> subjects = new HashSet<>();

}
