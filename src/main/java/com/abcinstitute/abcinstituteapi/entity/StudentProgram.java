package com.abcinstitute.abcinstituteapi.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "student_has_program")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public  class StudentProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="student_student_id")
    private Student studentId;

    @ManyToOne
    @JoinColumn(name="program_program_id")
    private Program programId;


    private Date register_date;

}
