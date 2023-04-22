package com.abcinstitute.abcinstituteapi.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name="student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    private int student_id;

    @Column(name="student_name")
    private String student_name;
    @Column(name="student_address")
    private String student_address;
    @Column(name="student_contact")
    private String student_contact;

    @OneToMany(mappedBy = "studentId")
    private List<StudentProgram> studentProgram;
}
