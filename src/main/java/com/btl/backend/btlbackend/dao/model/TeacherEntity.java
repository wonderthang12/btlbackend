package com.btl.backend.btlbackend.dao.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
@Where(clause = "deleted=0")
@Setter
@Getter
public class TeacherEntity extends BaseEntity {

    @Id
    @GeneratedValue(generator = "teacher_generator")
    @SequenceGenerator(
            name = "teacher_generator",
            sequenceName = "teacher_sq",
            initialValue = 1
    )
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "poetry_id", insertable = false, updatable = false)
    private PoetryEntity poetry;

    @Column(name = "poetry_id")
    private Long poetryId;

    @OneToOne
    @JoinColumn(name = "learning_day_id", insertable = false, updatable = false)
    private LearningDayEntity learningDay;

    @Column(name = "learning_day_id")
    private Long learningDayId;

    @OneToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity user;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "teacher_code")
    private String teacherCode;
}
