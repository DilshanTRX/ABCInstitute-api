package com.abcinstitute.abcinstituteapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name="program")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="program_id")
    private int program_id;
    @Column(name="program_name")
    private String program_name;
    @Column(name="program_duration")
    private String program_duration;
    @Column(name="program_cost")
    private double program_cost;


    @OneToMany(mappedBy = "programId")
    private List<StudentProgram> studentProgram;

}
