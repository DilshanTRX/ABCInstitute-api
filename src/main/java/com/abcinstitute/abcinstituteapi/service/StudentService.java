package com.abcinstitute.abcinstituteapi.service;

import com.abcinstitute.abcinstituteapi.dto.request.StudentRequestDto;
import com.abcinstitute.abcinstituteapi.dto.response.StudentResponseDto;
import com.abcinstitute.abcinstituteapi.dto.response.paginate.PaginatedStudentResponseDto;

public interface StudentService {
    public String saveStudent(StudentRequestDto dto);
    public StudentResponseDto findStudent(int id) throws ClassNotFoundException;
    public String updateStudent(StudentRequestDto dto, int id) throws ClassNotFoundException;
    public String deleteStudent(int id);
    public PaginatedStudentResponseDto findAllStudent(
            String searchText, int page, int size
    );
}
