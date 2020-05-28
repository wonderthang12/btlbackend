package com.btl.backend.btlbackend.dao.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

//Phong
@Entity
@Table(name = "room")
@Where(clause = "deleted=0")
@Setter
@Getter
public class RoomEntity extends BaseEntity {

    @Id
    @GeneratedValue(generator = "room_generator")
    @SequenceGenerator(
            name = "room_generator",
            sequenceName = "room_sq",
            initialValue = 1
    )
    private Long id;

    @Column(name = "seat")
    private Integer seats;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private Integer status;

    @OneToOne
    @JoinColumn(name = "poetry_id", insertable = false, updatable = false)
    private PoetryEntity poetry;

    @Column(name = "poetry_id")
    private Long poetryId;

    @Column(name = "room_code")
    private String roomCode;
}
