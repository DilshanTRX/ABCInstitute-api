package com.abcinstitute.abcinstituteapi.util.mapper;

import com.abcinstitute.abcinstituteapi.dto.StudentDto;
import com.abcinstitute.abcinstituteapi.entity.Student;
import com.abcinstitute.abcinstituteapi.dto.response.StudentResponseDto;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toStudent(StudentDto dto);
    StudentResponseDto toStudentResponseDto(Student student);
    List<StudentResponseDto> toStudentResponseDtoList(List<Student>list);
}
