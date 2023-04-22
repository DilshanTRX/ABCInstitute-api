package com.abcinstitute.abcinstituteapi.dto.response;

import com.abcinstitute.abcinstituteapi.entity.Program;
import com.abcinstitute.abcinstituteapi.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentProgramResponseDto {
    private String id;
    private List<Student> student_student_id;
    private List<Program> program_program_id;
    private Date register_date;
}
