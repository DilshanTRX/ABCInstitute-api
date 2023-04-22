package com.abcinstitute.abcinstituteapi.util.mapper;

import com.abcinstitute.abcinstituteapi.dto.StudentProgramDto;
import com.abcinstitute.abcinstituteapi.entity.StudentProgram;
import com.abcinstitute.abcinstituteapi.dto.response.StudentProgramResponseDto;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentProgramMapper {
//   StudentProgram toStudentProgram(StudentProgramDto dto);
//   StudentProgramResponseDto toStudentProgramResponseDto(StudentProgram studentprogram);
//   List<StudentProgramResponseDto> toStudentProgramResponseDtoList(List<StudentProgram>list);


   StudentProgram toStudentProgram(StudentProgramDto dto);
   StudentProgramResponseDto toStudentProgramResponseDto(StudentProgram studentprogram);
   List<StudentProgramResponseDto> toStudentProgramResponseDtoList(List<StudentProgram> list);

}
