package com.btl.backend.btlbackend.dao.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//Khoa
@Entity
@Table(name = "faculty")
@Where(clause = "deleted=0")
@Setter
@Getter
public class FacultyEntity extends BaseEntity {

    @Id
    @GeneratedValue(generator = "faculty_generator")
    @SequenceGenerator(
            name = "faculty_generator",
            sequenceName = "faculty_sq",
            initialValue = 1
    )
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "classes_id", insertable = false, updatable = false)
    private ClassesEntity classes;

    @Column(name = "classes_id")
    private Long classesId;

    //Ma khoa
    @Column(name = "faculty_code")
    private String facultyCode;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
//    @JoinTable(name = "faculty_schedule",
//            joinColumns = {@JoinColumn(name = "faculty_id")},
//            inverseJoinColumns = {@JoinColumn(name = "schedule_id")})
//    private Set<ScheduleEntity> schedules = new HashSet<>();

}
