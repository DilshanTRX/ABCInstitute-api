package com.abcinstitute.abcinstituteapi.service;


import com.abcinstitute.abcinstituteapi.dto.request.StudentProgramRequestDto;
import com.abcinstitute.abcinstituteapi.dto.response.StudentProgramResponseDto;
import com.abcinstitute.abcinstituteapi.dto.response.paginate.PaginatedStudentProgramResponseDto;

public interface StudentProgramService {
    public String saveStudentProgram(StudentProgramRequestDto dto, int student_id, int program_id) throws ClassNotFoundException;
//    public StudentProgramResponseDto findStudentProgram(int id) throws ClassNotFoundException;
//    public String updateStudentProgram(StudentProgramRequestDto dto, int id) throws ClassNotFoundException;
//    public String deleteStudentProgram(int id);
//    public PaginatedStudentProgramResponseDto findAllStudentProgram(
//            String searchText, int page, int size
//    );
}
