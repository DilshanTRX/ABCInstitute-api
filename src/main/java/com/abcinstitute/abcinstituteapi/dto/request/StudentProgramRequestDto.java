package com.abcinstitute.abcinstituteapi.dto.request;

import com.abcinstitute.abcinstituteapi.entity.Program;
import com.abcinstitute.abcinstituteapi.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentProgramRequestDto {
    private List<Student> student_student_id;
    private List<Program> program_program_id;
    private Date register_date;
}
