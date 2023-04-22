package com.abcinstitute.abcinstituteapi.util.mapper;

import com.abcinstitute.abcinstituteapi.dto.ProgramDto;
import com.abcinstitute.abcinstituteapi.entity.Program;
import com.abcinstitute.abcinstituteapi.dto.response.ProgramResponseDto;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ProgramMapper {
    Program toProgram(ProgramDto dto);
    ProgramResponseDto toProgramResponseDto(Program program);
    List<ProgramResponseDto> toProgramResponseDtoList(List<Program>list);
}
