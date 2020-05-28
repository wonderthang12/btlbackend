package com.btl.backend.btlbackend.dao.model;

import com.btl.backend.btlbackend.enums.BlockEnum;
import com.btl.backend.btlbackend.enums.GenderEnum;
import com.btl.backend.btlbackend.enums.UserTypeEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Where(clause = "deleted=0")
@Setter
@Getter
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(generator = "user_generator")
    @SequenceGenerator(
            name = "user_generator",
            sequenceName = "user_sq",
            initialValue = 1
    )
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private GenderEnum gender;

    @Column(name = "avatar", columnDefinition = "TEXT")
    private String avatar;

    @Column(name = "block")
    private BlockEnum block;

    @Column(name = "user_type")
    private UserTypeEnum userType;

    @Column(name = "salt")
    @Audited
    private String salt;

    @Transient
    private String loginToken;

    @OneToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private StudentEntity student;

    @Column(name = "student_id")
    private Long studentId;

    @OneToOne
    @JoinColumn(name = "teacher_id", insertable = false, updatable = false)
    private TeacherEntity teacher;

    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "user_code")
    private String userCode;
}
