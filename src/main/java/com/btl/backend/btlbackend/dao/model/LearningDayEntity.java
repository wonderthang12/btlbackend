package com.btl.backend.btlbackend.dao.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//Ngay hoc
@Entity
@Table(name = "learning_day")
@Where(clause = "deleted=0")
@Setter
@Getter
public class LearningDayEntity extends BaseEntity {

    @Id
    @GeneratedValue(generator = "learning_day_generator")
    @SequenceGenerator(
            name = "learning_day_generator",
            sequenceName = "learning_day_sq",
            initialValue = 1
    )
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "learning_subject_day",
            joinColumns = {@JoinColumn(name = "learning_day_id")},
            inverseJoinColumns = {@JoinColumn(name = "subject_id")})
    private Set<SubjectEntity> subjects = new HashSet<>();

    //giai doan
    @Column(name = "stage")
    private Integer stage;

    //ky hoc
    @Column(name = "semester")
    private Integer semester;

    @OneToOne
    @JoinColumn(name = "teacher_id", insertable = false, updatable = false)
    private TeacherEntity teacher;

    @Column(name = "teacher_id")
    private Long teacherId;
}
