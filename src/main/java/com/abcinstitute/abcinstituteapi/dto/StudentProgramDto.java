package com.abcinstitute.abcinstituteapi.dto;

import com.abcinstitute.abcinstituteapi.entity.Program;
import com.abcinstitute.abcinstituteapi.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentProgramDto {

    private String id;

    private Student student_student_id;

    private Program program_program_id;


    private Date register_date;
}
